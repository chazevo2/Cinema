package Cinema.Ticket;

public class Ticket {
	private int tno;
	private String mid; 
	private int mno;
	private String mname;
	private int tprice;
	private int sno; 
	private String mdate;
	private int scrno;
	private String seatno;

	public Ticket() {
	}

	public Ticket(int tno, String mid, int mno, String mname, int tprice, int sno, String mdate, int scrno,
			String seatno) {
		this.tno = tno;
		this.mid = mid;
		this.mno = mno;
		this.mname = mname;
		this.tprice = tprice;
		this.sno = sno;
		this.mdate = mdate;
		this.scrno = scrno;
		this.seatno = seatno;
	}

	public int getTno() {
		return tno;
	}

	public void setTno(int tno) {
		this.tno = tno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
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

	public int getTprice() {
		return tprice;
	}

	public void setTprice(int tprice) {
		this.tprice = tprice;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getMdate() {
		return mdate;
	}

	public void setMdate(String mdate) {
		this.mdate = mdate;
	}

	public int getScrno() {
		return scrno;
	}

	public void setScrno(int scrno) {
		this.scrno = scrno;
	}

	public String getSeatno() {
		return seatno;
	}

	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}

	@Override
	public String toString() {
		return "Ticket [tno=" + tno + ", mid=" + mid + ", mname=" + mname + ", tprice=" + tprice + ", mdate=" + mdate
				+ ", scrno=" + scrno + ", seatno=" + seatno + "]";
	}

}