package club.lovemo.Biz.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import club.lovemo.Biz.BookinfoBiz;
import club.lovemo.Dao.AppointmentDao;
import club.lovemo.Dao.BookDao;
import club.lovemo.Dao.BookinfoDao;
import club.lovemo.Dao.RecordDao;
import club.lovemo.Dao.UserDao;
import club.lovemo.Dao.Impl.AppointmentDaoImpl;
import club.lovemo.Dao.Impl.BookDaoImpl;
import club.lovemo.Dao.Impl.BookinfoDaoImpl;
import club.lovemo.Dao.Impl.RecordDaoImpl;
import club.lovemo.Dao.Impl.UserDaoImpl;
import club.lovemo.Entity.Book;
import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;
import club.lovemo.Entity.Record;

public class BookinfoBizImpl implements BookinfoBiz {
//图书馆信息表
	private BookinfoDao bookinfoDao=null;
	private BookDao bookDao=null;
	private AppointmentDao appointmentDao=null;
	private RecordDao recordDao=null;
	private UserDao userDao=null;

	public BookinfoBizImpl(){
		bookinfoDao=new BookinfoDaoImpl();
		bookDao=new BookDaoImpl();
		appointmentDao=new AppointmentDaoImpl();
		recordDao=new RecordDaoImpl();
		userDao=new UserDaoImpl();
	}
	@Override
	public boolean addBookinfo(Bookinfo boin) {
		return bookinfoDao.addBookinfo(boin);
	}

	@Override
	public boolean delBookinfoById(int id) {
		return bookinfoDao.deleteBookinfoById(id);
	}

	@Override
	public boolean delBookinfoByBid(int bid) {
		return bookinfoDao.deleteBookinfoByBid(bid);
	}

	@Override
	public List<Bookinfo> queryAllBookinfo() {
		return bookinfoDao.queryAllBookinfo();
	}

	@Override
	public List<Bookinfo> queryBookinfoBybid(int bid) {
		return bookinfoDao.queryBookinfoBybid(bid);
	}
	@Override
	public boolean delBookinfo_lost() {
		// TODO Auto-generated method stub删除的同时要修改books表剩余数量
		List<Bookinfo> bookinfos=queryAllLostBookinfo();
		Bookinfo bookinfo=null;
		int yes=0;
		int no=0;
		if(bookinfos.size()>0){
			for (int i = 0; i < bookinfos.size(); i++) {
				bookinfo=bookinfos.get(i);
				if(bookinfoDao.deleteBookinfoById(bookinfo.getId())){
					yes++;
				}else{
					no++;
				}
			}
			System.out.println("删除成功数量："+yes+"删除失败数量："+no);
			return true;
		}else{
			return false;//没有丢失的书
		}
//		return bookinfoDao.deleteBookinfo_lost();
	}
	@Override
	public List<Bookinfo> queryAllStateBookinfo() {
		return bookinfoDao.queryAllStateBookinfo();
	}
	@Override
	public List<Bookinfo> queryAllLostBookinfo() {
		return bookinfoDao.queryAllLostBookinfo();
	}

	@Override
	public int lendBook(String bName, int uid) {
		Book qbook=bookDao.queryBookByNema(bName);
		if(qbook==null){
			return 0;
		}else{
			if(qbook.getCount()-appointmentDao.queryAppoinByBid(qbook.getBid()).size()<=0){
				return 1;//不可以借
			}else{
				qbook.setCount(qbook.getCount()-1);
				qbook.setDiscount(qbook.getDiscount()+1);
				qbook.setHasLended(qbook.getHasLended()+1);
				boolean flag1=bookDao.updateBookDH(qbook);//更改books表的信息
				Bookinfo qbookinfo=bookinfoDao.queryBookinfo_inout_lost(qbook.getBid());
				System.out.println(qbookinfo);
				qbookinfo.setInout(0);
				boolean flag2=bookinfoDao.updateBookinfoById(qbookinfo);
				Record record=new Record();
				record.setId(qbookinfo.getId());
				record.setUid(uid);
				record.setLendTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));
				boolean flag3=recordDao.saveRecord(record);
				if(flag1&&flag2&&flag3){
					return 2;//借出成功
				}else{
					return 3;//借出失败
				}
			}
		}
	}

	@Override
	public int returnBook(Record record,Bookinfo bookinfo) {
		Record qrecord=recordDao.queryRecordByRid(record.getRid());
		if(qrecord==null){
			return 1;//输入不正确
		}else if(qrecord.getReturnTime()!=null){
			return 2;//已经归还
		}else{
			int quid=qrecord.getUid();//根据rid查出的uid
			if(userDao.queryUserById(record.getUid()).isAdmini()==1^record.getUid()==quid){
				qrecord.setReturnTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date()));
				boolean flag1=recordDao.updateRecord(qrecord);//添加归还时间
				Bookinfo qbookinfo=bookinfoDao.queryBookinfoById(qrecord.getId());
				Book book=bookDao.queryBookByBid(qbookinfo.getBid());
				if(bookinfo.getLost()==0){
					book.setCount(book.getCount()+1);
				}
				book.setDiscount(book.getDiscount()-1);
				boolean flag2=bookDao.updateBookDH(book);//修改图书表信息
				qbookinfo.setInout(1);
				qbookinfo.setLost(bookinfo.getLost());
				qbookinfo.setState(bookinfo.getState());
				boolean flag3=bookinfoDao.updateBookinfoById(qbookinfo);//修改图书馆图书表信息
				if(flag1&&flag2&&flag3){
					return 3;//归还成功
				}else{
					return 4;//归还失败
				}
				
			}else{
				return 0;//用户不对
			}
		}
	}
	@Override
	public Bookinfo queryBookinfoById(int id) {
		return bookinfoDao.queryBookinfoById(id);
	}
	@Override
	public List<Bookinfo2> queryAllBookinfo2() {
		return bookinfoDao.queryAllLostBookinfo2();
	}
	
}
