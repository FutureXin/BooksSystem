package club.lovemo.Entity;

public class Book {
	private int bid;
	private String bName;
	private int count;
	private int type;
	private String author;
	private int discount;
	private int hasLended;
	
	@Override
	public String toString() {
		return "图书ID:" + bid + "\t图书名:" + bName + "\t可借数量:" + count
				+ "\t类型:" + type + "\t作者:" + author + "\t借出次数:"
				+ discount + "\t已借出数量:" + hasLended;
	}
	
	public Book(String bName, int count, int type, String author, int discount,
			int hasLended) {
		super();
		this.bName = bName;
		this.count = count;
		this.type = type;
		this.author = author;
		this.discount = discount;
		this.hasLended = hasLended;
	}

	public Book(int bid, String bName, int count, int type, String author,
			int discount, int hasLended) {
		super();
		this.bid = bid;
		this.bName = bName;
		this.count = count;
		this.type = type;
		this.author = author;
		this.discount = discount;
		this.hasLended = hasLended;
	}

	public Book() {
		super();
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getHasLended() {
		return hasLended;
	}

	public void setHasLended(int hasLended) {
		this.hasLended = hasLended;
	}
}
