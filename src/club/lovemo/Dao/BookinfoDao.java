package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;

public interface BookinfoDao {
	public boolean addBookinfo(Bookinfo boin);// ���ͼ���ͼ����Ϣ������

	public boolean deleteBookinfoById(int id);// ����ͼ����Ϣ��IDɾ����Ϣ

	public boolean deleteBookinfoByBid(int bid);// ����ͼ���IDɾ��ͼ����Ϣ������

	public List<Bookinfo> queryAllBookinfo();// ��ѯȫ����Ϣ

	public List<Bookinfo> queryBookinfoBybid(int bid);// ����ͼ���ID��ѯͼ����Ϣ
	
	public Bookinfo queryBookinfo_inout_lost(int bid);//����ͼ���ID��ѯ��һ���ɽ����

	public boolean updateBookinfoById(Bookinfo bookinfo);//�޸���Ϣ
	
	public Bookinfo queryBookinfoById(int id);//����ID��ѯ��Ϣ
	
	public boolean deleteBookinfo_lost();//ɾ�����ж�ʧ��ͼ����Ϣ
	
	public List<Bookinfo> queryAllStateBookinfo();//�鿴������ͼ����Ϣ
	
	public List<Bookinfo> queryAllLostBookinfo();//�鿴���ж�ʧͼ����Ϣ
	
	public List<Bookinfo2> queryAllLostBookinfo2();//
}
