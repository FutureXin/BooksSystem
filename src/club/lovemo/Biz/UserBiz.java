package club.lovemo.Biz;

import club.lovemo.Entity.Record;
import club.lovemo.Entity.User;

public interface UserBiz {
	//�û���¼
	public int login(User user);
	//�û�ע��
	public int registerUser(User user);
	
	public int updatePiontandFreezeUser(int rid,Record record,User quser,int lost,int state);
	
}
