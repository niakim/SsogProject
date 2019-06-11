package project.semi;

public class proModel {
	private int no;
	private String Pw;
	private String text;
	private String title;
	private String date1;
	private int hit;
	private String id;
	private String qna;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPw() {
		return Pw;
	}
	public void setPw(String pw) {
		Pw = pw;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQna() {
		return qna;
	}
	public void setQna(String qna) {
		this.qna = qna;
	}
	@Override
	public String toString() {
		return "proModel [no=" + no + ", Pw=" + Pw + ", text=" + text + ", title=" + title + ", date1=" + date1
				+ ", hit=" + hit + ", id=" + id + ", qna=" + qna + "]";
	}

	
	
}