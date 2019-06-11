package project.semi;

public class CheckList {
	
	String checkNo;

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	@Override
	public String toString() {
		return checkNo;
	}

	public CheckList(String checkNo) {
		this.checkNo = checkNo;
	}
	
	

}
