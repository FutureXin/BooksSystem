package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;

public interface RecordBiz {
	public List<Record> queryUserRecords(String uName);// 查看指定用户的记录

	public List<Record> queryBookRecords(int id);// 查看指定书的借还记录
	
	public List<Record> queryAllRecord();//查看所有的借还记录
	
	public Record queryRecordByRid(int rid);//根据记录表ID查询

	public List<Record2> queryAllRecord2();
}
