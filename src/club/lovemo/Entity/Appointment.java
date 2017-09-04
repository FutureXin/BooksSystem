package club.lovemo.Entity;

public class Appointment {
	private int aid;
	private int uid;
	private int bid;
	private String AppointTime;
	
	@Override
	public String toString() {
		return  "预约记录ID:" + aid + "\t用户ID:" + uid +"\t图书ID:" + bid + "\t预约时间:"
				+ AppointTime;
	}

	public Appointment() {
		super();
	}

	public Appointment(int uid, int bid,String AppointTime) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.setAppointTime(AppointTime);
	}

	public Appointment(int aid, int uid, int bid,String AppointTime) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.bid = bid;
		this.setAppointTime(AppointTime);
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

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getAppointTime() {
		return AppointTime;
	}

	public void setAppointTime(String appointTime) {
		AppointTime = appointTime;
	}

}
