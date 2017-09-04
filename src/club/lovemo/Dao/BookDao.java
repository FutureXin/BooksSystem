package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Book;

public interface BookDao {
	public boolean addBook(Book book);// ������ͼ��

	public boolean deleteBook(int bid);// ����IDɾ�����ͼ��

	public boolean updateBook(Book book);// ����ID����ͼ��

	public List<Book> queryBooks();// ��ѯ����ͼ��

	public Book queryBookByNema(String bName);// ��ѯָ�����ֵ�ͼ��

	public List<Book> querySortBookByLimit(int index, int number);// ��ѯ������ǰ������ͼ��

	public Book queryBookByBid(int bid);// ����ָ����ͼ��ID��ѯͼ��
	
	public List<Book> queryBookByType(int type);//�������Ͳ鿴ͼ��
	
	public boolean updateBook_count(int bid);//�����޸�ʣ������
	
	public boolean updateBookDH(Book book);
}
