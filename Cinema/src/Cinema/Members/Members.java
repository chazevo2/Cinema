package Cinema.Members;

import java.sql.Date;

public class Members {
	private String uname;
	private String mid;
	private String pwd;
	private String birth;
	private int point;

	public Members() {

	}

	public Members(String uname, String mid, String pwd, String birth, int point) {
		this.uname = uname;
		this.mid = mid;
		this.pwd = pwd;
		this.birth = birth;
		this.point = point;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Members [회원이름=" + uname + ", ID=" + mid + ", PWD=" + pwd + ", 생년월일=" + birth + ", 포인트=" + point
				+ "]";
	}

}
