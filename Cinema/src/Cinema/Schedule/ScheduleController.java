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
		System.out.print("��ȭ ��ȣ:");
		s.setMno(sc.nextInt());
		System.out.print("��ȭ �� ��¥(yy/mm/dd):");
		s.setMday(sc.next());
		System.out.print("��ȭ �󿵽ð�(HH24:MI):");
		s.setMtime(sc.next());
		System.out.print("Ƽ�� ����:");
		s.setSprice(sc.nextInt());
		System.out.print("��ũ�� ��ȣ:");
		s.setScrno(sc.nextInt());
		Screen scr = ScreenController.getSeatno(s.getScrno());
		s.setEx_seat(scr.getLine()*scr.getSeat());
		System.out.println(scr);
		if (service.getScr(s) < 0) {
			service.addSchedule(s);
			System.out.println("�߰��� �Ϸ� �Ǿ����ϴ�.");
		} else {
			System.out.println("����� �󿵰��� �ش�ð��� ��뿹���Դϴ�");
			System.out.println("�߰��� �����Ͽ����ϴ�.");
		}
	}

	public void delSchedule(Scanner sc) {
		System.out.print("������ ������ ��ȣ:");
		int sno = sc.nextInt();
		if (service.getSchedule(sno) == null) {
			System.out.println("�߸��� ������ ��ȣ�Դϴ�.");
		} else {
			service.delSchedule(sno);
			System.out.println("�������� ������ �Ϸ� �Ǿ����ϴ�.");
		}
	}

	public void editTime(Scanner sc) {
		Schedule s = new Schedule();
		System.out.print("���� ������ ��ȣ:");
		s.setSno(sc.nextInt());
		System.out.print("������ ��ȭ �󿵽ð�:");
		s.setMtime(sc.next());
		Schedule s2 = service.getSchedule(s.getSno());
		s.setScrno(s2.getScrno());
		s.setMday(s2.getMday());
		if (service.getScr(s) < 0) {
			service.editTime(s);
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
		} else {
			System.out.println("����� �󿵰��� �ش�ð��� ��뿹���Դϴ�");
			System.out.println("������ �����Ͽ����ϴ�.");
		}
	}

	public static void editSeat(int sno, int sign) {
		s.editSeat(sno, sign);
	}

	public void searchSchedule(Scanner sc) {
		System.out.print("ã�� ������ ��ȣ:");
		Schedule s = service.getSchedule(sc.nextInt());
		if (s == null)
			System.out.println("�߸��� ������ ��ȣ�Դϴ�");
		else
			System.out.println(s);
	}

	public void getByMname(Scanner sc) {
		System.out.print("ã�� ��ȭ �̸�:");
		ArrayList<Schedule> list = service.getByMname(sc.nextLine());
		list = service.getByMname(sc.nextLine());
		if (list != null) {
			System.out.println(list);
		} else {
			System.out.println("ã�� ��ȭ�� �����ϴ�.");
		}
	}

	public void getByToday() {
		ArrayList<Schedule> list = service.getByToday();
		if (list == null) {
			System.out.println("����� �����ϴ�.");
			flag = false;
		} else {
			System.out.println("����� �ֽ��ϴ�.");
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
			System.out.println("����� �����ϴ�.");
			return;
		}
		for (Schedule s : list) {
			System.out.println(s);
		}
	}

}
