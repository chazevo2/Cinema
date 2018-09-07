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
		String str = "1.���� ���� 2.���� ��� ���� 3.�¼� ���� ���� 4.��ü ���� ��� 9.����";
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
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public void runMember(Scanner sc) {
		String str = "1.���� �ϱ� 2.���� ��� 3.�¼� ���� 4.���� ��ȣ �˻� 5.���� ���� ��� 9.����";
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
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}
