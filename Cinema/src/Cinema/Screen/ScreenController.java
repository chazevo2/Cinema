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
		System.out.print("라인 수:");
		scr.setLine(sc.nextInt());
		System.out.print("라인별 좌석 수:");
		scr.setSeat(sc.nextInt());
		service.addScreen(scr);
	}

	public void editScreen(Scanner sc) {
		System.out.println("현재 등록된 상영관 목록");
		for(Screen scr : service.getAll())
			System.out.println(scr);
		Screen scr = new Screen();
		System.out.print("수정할 스크린 번호:");
		scr.setScrno(sc.nextInt());
		if (service.getScreen(scr.getScrno()) == null) {
			System.out.println("스크린을 찾지 못했습니다");
			editScreen(sc);
		}
		System.out.print("새 라인 수:");
		scr.setLine(sc.nextInt());
		System.out.print("새 라인별 좌석 수:");
		scr.setSeat(sc.nextInt());
		service.editScreen(scr);
		System.out.println("수정을 완료하였습니다.");
	}

	public void delScreen(Scanner sc) {
		System.out.println("현재 등록된 상영관 목록");
		for(Screen scr : service.getAll())
			System.out.println(scr);
		System.out.print("삭제할 스크린 번호:");
		int scrno = sc.nextInt();
		if (service.getScreen(scrno) == null) {
			System.out.println("스크린을 찾지 못했습니다.");
		} else {
			service.delScreen(scrno);
			System.out.println("삭제를 완료하였습니다.");
		}
	}

	public void search(Scanner sc) {
		System.out.print("찾을 스크린 번호:");
		Screen scr = service.getScreen(sc.nextInt());
		if (scr == null) {
			System.out.println("스크린을 찾지 못했습니다.");
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
			System.out.println("목록이 없습니다.");
			return;
		}
		for (Screen s : list)
			System.out.println(s);
	}

}
