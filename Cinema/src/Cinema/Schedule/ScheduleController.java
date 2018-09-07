package Cinema.Schedule;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Screen.Screen;
import Cinema.Screen.ScreenController;

public class ScheduleController {
	private ScheduleService service;
	private static ScheduleService s;
	private static boolean flag;

	@SuppressWarnings("static-access")
	public ScheduleController(ScheduleService service) {
		this.service = service;
		this.s = service;
		flag = false;
	}
	
	public static boolean isFlag() {
		return flag;
	}

	public void addSchedule(Scanner sc) {
		Schedule s = new Schedule();
		System.out.print("영화 번호:");
		s.setMno(sc.nextInt());
		System.out.print("영화 상영 날짜(yy/mm/dd):");
		s.setMday(sc.next());
		System.out.print("영화 상영시간(HH24:MI):");
		s.setMtime(sc.next());
		System.out.print("티켓 가격:");
		s.setSprice(sc.nextInt());
		System.out.print("스크린 번호:");
		s.setScrno(sc.nextInt());
		Screen scr = ScreenController.getSeatno(s.getScrno());
		s.setEx_seat(scr.getLine()*scr.getSeat());
		System.out.println(scr);
		if (service.getScr(s) < 0) {
			service.addSchedule(s);
			System.out.println("추가가 완료 되었습니다.");
		} else {
			System.out.println("등록할 상영관이 해당시간에 사용예정입니다");
			System.out.println("추가가 실패하였습니다.");
		}
	}

	public void delSchedule(Scanner sc) {
		System.out.print("삭제할 스케줄 번호:");
		int sno = sc.nextInt();
		if (service.getSchedule(sno) == null) {
			System.out.println("잘못된 스케줄 번호입니다.");
		} else {
			service.delSchedule(sno);
			System.out.println("스케줄이 삭제가 완료 되었습니다.");
		}
	}

	public void editTime(Scanner sc) {
		Schedule s = new Schedule();
		System.out.print("기존 스케줄 번호:");
		s.setSno(sc.nextInt());
		System.out.print("수정할 영화 상영시간:");
		s.setMtime(sc.next());
		Schedule s2 = service.getSchedule(s.getSno());
		s.setScrno(s2.getScrno());
		s.setMday(s2.getMday());
		if (service.getScr(s) < 0) {
			service.editTime(s);
			System.out.println("수정이 완료 되었습니다.");
		} else {
			System.out.println("등록할 상영관이 해당시간에 사용예정입니다");
			System.out.println("수정을 실패하였습니다.");
		}
	}

	public static void editSeat(int sno, int sign) {
		s.editSeat(sno, sign);
	}

	public void searchSchedule(Scanner sc) {
		System.out.print("찾을 스케줄 번호:");
		Schedule s = service.getSchedule(sc.nextInt());
		if (s == null)
			System.out.println("잘못된 스케줄 번호입니다");
		else
			System.out.println(s);
	}

	public void getByMname(Scanner sc) {
		System.out.print("찾을 영화 이름:");
		ArrayList<Schedule> list = service.getByMname(sc.nextLine());
		list = service.getByMname(sc.nextLine());
		if (list != null) {
			System.out.println(list);
		} else {
			System.out.println("찾는 영화가 없습니다.");
		}
	}

	public void getByToday() {
		ArrayList<Schedule> list = service.getByToday();
		if (list == null) {
			System.out.println("목록이 없습니다.");
			flag = false;
		} else {
			System.out.println("목록이 있습니다.");
			for (Schedule s : list) {
				System.out.println(s);
			}
			flag = true;
		}
	}
	
	public static int getScrno(int sno) {
		return s.getSchedule(sno).getScrno();
	}

	public static int getPrice(int sno) {
		return s.getSchedule(sno).getSprice();
	}

	public void selectAll() {
		ArrayList<Schedule> list = service.selectAll();
		if (list == null) {
			System.out.println("목록이 없습니다.");
			return;
		}
		for (Schedule s : list) {
			System.out.println(s);
		}
	}

}
