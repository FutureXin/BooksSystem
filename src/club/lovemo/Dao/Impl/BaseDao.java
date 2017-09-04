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
	 * 使用泛型和反射来进行封装
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
			conn = getConn();// 建立数据库连接
			pstmt = conn.prepareStatement(sql);// 装载SQL语句
			if (params != null) {
				// 假如有？的sql语句，就去补全
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rse = pstmt.executeQuery();
			ResultSetMetaData rsd = rse.getMetaData();// 得到表的元数据
			// 可以获得标的结构，比如：有几个列，列名，每个列数据类型
			while (rse.next()) {
				T m = cls.newInstance();
				// 循环获取列名
				for (int i = 0; i < rsd.getColumnCount(); i++) {
					String col_Name = rsd.getColumnName(i + 1);// 获取列名
					Object value = rse.getObject(col_Name);// 获取列所对应的值
					Field field = cls.getDeclaredField(col_Name);// 得到对象的属性
					field.setAccessible(true);// 给私有属性赋访问权限
					field.set(m, value);// 给对象的私有属性赋值
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
