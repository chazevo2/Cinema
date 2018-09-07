package Cinema.Menu;

import java.util.Scanner;

public class Menu {
	private MovieMenu movMenu;
	private MembersMenu memMenu;
	private ScreenMenu scrMenu;
	private ReviewMenu rMenu;
	private ScheduleMenu sMenu;
	private TicketMenu tMenu;

	public Menu() {
		movMenu = new MovieMenu();
		memMenu = new MembersMenu();
		scrMenu = new ScreenMenu();
		rMenu = new ReviewMenu();
		sMenu = new ScheduleMenu();
		tMenu = new TicketMenu();

	}

	public void run(Scanner sc) {
		String str = "1.���� 2.��ȭ 3.���� 4.�ð�ǥ 5.���� 9.����";
		int menu;
		while (true) {
			if (memMenu.getmCont().getLoginId().equals("admin"))
				str = "1.���� 2.��ȭ 3.���� 4.�ð�ǥ 5.���� 6.�󿵰� 9.����";
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				if (memMenu.getmCont().getLoginId().equals(""))
					memMenu.run(sc);
				else
					memMenu.running(sc);
				break;
			case 2:
				if (memMenu.getmCont().getLoginId().equals("admin"))
					movMenu.runAdmin(sc);
				else
					movMenu.runMember(sc);
				break;
			case 3:
				if (memMenu.getmCont().getLoginId().equals("admin"))
					tMenu.runAdmin(sc);
				else {
					if (memMenu.getmCont().getLoginId().equals("")) {
						System.out.println("�α��� ���� ���ּ���");
						break;
					}
					tMenu.runMember(sc);
				}
				break;
			case 4:
				if (memMenu.getmCont().getLoginId().equals("admin"))
					sMenu.runAdmin(sc);
				else
					sMenu.runMember(sc);
				break;
			case 5:
				rMenu.run(sc);
				break;
			case 6:
				if (memMenu.getmCont().getLoginId().equals("admin"))
					scrMenu.runAdmin(sc);
				else
					System.out.println("�߸��� �Է��Դϴ�.");
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
