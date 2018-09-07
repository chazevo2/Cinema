package Cinema.Members;

import java.util.Scanner;

public class MembersController {
	private MembersService service;
	private static MembersService s;
	private static String LoginId = "";

	public static String getLoginId() {
		return LoginId;
	}

	@SuppressWarnings("static-access")
	public MembersController(MembersService service) {
		this.service = service;
		this.s = service;
	}

	// TODO Auto-generated method stub
	public void join(Scanner sc) { // 조인
		Members m = new Members();
		System.out.print("회원 아이디:");
		m.setMid(sc.next());
		if (service.getMembers(m.getMid()) != null) {
			System.out.println("이미 사용된 아이디입니다.");
			join(sc);
		}
		System.out.print("패스워드:");
		m.setPwd(sc.next());
		System.out.print("패스워드 확인:");
		if (sc.next().equals(m.getPwd()))
			System.out.println("패스워드 일치");
		else {
			System.out.println("패스워드 불일치");
			join(sc);
		}
		System.out.print("유저 이름(eng):");
		m.setUname(sc.next());
		System.out.print("생년월일(yyyy/mm/dd):");
		m.setBirth(sc.next());
		
		service.addMembers(m);
		System.out.println("가입이 완료되었습니다.");
	}

	public void login(Scanner sc) {
		if (!LoginId.equals("")) {
			System.out.println("이미 로그인 상태임");
			return;
		}
		Members m = new Members();
		System.out.print("회원 아이디:");
		m.setMid(sc.next());
		System.out.print("패스워드:");
		m.setPwd(sc.next());
		boolean flag = service.login(m);
		if (flag) {
			System.out.println("로그인이 성공되었습니다");
			LoginId = m.getMid();
		} else {
			System.out.println("로그인에 실패하였습니다");
		}
	}

	public void logout() {
		if (LoginId.equals("")) {
			System.out.println("로그인을 먼저 하십시오.");
			return;
		}
		LoginId = "";
		System.out.println("로그아웃 되었습니다.");
	}

	public boolean myInfo() {
		if (LoginId.equals("")) {
			System.out.println("로그인을 먼저 하십시오.");
			return false;
		}
		Members m = service.getMembers(LoginId);
		System.out.println(m);
		return true;

	}

	public void findMyid(Scanner sc) {
		Members m = new Members();
		System.out.println("유저 이름(eng):");
		m.setUname(sc.next());
		System.out.println("생년월일(yyyy/mm/dd):");
		m.setBirth(sc.next());
		if(service.getId(m) == null) {
			System.out.println("아이디가 존재하지 않습니다.");
			return;
		}
		System.out.println("검색된 id들");
		for (String s : service.getId(m))
			System.out.println(s);
	}

	public void delMembers(Scanner sc) {
		if (LoginId.equals("")) {
			System.out.println("로그인을 먼저 하십시오.");
			return;
		}
		System.out.println("정말 탈퇴 하실겁니까? yes, no");
		String str = sc.next();
		if (str.equals("yes")) {
			service.delMembers(LoginId);
			LoginId = "";
			System.out.println("탈퇴가 완료 되었습니다.");
		} else {
			System.out.println("탈퇴가 취소 되었습니다.");
		}
	}

	public void editPwd(Scanner sc) {
		boolean flag = myInfo();
		if (flag) {
			Members m = new Members();
			m.setMid(LoginId);
			System.out.print("새로운 비밀번호:");
			m.setPwd(sc.next());
			System.out.print("새로운 비밀번호 확인:");
			if (sc.next().equals(m.getPwd()))
				service.editPwd(m);
			else
				System.out.println("비밀번호가 일치하지 않습니다");
			System.out.println("비밀번호가 변경되었습니다.");
		}
	}

	public static int age(String mid) {
		return s.age(mid);
	}

	public static int getPoint(String mid) {
		return s.getMembers(mid).getPoint();
	}
	
	public static void usePoint(Members m, int sign) {
		s.editPoint(m, sign);;
	}

	public void getAll() {
		if(service.getAll() == null) {
			System.out.println("목록이 비었습니다.");
			return;
		}
		for (Members m : service.getAll())
			System.out.println(m);
	}

}
