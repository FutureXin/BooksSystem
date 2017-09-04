package club.lovemo.Dao;

import club.lovemo.Entity.User;

public interface UserDao {
	public boolean addUser(User user);//����û�
	public boolean updateUser(User user);//�����û���Ϣ
	public boolean deleteUser(int uid);//����IDɾ���û�������Ա��
	public User queryUserById(int uid);//����ID��ѯ�û���Ϣ
	public User queryUserByName(String uName);//�����û�����ѯ�û���Ϣ
	public boolean updateUserPoint(int uid,int point,int frozen);//������ӻ��֡�����Ա��
	
}
