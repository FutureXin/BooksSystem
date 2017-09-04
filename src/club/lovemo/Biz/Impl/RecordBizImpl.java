package club.lovemo.Biz.Impl;

import java.util.List;

import club.lovemo.Biz.RecordBiz;
import club.lovemo.Dao.RecordDao;
import club.lovemo.Dao.UserDao;
import club.lovemo.Dao.Impl.RecordDaoImpl;
import club.lovemo.Dao.Impl.UserDaoImpl;
import club.lovemo.Entity.Record;
import club.lovemo.Entity.Record2;

public class RecordBizImpl implements RecordBiz {
//��¼��
	private RecordDao recordDao=null;
	private UserDao userDao=null;
	public RecordBizImpl(){
		recordDao=new RecordDaoImpl();
		userDao=new UserDaoImpl();
	}
	
	@Override
	public List<Record> queryUserRecords(String uName) {// �鿴ָ���û��ļ�¼
		int uid=userDao.queryUserByName(uName).getUid();
		return recordDao.queryRecordByUid(uid);
	}

	@Override
	public List<Record> queryBookRecords(int id) {// �鿴ָ����Ľ軹��¼
		return recordDao.queryRecordByBid(id);
	}

	@Override
	public List<Record> queryAllRecord() {//�鿴���еĽ軹��¼
		return recordDao.queryAllRecord();
	}

	@Override
	public Record queryRecordByRid(int rid) {
		return recordDao.queryRecordByRid(rid);
	}

	@Override
	public List<Record2> queryAllRecord2() {
		return recordDao.queryAllRecord2();
	}

}
