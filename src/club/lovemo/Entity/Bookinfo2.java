package club.lovemo.Entity;

public class Bookinfo2 {
	private int id;
	private int bid;
	private String bName;
	private int inout;
	private int state;
	private int lost;
	
	@Override
	public String toString() {
		return "ͼ����Ϣ��¼ID:" + id + "\tͼ��ID:" + bid + "\tͼ����:" + bName
				+ "\t" + (inout== 0 ? "����ͼ���" : "��ͼ���" )+ "\t" + (state==0 ? "δ��" :"����") + "\t" +(lost==0 ? "δ��ʧ":"�Ѷ�ʧ" );
	}
	public Bookinfo2(int id, int bid, String bName,int inout,int state, int lost) {
		super();
		this.id = id;
		this.bid = bid;
		this.bName = bName;
		this.inout=inout;
		this.state = state;
		this.lost = lost;
	}
	public Bookinfo2() {
		super();
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
	public int getInout() {
		return inout;
	}
	public void setInout(int inout) {
		this.inout = inout;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
}
