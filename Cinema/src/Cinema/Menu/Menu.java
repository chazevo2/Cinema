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
		String str = "1.계정 2.영화 3.예매 4.시간표 5.리뷰 9.종료";
		int menu;
		while (true) {
			if (memMenu.getmCont().getLoginId().equals("admin"))
				str = "1.계정 2.영화 3.예매 4.시간표 5.리뷰 6.상영관 9.종료";
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
						System.out.println("로그인 먼저 해주세요");
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
					System.out.println("잘못된 입력입니다.");
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
