package Cinema.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Members.Members;
import Cinema.Members.MembersController;
import Cinema.Movie.MovieController;
import Cinema.Schedule.ScheduleController;
import Cinema.Screen.Screen;
import Cinema.Screen.ScreenController;

public class TicketController {
	private TicketService service;
	private String[][] seatall;

	public TicketController(TicketService service) {
		this.service = service;
	}

	public ArrayList<String> using(Ticket t) {
		ArrayList<String> useSeat = new ArrayList<String>();
		ArrayList<Ticket> list = service.getBySno(t.getSno());
		if (list == null)
			return null;
		for (Ticket t2 : list) {
			useSeat.add(t2.getSeatno());
		}
		return useSeat;
	}

	public boolean seatView(Ticket t, int scrno) {
		Screen scr = ScreenController.getSeatno(scrno);
		String[][] view = new String[scr.getLine()][scr.getSeat()];
		ArrayList<String> useSeat;
		if (using(t) != null)
			useSeat = using(t);
		else
			useSeat = null;
		String seatno = "";
		int cnt = 0;
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				seatno = (char) (i + 97) + "" + (j + 1);
				if (using(t) != null) {
					if (!useSeat.contains(seatno))
						view[i][j] = seatno;
					else {
						view[i][j] = "x";
						cnt++;
					}
				} else {
					view[i][j] = seatno;
				}
			}
		}
		seatall = setView(view);
		if (cnt == (view.length) * (view[0].length)) {
			System.out.println("전좌석 매진입니다.");
			return false;
		}
		for (int i = 0; i < 4 * view[0].length / 3 + view[0].length % 3 - 1; i++) {
			System.out.print(" ");
		}
		System.out.println("Screen");
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				System.out.printf("%4s", view[i][j]);
			}
			System.out.println();
		}
		return true;
	}

	public String[][] setView(String[][] view) {
		return view;
	}

	public String[][] getView() {
		return seatall;
	}

	public void addTicket(Scanner sc) {
		Ticket t = new Ticket();
		Members m = new Members();
		t.setMid(MembersController.getLoginId());
		if (t.getMid().equals("admin")) {
			System.out.print("회원 ID:");
			t.setMid(sc.next());
		}
		m.setMid(t.getMid());
		System.out.print("영화 번호:");
		t.setMno(sc.nextInt());
		int rate = MovieController.getRate(t.getMno());
		int age = MembersController.age(t.getMid());
		if (age < rate) {
			System.out.println("연령제한으로 티켓구매가 불가능합니다");
			return;
		}
		System.out.print("스케줄 번호:");
		t.setSno(sc.nextInt());
		int price = ScheduleController.getPrice(t.getSno());
		System.out.println("티켓 가격:" + price + "입니다.");
		int point = MembersController.getPoint(t.getMid());
		System.out.println("현재 보유 포인트:" + point);
		System.out.println("예매취소시 포인트는 환불이 불가능합니다.");
		System.out.print("사용할 포인트(0 ~ " + point + "):");
		int usePoint = sc.nextInt();
		if (usePoint <= point)
			t.setTprice(price - usePoint);
		else {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		m.setPoint(usePoint);
		boolean flag = seatView(t, ScheduleController.getScrno(t.getSno()));
		if (!flag) {
			return;
		}
		System.out.println("좌석 번호:");
		t.setSeatno(sc.next());
		if (using(t) != null) {
			for (String a : using(t)) {
				if (a.equals(t.getSeatno())) {
					System.out.println("이미 사용중인 좌석을 선택하셨습니다");
					return;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < getView().length; i++) {
			for (int j = 0; j < getView()[i].length; j++) {
				if (!t.getSeatno().equals(getView()[i][j]))
					cnt++;
				else
					break;
			}
			if (cnt == getView().length * getView()[i].length) {
				System.out.println("존재하지 않는 좌석번호입니다.");
				return;
			}
		}
		service.addTicket(t);
		ScheduleController.editSeat(t.getSno(), 0);
		MembersController.usePoint(m, 0);
		System.out.println("예매가 완료되었습니다.");
	}

	public void delTicket(Scanner sc) {
		ArrayList<Ticket> list;
		String mid;
		if (MembersController.getLoginId().equals("admin")) {
			System.out.print("회원 ID:");
			mid = sc.next();
			list = service.getByMid(mid);
		} else {
			mid = MembersController.getLoginId();
			list = service.getByMid(mid);
		}
		if (list == null) {
			System.out.println("예매 기록이 없습니다.");
			return;
		}
		for (Ticket t : list)
			System.out.println(t);
		System.out.print("예매 취소할 티켓 번호:");
		int tno = sc.nextInt();
		Ticket t = service.getTicket(tno);
		if (t == null)
			System.out.println("잘못된 예매 번호입니다");
		if (t.getMid().equals(mid))
			service.delTicket(tno);
		ScheduleController.editSeat(t.getSno(), 1);
		System.out.println("예매가 취소되었습니다.");
	} // 예매취소

	public void editSeatno(Scanner sc) {
		ArrayList<Ticket> list;
		Ticket t = new Ticket();
		if (MembersController.getLoginId().equals("admin")) {
			System.out.println("회원 ID");
			String mid = sc.next();
			list = service.getByMid(mid);
			t.setMid(mid);
		} else {
			list = service.getByMid(MembersController.getLoginId());
			t.setMid(MembersController.getLoginId());
		}
		if (list == null) {
			System.out.println("예매 기록이 없습니다.");
			return;
		}
		for (Ticket t2 : list)
			System.out.println(t2);
		System.out.println("수정할 티켓 번호:");
		t.setTno(sc.nextInt());
		Ticket t2 = service.getTicket(t.getTno());
		if (t2 == null) {
			System.out.println("잘못된 예매 번호입니다");
			return;
		}
		String Today = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm").format(new java.util.Date());
		String strmmdd = t2.getMdate().substring(3, 5) + t2.getMdate().substring(6, 8) + t2.getMdate().substring(9, 11)
				+ t2.getMdate().substring(12, 14);
		String strToday = Today.substring(5, 7) + Today.substring(8, 10) + Today.substring(11, 13)
				+ Today.substring(14, 16);
		int mmdd = Integer.parseInt(strmmdd);
		int TodayInt = Integer.parseInt(strToday);
		if (mmdd < TodayInt) {
			System.out.println("이미 지난 예매입니다.");
			return;
		}
		System.out.println("나의 좌석:" + t2.getSeatno());
		boolean flag = seatView(t2, t2.getScrno());
		if (!flag) {
			System.out.println("좌석을 수정할 수 없습니다.");
			return;
		}
		System.out.println("좌석 번호:");
		t.setSeatno(sc.next());
		if (using(t) != null) {
			if(t2.getSeatno().equals(t.getSeatno())) {
				System.out.println("기존 좌석과 동일합니다.");
				return;
			}
			for (String a : using(t)) {
				if (a.equals(t.getSeatno())) {
					System.out.println("이미 사용중인 좌석을 선택하셨습니다");
					return;
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < getView().length; i++) {
			for (int j = 0; j < getView()[i].length; j++) {
				if (!t.getSeatno().equals(getView()[i][j]))
					cnt++;
				else
					break;
			}
			if (cnt == getView().length * getView()[i].length) {
				System.out.println("존재하지 않는 좌석번호입니다.");
				return;
			}
		}
		service.editSeatno(t);
		System.out.println("좌석 변경 완료");
	}

	public void getTicket(Scanner sc) {
		System.out.println("찾을 티켓 번호: ");
		Ticket t = service.getTicket(sc.nextInt());
		if (t == null)
			System.out.println("잘못된 예매번호입니다");
		else
			System.out.println(t);
	}

	public void getByMid(Scanner sc) {
		ArrayList<Ticket> list = service.getByMid(MembersController.getLoginId());
		if (list != null) {
			System.out.println(list);
		} else {
			System.out.println("해당되는 내용이 없습니다");
		}
	}

	public void getAll() {
		ArrayList<Ticket> list = service.getAll();
		if (list == null) {
			System.out.println("예매 기록이 없습니다.");
			return;
		}
		for (Ticket t : list) {
			System.out.println(t);
		}
	}

}
