package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Book;

public interface BookBiz {
	public boolean addBook(Book book);// 添加图书

	public boolean delBook(int bid);// 根据ID删除图书

	public boolean modifyBook(Book book);// 修改图书

	public List<Book> queryAllBooks();// 查询所有图书

	public Book queryBookByName(String bName);// 根据名字查询图书

	public List<Book> ranking_top_five(int number);// 查看前五本最受欢迎的图书
	
	public List<Book> queryBookByType(int type);//查看同一类型的图书

	public Book queryBookByBid(int bid);//根据bid查询图书
	
	public boolean updateBook_count(int bid);//用于修改剩余数量
	
	public boolean updateBookDH(Book book);
}
