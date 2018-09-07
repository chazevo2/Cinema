package Cinema.Menu;

import java.util.Scanner;

import Cinema.Members.MembersController;
import Cinema.Members.MembersDaoImpl;
import Cinema.Members.MembersServiceImpl;

public class MembersMenu {
	private MembersController mCont;

	public MembersController getmCont() {
		return mCont;
	}

	public MembersMenu() {
		mCont = new MembersController(new MembersServiceImpl(new MembersDaoImpl()));
	}

	public void run(Scanner sc) {
		String str = "1.회원 가입 2.로그인 3.아이디 찾기 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				mCont.join(sc);
				break;
			case 2:
				mCont.login(sc);
				return;
			case 3:
				mCont.findMyid(sc);
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public void running(Scanner sc) {
		String str = "1.로그아웃 2.내 정보 확인 3.비밀번호 변경 4.탈퇴 9.메인";
		if (mCont.getLoginId().equals("admin"))
			str = "1.로그아웃 2.내 정보 확인 3.비밀번호 변경 4.탈퇴 5.전체사용자 출력 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				mCont.logout();
				return;
			case 2:
				mCont.myInfo();
				break;
			case 3:
				mCont.editPwd(sc);
				break;
			case 4:
				mCont.delMembers(sc);
				return;
			case 5:
				if (!mCont.getLoginId().equals("admin")) {
					System.out.println("잘못된 입력입니다.");
					break;
				}
				mCont.getAll();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}

		}
	}

}
