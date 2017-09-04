package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Book;

public interface BookBiz {
	public boolean addBook(Book book);// ���ͼ��

	public boolean delBook(int bid);// ����IDɾ��ͼ��

	public boolean modifyBook(Book book);// �޸�ͼ��

	public List<Book> queryAllBooks();// ��ѯ����ͼ��

	public Book queryBookByName(String bName);// �������ֲ�ѯͼ��

	public List<Book> ranking_top_five(int number);// �鿴ǰ�屾���ܻ�ӭ��ͼ��
	
	public List<Book> queryBookByType(int type);//�鿴ͬһ���͵�ͼ��

	public Book queryBookByBid(int bid);//����bid��ѯͼ��
	
	public boolean updateBook_count(int bid);//�����޸�ʣ������
	
	public boolean updateBookDH(Book book);
}
