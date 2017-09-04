package club.lovemo.Entity;

public class Appointment2 {
	private int aid;
	private int uid;
	private String uName;
	private int bid;
	private String bName;
	private String AppointTime;
	
	@Override
	public String toString() {
		return "预约记录ID:" + aid + "\t用户ID:" + uid + "\t用户名:" + uName
				+ "\t图书ID:" + bid + "\t图书名:" + bName + "\t预约时间:"
				+ AppointTime;
	}
	public Appointment2() {
		super();
	}
	public Appointment2(int aid, int uid, String uName, int bid, String bName,
			String AppointTime) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.uName = uName;
		this.bid = bid;
		this.bName = bName;
		this.AppointTime = AppointTime;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public String getAppointTime() {
		return AppointTime;
	}
	public void setAppointTime(String AppointTime) {
		this.AppointTime = AppointTime;
	}
}
