package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;

public interface BookinfoDao {
	public boolean addBookinfo(Bookinfo boin);// 添加图书馆图书信息表数据

	public boolean deleteBookinfoById(int id);// 根据图书信息表ID删除信息

	public boolean deleteBookinfoByBid(int bid);// 根据图书表ID删除图书信息表数据

	public List<Bookinfo> queryAllBookinfo();// 查询全部信息

	public List<Bookinfo> queryBookinfoBybid(int bid);// 根据图书表ID查询图书信息
	
	public Bookinfo queryBookinfo_inout_lost(int bid);//根据图书表ID查询第一本可借的书

	public boolean updateBookinfoById(Bookinfo bookinfo);//修改信息
	
	public Bookinfo queryBookinfoById(int id);//根据ID查询信息
	
	public boolean deleteBookinfo_lost();//删除所有丢失的图书信息
	
	public List<Bookinfo> queryAllStateBookinfo();//查看所有损坏图书信息
	
	public List<Bookinfo> queryAllLostBookinfo();//查看所有丢失图书信息
	
	public List<Bookinfo2> queryAllLostBookinfo2();//
}
