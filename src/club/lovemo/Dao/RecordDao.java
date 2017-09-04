package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;

public interface RecordDao {
	public List<Record> queryRecordByUid(int uid);//�����û�ID��ѯ��¼
	public List<Record> queryAllRecord();//��ѯͼ�����н軹��¼
	public List<Record> queryRecordByBid(int id); //����ͼ��ID��ѯͼ��軹��¼
	public boolean saveRecord(Record record);//���ͼ��軹��¼
	public boolean addRuturnTima(int rid);//��ӹ黹ʱ��
	public boolean updateRecord(Record record);//���½軹��¼
	public Record queryRecordByRid(int rid);//���ݼ�¼��ID��ѯ
	public List<Record2> queryAllRecord2();
}
