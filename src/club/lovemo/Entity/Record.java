package club.lovemo.Entity;

public class Record {
	private int rid;
	private int uid;
	private int id;
	private String lendTime;
	private String returnTime;
	
	@Override
	public String toString() {
		return "�軹��¼ID:" + rid + "\t�û�ID:" + uid + "\tͼ����ϢID:" + id + "\t���ʱ��:" + lendTime + "\t�黹ʱ��:" + returnTime;
	}
	public Record() {
		super();
	}
	public Record(int uid, int id, String lendTime, String returnTime) {
		super();
		this.uid = uid;
		this.id = id;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}
	public Record(int rid, int uid, int id, String lendTime, String returnTime) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.id = id;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLendTime() {
		return lendTime;
	}
	public void setLendTime(String lendTime) {
		this.lendTime = lendTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	
}
