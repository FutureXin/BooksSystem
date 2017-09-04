package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Frozen;

public interface FrozenDao {
	public boolean addFrozen(Frozen frozen);//添加冻结信息
	public boolean updateFrozen(int fid);//修改冻结信息
	public List<Frozen> queryFrozen();//查询所有冻结信息
	public List<Frozen> queryFrozenByUid(int uid);//查询指定用户的冻结信息
	public Frozen queryFrozenByFid(int fid);//根据指定的冻结ID查询记录
}
