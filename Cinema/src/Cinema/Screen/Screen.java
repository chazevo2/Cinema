package Cinema.Screen;

public class Screen {
	private int scrno;
	private int line;
	private int seat;
	
	public Screen() {

	}

	public Screen(int scrno, int line, int seat) {
		this.scrno = scrno;
		this.line = line;
		this.seat = seat;
	}

	public int getScrno() {
		return scrno;
	}

	public void setScrno(int sno) {
		this.scrno = sno;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	@Override
	public String toString() {
		return "Screen [scrno=" + scrno + ", line=" + line + ", seat=" + seat + "]";
	}

}
