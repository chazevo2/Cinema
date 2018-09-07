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
		String str = "1.ȸ�� ���� 2.�α��� 3.���̵� ã�� 9.����";
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
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public void running(Scanner sc) {
		String str = "1.�α׾ƿ� 2.�� ���� Ȯ�� 3.��й�ȣ ���� 4.Ż�� 9.����";
		if (mCont.getLoginId().equals("admin"))
			str = "1.�α׾ƿ� 2.�� ���� Ȯ�� 3.��й�ȣ ���� 4.Ż�� 5.��ü����� ��� 9.����";
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
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}
				mCont.getAll();
				break;
			case 9:
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}

		}
	}

}
