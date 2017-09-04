package club.lovemo.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import club.lovemo.Dao.UserDao;
import club.lovemo.Entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public boolean addUser(User user) {
		String sql="insert into users(uName,uPass)values(?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(user.getuName());
		params.add(user.getuPass());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateUser(User user) {
		String sql="update users set uName=?,uPass=? where uid=?";
		List<Object> params=new ArrayList<>();
		params.add(user.getuName());
		params.add(user.getuPass());
		params.add(user.getUid());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteUser(int uid) {
		String sql="delete from users where uid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uid);
		return this.operUpdate(sql, params);
	}

	@Override
	public User queryUserById(int uid) {
		List<User> uList=null;
		String sql="select * from users where uid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uid);
		try {
			uList=this.operQuery(sql, params,User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(uList.size()>0){
			return uList.get(0);
		}
		return null;
	}

	@Override
	public User queryUserByName(String uName) {
		List<User> uList=null;
		String sql="select * from users where uName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uName);
		try {
			uList=this.operQuery(sql, params,User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(uList.size()>0){
			return uList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public boolean updateUserPoint(int uid, int point,int frozen) {
		String sql="update users set point=?,frozen=? where uid=?";
		List<Object> params=new ArrayList<>();
		params.add(point);
		params.add(frozen);
		params.add(uid);
		return this.operUpdate(sql, params);
	}

}
