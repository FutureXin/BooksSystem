package club.lovemo.Biz.Impl;

import java.util.List;

import club.lovemo.Biz.BookBiz;
import club.lovemo.Dao.BookDao;
import club.lovemo.Dao.Impl.BookDaoImpl;
import club.lovemo.Entity.Book;

public class BookBizImpl implements BookBiz {
//图书表
	private BookDao bookDao=null;
	
	public BookBizImpl(){
		bookDao=new BookDaoImpl();
	}
	@Override
	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}

	@Override
	public boolean delBook(int bid) {
		return bookDao.deleteBook(bid);
	}

	@Override
	public boolean modifyBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Override
	public List<Book> queryAllBooks() {
		return bookDao.queryBooks();
	}

	@Override
	public Book queryBookByName(String bName) {
		return bookDao.queryBookByNema(bName);
	}

	@Override
	public List<Book> ranking_top_five(int number) {
		return bookDao.querySortBookByLimit(0,number);//从第一个开始，输出五个
	}
	@Override
	public List<Book> queryBookByType(int type) {
		return bookDao.queryBookByType(type);
	}
	@Override
	public Book queryBookByBid(int bid) {
		return bookDao.queryBookByBid(bid);
	}
	@Override
	public boolean updateBook_count(int bid) {
		return bookDao.updateBook_count(bid);
	}
	@Override
	public boolean updateBookDH(Book book) {
		return bookDao.updateBookDH(book);
	}
	
}
