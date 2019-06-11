package project.semi;

public class WithdrawalBean {
	private String snumber;
	private String addr;
	private String complain;
	private String opinion;

	public String getSnumber() {
		return snumber;
	}

	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getComplain() {
		return complain;
	}

	public void setComplain(String complain) {
		this.complain = complain;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Override
	public String toString() {
		return "WithdrawalBean [snumber=" + snumber + ", addr=" + addr + ", complain=" + complain + ", opinion="
				+ opinion + "]";
	}
}
