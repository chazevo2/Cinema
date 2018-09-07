package Cinema.Schedule;

public class Schedule {
	private int sno;
	private int mno;
	private String mname;
	private String mday;
	private String mtime;
	private int sprice;
	private int scrno;
	private int ex_seat;

	public Schedule() {

	}

	public Schedule(int sno, int mno, String mname, String mday, String mtime, int sprice, int scrno, int ex_seat) {
		this.sno = sno;
		this.mno = mno;
		this.mname = mname;
		this.mday = mday;
		this.mtime = mtime;
		this.sprice = sprice;
		this.scrno = scrno;
		this.ex_seat = ex_seat;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMday() {
		return mday;
	}

	public void setMday(String mday) {
		this.mday = mday;
	}

	public String getMtime() {
		return mtime;
	}

	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public int getSprice() {
		return sprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}

	public int getScrno() {
		return scrno;
	}

	public void setScrno(int scrno) {
		this.scrno = scrno;
	}

	public int getEx_seat() {
		return ex_seat;
	}

	public void setEx_seat(int ex_seat) {
		this.ex_seat = ex_seat;
	}

	@Override
	public String toString() {
		return "Schedule [sno=" + sno + ", mno=" + mno + ", mname=" + mname + ", mday=" + mday + ", mtime=" + mtime
				+ ", sprice=" + sprice + ", scrno=" + scrno + ", ex_seat=" + ex_seat + "]";
	}

}
