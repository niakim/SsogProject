package project.semi;

public class CartBean {

	ProductModel model;

	private String cimg;
	private String cname;
	private int ccount;
	private int cpoint;
	private int cdanga;
	private int csum;

	@Override
	public String toString() {
		return "CartBean [model=" + model + ", cimg=" + cimg + ", cname=" + cname + ", ccount=" + ccount + ", cpoint="
				+ cpoint + ", cdanga=" + cdanga + ", csum=" + csum + "]";
	}

	public String getCimg() {
		return cimg;
	}

	public void setCimg(String cimg) {
		this.cimg = cimg;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCcount() {
		return ccount;
	}

	public void setCcount(int ccount) {
		this.ccount = ccount;
	}

	public int getCpoint() {
		return cpoint;
	}

	public void setCpoint(int cpoint) {
		this.cpoint = cpoint;
	}

	public int getCdanga() {
		return cdanga;
	}

	public void setCdanga(int cdanga) {
		this.cdanga = cdanga;
	}

	public int getCsum() {
		return csum;
	}

	public void setCsum(int csum) {
		this.csum = csum;
	}

	public CartBean() {
		super();
	}

	public CartBean(String cname) {
		this.cname = cname;
		this.csum = this.ccount * this.cdanga;
		this.cpoint = this.csum / 100;
	}

	public CartBean(String cname, int ccount, int cdanga) {
		this.cname = cname;
		this.ccount = ccount;
		this.cdanga = cdanga;
		this.csum = this.ccount * this.cdanga;
		this.cpoint = this.csum / 100;
	}

	public CartBean(String cimg, String cname, int ccount, int cdanga) {
		this.cname = cname;
		this.ccount = ccount;
		this.cdanga = cdanga;
		this.csum = this.ccount * this.cdanga;
		this.cpoint = this.csum / 100;
	}

}
