package club.lovemo.Dao;

import java.util.List;

import club.lovemo.Entity.Frozen;

public interface FrozenDao {
	public boolean addFrozen(Frozen frozen);//��Ӷ�����Ϣ
	public boolean updateFrozen(int fid);//�޸Ķ�����Ϣ
	public List<Frozen> queryFrozen();//��ѯ���ж�����Ϣ
	public List<Frozen> queryFrozenByUid(int uid);//��ѯָ���û��Ķ�����Ϣ
	public Frozen queryFrozenByFid(int fid);//����ָ���Ķ���ID��ѯ��¼
}
