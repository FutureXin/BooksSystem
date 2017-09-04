package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Book;

public interface BookDao {
	public boolean addBook(Book book);// 添加书表图书

	public boolean deleteBook(int bid);// 根据ID删除书表图书

	public boolean updateBook(Book book);// 根据ID更新图书

	public List<Book> queryBooks();// 查询所有图书

	public Book queryBookByNema(String bName);// 查询指定名字的图书

	public List<Book> querySortBookByLimit(int index, int number);// 查询借阅量前几名的图书

	public Book queryBookByBid(int bid);// 根据指定的图书ID查询图书
	
	public List<Book> queryBookByType(int type);//根据类型查看图书
	
	public boolean updateBook_count(int bid);//用于修改剩余数量
	
	public boolean updateBookDH(Book book);
}
