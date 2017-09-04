package club.lovemo.Dao.Impl;

import java.util.ArrayList;
import java.util.List;

import club.lovemo.Dao.RecordDao;
import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;

public class RecordDaoImpl extends BaseDao implements RecordDao {

	@Override
	public List<Record> queryRecordByUid(int uid) {
		String sql = "select * from records where uid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(uid);
		List<Record> rList=null;
		try {
			rList = this.operQuery(sql, params, Record.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public List<Record> queryAllRecord() {
		String sql = "select * from records";
		List<Record> rList=null;
		try {
			rList = this.operQuery(sql, null, Record.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public List<Record> queryRecordByBid(int id) {
		String sql = "select * from records where id=?";
		List<Object> params=new ArrayList<Object>();
		params.add(id);
		List<Record> rList=null;
		try {
			rList = this.operQuery(sql, params, Record.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public boolean saveRecord(Record record) {
		String sql="insert into records(uid,id,lendTime,returnTime) values(?,?,?,?)";
		List<Object> params=new ArrayList<Object>();
		params.add(record.getUid());
		params.add(record.getId());
		params.add(record.getLendTime());
		params.add(record.getReturnTime());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean addRuturnTima(int rid) {
		String sql="update records set returnTime=? where rid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(rid);
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateRecord(Record record) {
		String sql="update records set uid=?,id=?,lendTime=?,returnTime=? where rid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(record.getUid());
		params.add(record.getId());
		params.add(record.getLendTime());
		params.add(record.getReturnTime());
		params.add(record.getRid());
		return this.operUpdate(sql, params);
	}

	@Override
	public Record queryRecordByRid(int rid) {
		String sql = "select * from records where rid=?";
		List<Object> params=new ArrayList<Object>();
		params.add(rid);
		List<Record> rList=null;
		try {
			rList = this.operQuery(sql, params, Record.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(rList.size()>0){
			return rList.get(0);
		}
		return null;
	}

	@Override
	public List<Record2> queryAllRecord2() {
		// TODO »¹Î´Ð´Íê
		String sql = "select r.rid,u.uid,u.uName,bi.id,b.bid,b.bName,r.lendTime,r.returnTime from records r,users u,bookinfo bi,books b where r.uid=u.uid and r.id=bi.id and bi.bid=b.bid";
		List<Record2> rList2=null;
		try {
			rList2 = this.operQuery(sql, null, Record2.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rList2;
	}

}
