package club.lovemo.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import club.lovemo.Dao.BookDao;
import club.lovemo.Entity.Book;

public class BookDaoImpl extends BaseDao implements BookDao {

	@Override
	public boolean addBook(Book book) {
		String sql="insert into books(bName,count,type,author) values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(book.getbName());
		params.add(book.getCount());
		params.add(book.getType());
		params.add(book.getAuthor());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteBook(int bid) {
		String sql="delete from books where bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateBook(Book book) {
		String sql="update books set bName=?,count=?,type=?,author=? where bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(book.getbName());
		params.add(book.getCount());
		params.add(book.getType());
		params.add(book.getAuthor());
		params.add(book.getBid());
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Book> queryBooks() {
		String sql="select * from books";
		List<Book> bList=null;
		try {
			bList=this.operQuery(sql,null,Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public Book queryBookByNema(String bName) {
		String sql="select * from books where bname=?";
		List<Object> params=new ArrayList<Object>();
		List<Book> bList=null;
		params.add(bName);
		try {
			bList=this.operQuery(sql, params, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(bList.size()>0){
			return bList.get(0);
		}
		return null;
	}

	@Override
	public List<Book> querySortBookByLimit(int index, int number) {
		String sql="select * from books order by discount desc Limit "+index+","+number;
		List<Book> bList=null;
		try {
			bList=this.operQuery(sql, null, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public Book queryBookByBid(int bid) {
		String sql="select * from books where bid=?";
		List<Object> params=new ArrayList<Object>();
		List<Book> bList=null;
		params.add(bid);
		try {
			bList=this.operQuery(sql, params, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}if(bList.size()>0){
			return bList.get(0);
		}
		return null;
	}

	@Override
	public List<Book> queryBookByType(int type) {
		String sql="select * from books where type=?";
		List<Object> params=new ArrayList<Object>();
		List<Book> bList=null;
		params.add(type);
		try {
			bList=this.operQuery(sql, params, Book.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	@Override
	public boolean updateBook_count(int bid) {
		String sql="update books set count=count-1 where bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateBookDH(Book book) {
		String sql="update books set bName=?,count=?,type=?,author=?,discount=?,hasLended=? where bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(book.getbName());
		params.add(book.getCount());
		params.add(book.getType());
		params.add(book.getAuthor());
		params.add(book.getDiscount());
		params.add(book.getHasLended());
		params.add(book.getBid());
		return this.operUpdate(sql, params);
	}
}
