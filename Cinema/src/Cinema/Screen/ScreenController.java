package Cinema.Screen;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Ticket.TicketController;

public class ScreenController {
	private ScreenService service;
	private static ScreenService s;

	@SuppressWarnings("static-access")
	public ScreenController(ScreenService service) {
		this.service = service;
		this.s = service;
	}

	public void addScreen(Scanner sc) {
		Screen scr = new Screen();
		System.out.print("���� ��:");
		scr.setLine(sc.nextInt());
		System.out.print("���κ� �¼� ��:");
		scr.setSeat(sc.nextInt());
		service.addScreen(scr);
	}

	public void editScreen(Scanner sc) {
		System.out.println("���� ��ϵ� �󿵰� ���");
		for(Screen scr : service.getAll())
			System.out.println(scr);
		Screen scr = new Screen();
		System.out.print("������ ��ũ�� ��ȣ:");
		scr.setScrno(sc.nextInt());
		if (service.getScreen(scr.getScrno()) == null) {
			System.out.println("��ũ���� ã�� ���߽��ϴ�");
			editScreen(sc);
		}
		System.out.print("�� ���� ��:");
		scr.setLine(sc.nextInt());
		System.out.print("�� ���κ� �¼� ��:");
		scr.setSeat(sc.nextInt());
		service.editScreen(scr);
		System.out.println("������ �Ϸ��Ͽ����ϴ�.");
	}

	public void delScreen(Scanner sc) {
		System.out.println("���� ��ϵ� �󿵰� ���");
		for(Screen scr : service.getAll())
			System.out.println(scr);
		System.out.print("������ ��ũ�� ��ȣ:");
		int scrno = sc.nextInt();
		if (service.getScreen(scrno) == null) {
			System.out.println("��ũ���� ã�� ���߽��ϴ�.");
		} else {
			service.delScreen(scrno);
			System.out.println("������ �Ϸ��Ͽ����ϴ�.");
		}
	}

	public void search(Scanner sc) {
		System.out.print("ã�� ��ũ�� ��ȣ:");
		Screen scr = service.getScreen(sc.nextInt());
		if (scr == null) {
			System.out.println("��ũ���� ã�� ���߽��ϴ�.");
		} else {
			System.out.println(scr);
		}
	}

	public static Screen getSeatno(int scrno) {
		Screen scr = s.getScreen(scrno);
		return scr;
	}

	public void searchAll() {
		ArrayList<Screen> list = service.getAll();
		if(list == null) {
			System.out.println("����� �����ϴ�.");
			return;
		}
		for (Screen s : list)
			System.out.println(s);
	}

}
