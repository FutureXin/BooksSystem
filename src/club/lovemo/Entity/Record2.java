package club.lovemo.Entity;

public class Record2 {
	private int rid;
	private int uid;
	private String uName;
	private int id;
	private int bid;
	private String bName;
	private String lendTime;
	private String returnTime;
	
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
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
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
	@Override
	public String toString() {
		return "�軹��¼ID:" + rid + "\t�û�ID:" + uid + "\t�û���:" + uName
				+ "\tͼ����ϢID:" + id + "\tͼ��ID:" + bid + "\tͼ����:" + bName
				+ "\t���ʱ��:" + lendTime + "\t�黹ʱ��:" + (returnTime==null ? "��δ�黹":returnTime);
	}
	public Record2() {
		super();
	}
	public Record2(int rid, int uid, String uName, int id, int bid,
			String bName, String lendTime, String returnTime) {
		super();
		this.rid = rid;
		this.uid = uid;
		this.uName = uName;
		this.id = id;
		this.bid = bid;
		this.bName = bName;
		this.lendTime = lendTime;
		this.returnTime = returnTime;
	}
	
}
