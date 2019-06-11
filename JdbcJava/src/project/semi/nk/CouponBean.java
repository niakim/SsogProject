package project.semi.nk;

public class CouponBean {
	private int no;
	private String id;
	private String name;
	private String couponnid;
	private String coupon;
	private int price;
	private String givendate;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCouponnid() {
		return couponnid;
	}

	public void setCouponnid(String couponnid) {
		this.couponnid = couponnid;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGivendate() {
		return givendate;
	}

	public void setGivendate(String givendate) {
		this.givendate = givendate;
	}

	@Override
	public String toString() {
		return "CouponBean [no=" + no + ", id=" + id + ", name=" + name + ", couponnid=" + couponnid + ", coupon="
				+ coupon + ", price=" + price + ", givendate=" + givendate + "]";
	}

}
