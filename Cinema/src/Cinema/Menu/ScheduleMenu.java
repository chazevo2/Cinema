package Cinema.Menu;

import java.util.Scanner;

import Cinema.Schedule.ScheduleController;
import Cinema.Schedule.ScheduleDaoImpl;
import Cinema.Schedule.ScheduleServiceImpl;

public class ScheduleMenu {
	private ScheduleController sCont;

	public ScheduleMenu() {
		sCont = new ScheduleController(new ScheduleServiceImpl(new ScheduleDaoImpl()));
	}

	public void runAdmin(Scanner sc) {
		String str = "1.�ð�ǥ �ۼ� 2.�ð�ǥ ���� 3.�ð�ǥ ���� 4.�ð�ǥ �˻� \n5.��ȭ�̸����� �˻� 6.�󿵽ð�ǥ 7.��ü�ð�ǥ 9.����";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				sCont.addSchedule(sc);
				break;
			case 2:
				sCont.editTime(sc);
				break;
			case 3:
				sCont.delSchedule(sc);
				break;
			case 4:
				sCont.searchSchedule(sc);
				break;
			case 5:
				sCont.getByMname(sc);
				break;
			case 6:
				sCont.getByToday();
				break;
			case 7:
				sCont.selectAll();
				break;
			case 9:
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public void runMember(Scanner sc) {
		String str = "1.�󿵽ð�ǥ 2.��ȭ�̸����� �˻� 9.����";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				sCont.getByToday();
				break;
			case 2:
				sCont.getByMname(sc);
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
