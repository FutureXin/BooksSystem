package club.lovemo.Biz;

import java.util.List;

import club.lovemo.Entity.Frozen;

public interface FrozenBiz {
	public boolean addFrozen(Frozen frozen);// ��Ӷ�����Ϣ

	public boolean modifyFrozen(int fid);// �޸Ķ�����Ϣ

	public List<Frozen> queryAllFrozen();// ��ѯ���ж�����Ϣ

	public List<Frozen> queryFrozenByUid(int uid);// ��ѯָ���û��Ķ�����Ϣ

	public Frozen queryFrozenByFid(int fid);// ����ָ���Ķ���ID��ѯ��¼
}
