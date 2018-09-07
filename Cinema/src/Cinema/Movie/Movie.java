   package Cinema.Movie;

public class Movie {
	private int mno;
	private String mname;
	private String story;
	private int runtime;
	private String genre;
	private int rate;

	public Movie() {
	}

	public Movie(int mno, String mname, String story, int runtime, String genre, int rate) {
		this.mno = mno;
		this.mname = mname;
		this.story = story;
		this.runtime = runtime;
		this.genre = genre;
		this.rate = rate;
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

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Movie [영화번호=" + mno + ", 영화이름=" + mname + ", 줄거리=" + story + ", 런타임=" + runtime + ", 장르="
				+ genre + ", 등급=" + rate + "]";
	}

}
