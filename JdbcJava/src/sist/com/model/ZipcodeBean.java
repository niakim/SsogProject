package sist.com.model;

public class ZipcodeBean {

	
	private String zipcode;
	private String sido;
	private String gugu;
	private String dong;
	private String bunji;
	private int seq;
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugu() {
		return gugu;
	}
	public void setGugu(String gugu) {
		this.gugu = gugu;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	
	@Override
	public String toString() {
		return "ZipcodeBean [zipcode=" + zipcode + ", sido=" + sido + ", gugu=" + gugu + ", dong=" + dong + ", bunji="
				+ bunji + "]";
	}

	
	
	
}
