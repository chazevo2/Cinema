package Cinema.Menu;

import java.util.Scanner;

import Cinema.Members.MembersController;
import Cinema.Schedule.ScheduleController;
import Cinema.Schedule.ScheduleDaoImpl;
import Cinema.Schedule.ScheduleServiceImpl;
import Cinema.Ticket.TicketController;
import Cinema.Ticket.TicketDaoImpl;
import Cinema.Ticket.TicketServiceImpl;

public class TicketMenu {
	private TicketController tCont;
	private ScheduleController sCont;

	public TicketMenu() {
		tCont = new TicketController(new TicketServiceImpl(new TicketDaoImpl()));
		sCont = new ScheduleController(new ScheduleServiceImpl(new ScheduleDaoImpl()));
	}

	public void runAdmin(Scanner sc) {
		String str = "1.예매 서비스 2.예매 취소 서비스 3.좌석 변경 서비스 4.전체 예매 출력 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				sCont.getByToday();
				if (!sCont.isFlag())
					break;
				else {
					tCont.addTicket(sc);
					break;
				}
			case 2:
				tCont.delTicket(sc);
				break;
			case 3:
				tCont.editSeatno(sc);
				break;
			case 4:
				tCont.getAll();
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
		String str = "1.예매 하기 2.예매 취소 3.좌석 변경 4.예매 번호 검색 5.관람 내역 출력 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				sCont.getByToday();
				if (!sCont.isFlag())
					break;
				else {
					tCont.addTicket(sc);
					break;
				}
			case 2:
				tCont.delTicket(sc);
				break;
			case 3:
				tCont.editSeatno(sc);
				break;
			case 4:
				tCont.getTicket(sc);
				break;
			case 5:
				tCont.getByMid(sc);
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
