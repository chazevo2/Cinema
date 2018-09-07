package Cinema.Review;

public class Review {
	private int rno;
	private int mno;
	private String mname; // Ãâ·Â¿ë
	private String mid;
	private int score;
	private String memo;

	public Review() {
	}

	public Review(int rno, int mno, String mname, String mid, int score, String meme) {
		this.rno = rno;
		this.mno = mno;
		this.mname = mname;
		this.mid = mid;
		this.score = score;
		this.memo = meme;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Review [rno=" + rno + ", mname=" + mname + ", mid=" + mid + ", score=" + score + ", memo=" + memo + "]";
	}

}
