package club.lovemo.Dao.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import club.lovemo.Dao.FrozenDao;
import club.lovemo.Entity.Frozen;

public class FrozenDaoImpl extends BaseDao implements FrozenDao {

	@Override
	public boolean addFrozen(Frozen frozen) {
		String sql = "insert into frozentime(uid,frozentime)values(?,?)";
		List<Object> params = new ArrayList<Object>();
		params.add(frozen.getUid());
		params.add(frozen.getFrozentime());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateFrozen(int fid) {
		String sql = "update frozentime set unfrozentime=? where fid=?";
		List<Object> params = new ArrayList<Object>();
		params.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a").format(new Date()));
		return this.operUpdate(sql, params);
	}

	@Override
	public List<Frozen> queryFrozen() {
		String sql = "select * from frozentime";
		List<Frozen> fList = null;
		try {
			fList = this.operQuery(sql, null, Frozen.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fList;
	}

	@Override
	public List<Frozen> queryFrozenByUid(int uid) {
		String sql = "select * from frozentime where uid=?";
		List<Object> params = new ArrayList<Object>();
		List<Frozen> fList = null;
		params.add(uid);
		try {
			fList = this.operQuery(sql, params, Frozen.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fList;
	}

	@Override
	public Frozen queryFrozenByFid(int fid) {
		String sql = "select * from frozentime where fid=?";
		List<Object> params = new ArrayList<Object>();
		List<Frozen> fList = null;
		params.add(fid);
		try {
			fList = this.operQuery(sql, params, Frozen.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(fList.size()>0){
			return fList.get(0);
		}
		return null;
	}

}
