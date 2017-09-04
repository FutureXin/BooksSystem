package club.lovemo.Entity;

public class User {
	private int uid;
	private String uName;
	private String uPass;
	private int point;
	private int admini;
	private int frozen;
	
	@Override
	public String toString() {
		return "用户 ID:" + uid + "\t用户名:" + uName + "\t用户密码:" + (uPass!=null ? "******":"******")
				+ "\t剩余积分:" + point + "\t" + (admini==0 ? "普通用户":"管理员") + "\t"
				+ (frozen==0 ? "未冻结":"已冻结");
	}
	public User() {
		super();
	}
	public User(String uName, String uPass, int point, int admini,
			int frozen) {
		super();
		this.uName = uName;
		this.uPass = uPass;
		this.point = point;
		this.admini = admini;
		this.frozen = frozen;
	}
	public User(int uid, String uName, String uPass, int point, int admini,
			int frozen) {
		super();
		this.uid = uid;
		this.uName = uName;
		this.uPass = uPass;
		this.point = point;
		this.admini = admini;
		this.frozen = frozen;
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
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int isAdmini() {
		return admini;
	}
	public void setAdmini(int admini) {
		this.admini = admini;
	}
	public int isFrozen() {
		return frozen;
	}
	public void setFrozen(int frozen) {
		this.frozen = frozen;
	}
	
}
