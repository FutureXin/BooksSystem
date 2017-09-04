package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;

public interface RecordDao {
	public List<Record> queryRecordByUid(int uid);//根据用户ID查询记录
	public List<Record> queryAllRecord();//查询图书所有借还记录
	public List<Record> queryRecordByBid(int id); //根据图书ID查询图书借还记录
	public boolean saveRecord(Record record);//添加图书借还记录
	public boolean addRuturnTima(int rid);//添加归还时间
	public boolean updateRecord(Record record);//更新借还记录
	public Record queryRecordByRid(int rid);//根据记录表ID查询
	public List<Record2> queryAllRecord2();
}
