package club.lovemo.Biz;

import club.lovemo.Entity.Record;
import club.lovemo.Entity.User;

public interface UserBiz {
	//用户登录
	public int login(User user);
	//用户注册
	public int registerUser(User user);
	
	public int updatePiontandFreezeUser(int rid,Record record,User quser,int lost,int state);
	
}
