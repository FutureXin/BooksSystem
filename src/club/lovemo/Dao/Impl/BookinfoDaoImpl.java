package club.lovemo.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import club.lovemo.Dao.BookinfoDao;
import club.lovemo.Entity.Bookinfo;
import club.lovemo.Entity.Bookinfo2;

public class BookinfoDaoImpl extends BaseDao implements BookinfoDao {

	@Override
	public boolean addBookinfo(Bookinfo boin) {
		String sql="insert into bookinfo(bid,inout,state,lost) values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(boin.getBid());
		params.add(boin.getInout());
		params.add(boin.getState());
		params.add(boin.getLost());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteBookinfoById(int id) {
		String sql="delete from bookinfo where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean deleteBookinfoByBid(int bid) {
		String sql="delete from bookinfo where bid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bid);
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Bookinfo> queryAllBookinfo() {
		String sql = "select * from bookinfo";
		List<Bookinfo> biList = null;
		try {
			biList = this.operQuery(sql, null, Bookinfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biList;
	}

	@Override
	public List<Bookinfo> queryBookinfoBybid(int bid) {
		String sql = "select * from bookinfo where bid=?";
		List<Object> params=new ArrayList<Object>();
		List<Bookinfo> biList = null;
		params.add(bid);
		try {
			biList = this.operQuery(sql, params, Bookinfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biList;
	}
	@Override
	public Bookinfo queryBookinfo_inout_lost(int bid) {
		String sql="select * from bookinfo where bid=? and inout=1 and lost=0";
		List<Object> params=new ArrayList<Object>();
		List<Bookinfo> biList = null;
		params.add(bid);
		try {
			biList = this.operQuery(sql, params, Bookinfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(biList.size()>0){
			return biList.get(0);
		}
		return null;
	}

	@Override
	public boolean updateBookinfoById(Bookinfo bookinfo) {
		String sql="update bookinfo set inout=?,state=?,lost=? where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(bookinfo.getInout());
		params.add(bookinfo.getState());
		params.add(bookinfo.getLost());
		params.add(bookinfo.getId());
		return this.operUpdate(sql, params);
	}

	@Override
	public Bookinfo queryBookinfoById(int id) {
		String sql="select * from bookinfo where id=?";
		List<Object> params=new ArrayList<Object>();
		List<Bookinfo> biList = null;
		params.add(id);
		try {
			biList = this.operQuery(sql, params, Bookinfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(biList.size()>0){
			return biList.get(0);
		}
		return null;
	}

	@Override
	public boolean deleteBookinfo_lost() {
		String sql="delete from bookinfo where lost=1";
		List<Object> params=new ArrayList<Object>();
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Bookinfo> queryAllStateBookinfo() {
		String sql = "select * from bookinfo where state=1";
		List<Object> params=new ArrayList<Object>();
		List<Bookinfo> biList = null;
		try {
			biList = this.operQuery(sql, params, Bookinfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biList;
	}

	@Override
	public List<Bookinfo> queryAllLostBookinfo() {
		String sql = "select * from bookinfo where lost=1";
		List<Object> params=new ArrayList<Object>();
		List<Bookinfo> biList = null;
		try {
			biList = this.operQuery(sql, params, Bookinfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biList;
	}

	@Override
	public List<Bookinfo2> queryAllLostBookinfo2() {
		String sql = "select bi.id,b.bid,b.bName,bi.inout,bi.state,bi.lost from bookinfo bi,books b where b.bid=bi.bid";
		//TODO ‘› ±À„–¥ÕÍ
		List<Bookinfo2> biList2 = null;
		try {
			biList2 = this.operQuery(sql, null, Bookinfo2.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return biList2;
	}
}
