package Cinema.Members;

import java.util.Scanner;

public class MembersController {
	private MembersService service;
	private static MembersService s;
	private static String LoginId = "";

	public static String getLoginId() {
		return LoginId;
	}

	@SuppressWarnings("static-access")
	public MembersController(MembersService service) {
		this.service = service;
		this.s = service;
	}

	// TODO Auto-generated method stub
	public void join(Scanner sc) { // ����
		Members m = new Members();
		System.out.print("ȸ�� ���̵�:");
		m.setMid(sc.next());
		if (service.getMembers(m.getMid()) != null) {
			System.out.println("�̹� ���� ���̵��Դϴ�.");
			join(sc);
		}
		System.out.print("�н�����:");
		m.setPwd(sc.next());
		System.out.print("�н����� Ȯ��:");
		if (sc.next().equals(m.getPwd()))
			System.out.println("�н����� ��ġ");
		else {
			System.out.println("�н����� ����ġ");
			join(sc);
		}
		System.out.print("���� �̸�(eng):");
		m.setUname(sc.next());
		System.out.print("�������(yyyy/mm/dd):");
		m.setBirth(sc.next());
		
		service.addMembers(m);
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
	}

	public void login(Scanner sc) {
		if (!LoginId.equals("")) {
			System.out.println("�̹� �α��� ������");
			return;
		}
		Members m = new Members();
		System.out.print("ȸ�� ���̵�:");
		m.setMid(sc.next());
		System.out.print("�н�����:");
		m.setPwd(sc.next());
		boolean flag = service.login(m);
		if (flag) {
			System.out.println("�α����� �����Ǿ����ϴ�");
			LoginId = m.getMid();
		} else {
			System.out.println("�α��ο� �����Ͽ����ϴ�");
		}
	}

	public void logout() {
		if (LoginId.equals("")) {
			System.out.println("�α����� ���� �Ͻʽÿ�.");
			return;
		}
		LoginId = "";
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}

	public boolean myInfo() {
		if (LoginId.equals("")) {
			System.out.println("�α����� ���� �Ͻʽÿ�.");
			return false;
		}
		Members m = service.getMembers(LoginId);
		System.out.println(m);
		return true;

	}

	public void findMyid(Scanner sc) {
		Members m = new Members();
		System.out.println("���� �̸�(eng):");
		m.setUname(sc.next());
		System.out.println("�������(yyyy/mm/dd):");
		m.setBirth(sc.next());
		if(service.getId(m) == null) {
			System.out.println("���̵� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("�˻��� id��");
		for (String s : service.getId(m))
			System.out.println(s);
	}

	public void delMembers(Scanner sc) {
		if (LoginId.equals("")) {
			System.out.println("�α����� ���� �Ͻʽÿ�.");
			return;
		}
		System.out.println("���� Ż�� �Ͻǰ̴ϱ�? yes, no");
		String str = sc.next();
		if (str.equals("yes")) {
			service.delMembers(LoginId);
			LoginId = "";
			System.out.println("Ż�� �Ϸ� �Ǿ����ϴ�.");
		} else {
			System.out.println("Ż�� ��� �Ǿ����ϴ�.");
		}
	}

	public void editPwd(Scanner sc) {
		boolean flag = myInfo();
		if (flag) {
			Members m = new Members();
			m.setMid(LoginId);
			System.out.print("���ο� ��й�ȣ:");
			m.setPwd(sc.next());
			System.out.print("���ο� ��й�ȣ Ȯ��:");
			if (sc.next().equals(m.getPwd()))
				service.editPwd(m);
			else
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
		}
	}

	public static int age(String mid) {
		return s.age(mid);
	}

	public static int getPoint(String mid) {
		return s.getMembers(mid).getPoint();
	}
	
	public static void usePoint(Members m, int sign) {
		s.editPoint(m, sign);;
	}

	public void getAll() {
		if(service.getAll() == null) {
			System.out.println("����� ������ϴ�.");
			return;
		}
		for (Members m : service.getAll())
			System.out.println(m);
	}

}
