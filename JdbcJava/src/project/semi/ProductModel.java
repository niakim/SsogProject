package project.semi;

public class ProductModel {
	private String NO;
	private String CNAME;
	private String NAME;
	private String PRICE;

	public String getNO() {
		return NO;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public String getCNAME() {
		return CNAME;
	}

	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getPRICE() {
		return PRICE;
	}

	public void setPRICE(String pRICE) {
		PRICE = pRICE;
	}

	@Override
	public String toString() {
		return "ProductModel [NO=" + NO + ", CNAME=" + CNAME + ", NAME=" + NAME + ", PRICE=" + PRICE + "]";
	}

}
