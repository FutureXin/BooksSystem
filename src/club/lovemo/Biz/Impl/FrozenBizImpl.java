package club.lovemo.Biz.Impl;

import java.util.List;

import club.lovemo.Biz.FrozenBiz;
import club.lovemo.Dao.FrozenDao;
import club.lovemo.Dao.Impl.FrozenDaoImpl;
import club.lovemo.Entity.Frozen;

public class FrozenBizImpl implements FrozenBiz {
//¶³½á±í
	private FrozenDao frozenDao=null;
	
	public FrozenBizImpl(){
		frozenDao=new FrozenDaoImpl();
	}
	@Override
	public boolean addFrozen(Frozen frozen) {
		return frozenDao.addFrozen(frozen);
	}

	@Override
	public boolean modifyFrozen(int fid) {
		return frozenDao.updateFrozen(fid);
	}

	@Override
	public List<Frozen> queryAllFrozen() {
		return frozenDao.queryFrozen();
	}

	@Override
	public List<Frozen> queryFrozenByUid(int uid) {
		return frozenDao.queryFrozenByUid(uid);
	}

	@Override
	public Frozen queryFrozenByFid(int fid) {
		return frozenDao.queryFrozenByFid(fid);
	}

}
