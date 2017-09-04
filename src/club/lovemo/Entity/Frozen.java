package club.lovemo.Entity;

public class Frozen {
	private int fid;
	private int uid;
	private String frozentime;
	private String unfrozentime;
	
	@Override
	public String toString() {
		return "�����¼ID:" + fid + "\t�û�ID:" + uid + "\t����ʱ��:"
				+ frozentime + "\t�ⶳʱ��:" + unfrozentime;
	}
	public Frozen() {
		super();
	}
	public Frozen(int fid, int uid, String frozentime, String unfrozentime) {
		super();
		this.fid = fid;
		this.uid = uid;
		this.frozentime = frozentime;
		this.unfrozentime = unfrozentime;
	}
	public Frozen(int uid, String frozentime, String unfrozentime) {
		super();
		this.uid = uid;
		this.frozentime = frozentime;
		this.unfrozentime = unfrozentime;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getFrozentime() {
		return frozentime;
	}
	public void setFrozentime(String frozentime) {
		this.frozentime = frozentime;
	}
	public String getUnfrozentime() {
		return unfrozentime;
	}
	public void setUnfrozentime(String unfrozentime) {
		this.unfrozentime = unfrozentime;
	}
	
}
