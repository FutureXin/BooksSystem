package club.lovemo.Entity;

public class Comments2 {
	private int cid;
	private int uid;
	private String uName;
	private int bid;
	private String bName;
	private double score;
	private String comments;
	
	@Override
	public String toString() {
		return "评价记录ID:" + cid + "\t用户ID:" + uid + "\t用户名:" + uName
				+ "\t图书ID:" + bid + "\t图书名:" + bName + "\t评分:" + score
				+ "\t评语:" + comments;
	}
	public Comments2(int cid, int uid, String uName, int bid, String bName,
			double score, String comments) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.uName = uName;
		this.bid = bid;
		this.bName = bName;
		this.score = score;
		this.comments = comments;
	}
	public Comments2() {
		super();
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
	public double getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
