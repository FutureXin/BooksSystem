package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Frozen;

public interface FrozenBiz {
	public boolean addFrozen(Frozen frozen);// 添加冻结信息

	public boolean modifyFrozen(int fid);// 修改冻结信息

	public List<Frozen> queryAllFrozen();// 查询所有冻结信息

	public List<Frozen> queryFrozenByUid(int uid);// 查询指定用户的冻结信息

	public Frozen queryFrozenByFid(int fid);// 根据指定的冻结ID查询记录
}
