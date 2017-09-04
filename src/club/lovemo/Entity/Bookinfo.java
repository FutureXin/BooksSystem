package club.lovemo.Entity;

public class Bookinfo {
	private int id;
	private int bid;
	private int inout;
	private int state;
	private int lost;
	
	public Bookinfo() {
		super();
	}
	@Override
	public String toString() {
		return "图书信息记录ID:" + id + "\t图书ID:" + bid + "\t" + (inout== 0 ? "不在图书馆" : "在图书馆" )+ "\t" + (state==0 ? "未损坏" :"已损坏") + "\t" +(lost==0 ? "未丢失":"已丢失" );
	}
	public Bookinfo(int id, int bid, int inout, int state, int lost) {
		super();
		this.id = id;
		this.bid = bid;
		this.inout = inout;
		this.state = state;
		this.lost = lost;
	}
	public Bookinfo(int bid, int inout, int state, int lost) {
		super();
		this.bid = bid;
		this.inout = inout;
		this.state = state;
		this.lost = lost;
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
