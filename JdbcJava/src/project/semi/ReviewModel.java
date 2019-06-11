package project.semi;

public class ReviewModel {
	private String review;
	private String title;
	private String contancs;
	private String date1;

	@Override
	public String toString() {
		return "ReviewModel [review=" + review + ", title=" + title + ", contancs=" + contancs + ", date1=" + date1
				+ "]";
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContancs() {
		return contancs;
	}

	public void setContancs(String contancs) {
		this.contancs = contancs;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

}
