package club.lovemo.Entity;

public class Comments {
	private int cid;
	private int uid;
	private int bid;
	private double score;
	private String comments;
	
	@Override
	public String toString() {
		return "评价记录ID:" + cid + "\t用户ID:" + uid + "\t图书ID:" + bid + "\t评分:" + score
				+ "\t评语:" + comments;
	}
	public Comments() {
		super();
	}
	public Comments(int cid, int uid, int bid, double score, String comments) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.bid = bid;
		this.score = score;
		this.comments = comments;
	}
	public Comments(int uid, int bid, double score, String comments) {
		super();
		this.uid = uid;
		this.bid = bid;
		this.score = score;
		this.comments = comments;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
