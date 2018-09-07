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
		String str = "1.시간표 작성 2.시간표 수정 3.시간표 삭제 4.시간표 검색 \n5.영화이름으로 검색 6.상영시간표 7.전체시간표 9.메인";
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
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public void runMember(Scanner sc) {
		String str = "1.상영시간표 2.영화이름으로 검색 9.메인";
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
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}
