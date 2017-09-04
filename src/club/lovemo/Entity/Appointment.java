package club.lovemo.Entity;

public class Appointment {
	private int aid;
	private int uid;
	private int bid;
	private String AppointTime;
	
	@Override
	public String toString() {
		return  "ԤԼ��¼ID:" + aid + "\t�û�ID:" + uid +"\tͼ��ID:" + bid + "\tԤԼʱ��:"
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
