package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;

public interface RecordBiz {
	public List<Record> queryUserRecords(String uName);// �鿴ָ���û��ļ�¼

	public List<Record> queryBookRecords(int id);// �鿴ָ����Ľ軹��¼
	
	public List<Record> queryAllRecord();//�鿴���еĽ軹��¼
	
	public Record queryRecordByRid(int rid);//���ݼ�¼��ID��ѯ

	public List<Record2> queryAllRecord2();
}
