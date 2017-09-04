package club.lovemo.Dao;

import club.lovemo.Entity.User;

public interface UserDao {
	public boolean addUser(User user);//添加用户
	public boolean updateUser(User user);//更新用户信息
	public boolean deleteUser(int uid);//根据ID删除用户。管理员用
	public User queryUserById(int uid);//根据ID查询用户信息
	public User queryUserByName(String uName);//根据用户名查询用户信息
	public boolean updateUserPoint(int uid,int point,int frozen);//用于添加积分。管理员用
	
}
