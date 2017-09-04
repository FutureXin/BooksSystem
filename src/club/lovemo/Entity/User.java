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
		return "�û� ID:" + uid + "\t�û���:" + uName + "\t�û�����:" + (uPass!=null ? "******":"******")
				+ "\tʣ�����:" + point + "\t" + (admini==0 ? "��ͨ�û�":"����Ա") + "\t"
				+ (frozen==0 ? "δ����":"�Ѷ���");
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
