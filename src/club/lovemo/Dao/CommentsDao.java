package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Comments;
import club.lovemo.Entity.Comments2;

public interface CommentsDao {
	public boolean addComments(Comments comm);// ���������Ϣ

	public boolean deleteComments(int cid);// ɾ��ָ���û���ָ��ͼ������ۼ�¼�����ޱ���

	public boolean updateComments(Comments comm);// �޸�ָ���û���ָ��ͼ������ۣ����ޱ���

	public List<Comments> queryAllComments();// ��ѯ����������Ϣ

	public List<Comments> queryCommentsByBid(int bid);// �������ID��ѯָ��ͼ���������Ϣ

	public Comments queryCommentsByCid(int cid);//��ѯ���ۼ�¼
	
	public List<Comments2> queryAllComments2();//
	
}
