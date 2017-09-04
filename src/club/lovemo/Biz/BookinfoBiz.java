package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;
import club.lovemo.Entity.Record;

public interface BookinfoBiz {
	public boolean addBookinfo(Bookinfo boin);// 添加图书馆图书信息表数据

	public boolean delBookinfoById(int id);// 根据图书信息表ID删除信息

	public boolean delBookinfoByBid(int bid);// 根据图书表ID删除图书信息表数据

	public List<Bookinfo> queryAllBookinfo();// 查询全部信息

	public List<Bookinfo> queryBookinfoBybid(int bid);// 根据图书表ID查询图书信息
	
	public int lendBook(String bName,int uid);//借图书
	
	public int returnBook(Record record,Bookinfo bookinfo);//还图书
	
	public boolean delBookinfo_lost();//删除所有丢失的图书信息
	
	public List<Bookinfo> queryAllStateBookinfo();//查看所有损坏图书信息
	
	public List<Bookinfo> queryAllLostBookinfo();//查看所有丢失图书信息
	
	public Bookinfo queryBookinfoById(int id);//根据ID查询信息
	
	public List<Bookinfo2> queryAllBookinfo2();
}
