package club.lovemo.Dao.Impl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseDao {
	public static String DRIVER;
	public static String URL;
	static {
		try {
			Properties properties = new Properties();
			InputStream inputStream = BaseDao.class
					.getResourceAsStream("config.properties");
			properties.load(inputStream);
			DRIVER = properties.getProperty("driver");
			URL = properties.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* public static void main(String[] args) {
	 BaseDao bd = new BaseDao();
	 PreparedStatement pstmt = null;
	 ResultSet rse = null;
	 String str = "select * from Users";
	 try {
	 pstmt =bd.getConn().prepareStatement(str);
	 rse = pstmt.executeQuery();
	 while (rse.next()) {
	 String uname = rse.getString(2);
	 String upassWord = rse.getString(3);
	 System.out.println("name:"+uname +"\tpaw:"+upassWord);
	 }
	 } catch (SQLException e) {
	 e.printStackTrace();
	 } finally {
	 bd.closeAll(bd.getConn(), pstmt, rse);
	 }
	 }*/

	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean operUpdate(String sql, List<Object> params) {
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rse = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rse);
		}
		return res > 0 ? true : false;
	}
	/**
	 * ʹ�÷��ͺͷ��������з�װ
	 * 
	 * Person.class
	 */
	public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls)
			throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rse = null;
		List<T> data = new ArrayList<T>();
		try {
			conn = getConn();// �������ݿ�����
			pstmt = conn.prepareStatement(sql);// װ��SQL���
			if (params != null) {
				// �����У���sql��䣬��ȥ��ȫ
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rse = pstmt.executeQuery();
			ResultSetMetaData rsd = rse.getMetaData();// �õ����Ԫ����
			// ���Ի�ñ�Ľṹ�����磺�м����У�������ÿ������������
			while (rse.next()) {
				T m = cls.newInstance();
				// ѭ����ȡ����
				for (int i = 0; i < rsd.getColumnCount(); i++) {
					String col_Name = rsd.getColumnName(i + 1);// ��ȡ����
					Object value = rse.getObject(col_Name);// ��ȡ������Ӧ��ֵ
					Field field = cls.getDeclaredField(col_Name);// �õ����������
					field.setAccessible(true);// ��˽�����Ը�����Ȩ��
					field.set(m, value);// �������˽�����Ը�ֵ
				}
				data.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rse);
		}
		return data;
	}

	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rse) {
		try {
			if (rse != null) {
				rse.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
