package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;
import club.lovemo.Entity.Record;

public interface BookinfoBiz {
	public boolean addBookinfo(Bookinfo boin);// ���ͼ���ͼ����Ϣ������

	public boolean delBookinfoById(int id);// ����ͼ����Ϣ��IDɾ����Ϣ

	public boolean delBookinfoByBid(int bid);// ����ͼ���IDɾ��ͼ����Ϣ������

	public List<Bookinfo> queryAllBookinfo();// ��ѯȫ����Ϣ

	public List<Bookinfo> queryBookinfoBybid(int bid);// ����ͼ���ID��ѯͼ����Ϣ
	
	public int lendBook(String bName,int uid);//��ͼ��
	
	public int returnBook(Record record,Bookinfo bookinfo);//��ͼ��
	
	public boolean delBookinfo_lost();//ɾ�����ж�ʧ��ͼ����Ϣ
	
	public List<Bookinfo> queryAllStateBookinfo();//�鿴������ͼ����Ϣ
	
	public List<Bookinfo> queryAllLostBookinfo();//�鿴���ж�ʧͼ����Ϣ
	
	public Bookinfo queryBookinfoById(int id);//����ID��ѯ��Ϣ
	
	public List<Bookinfo2> queryAllBookinfo2();
}
