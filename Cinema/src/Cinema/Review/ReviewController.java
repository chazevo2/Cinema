package Cinema.Review;

import java.util.ArrayList;
import java.util.Scanner;

import Cinema.Members.MembersController;

public class ReviewController {
	private ReviewService service;

	public ReviewController(ReviewService service) {
		this.service = service;
	}

	public void write(Scanner sc) {
		Review r = new Review();
		r.setMid(MembersController.getLoginId());
		if(r.getMid().equals("")) {
			System.out.println("�α��� �� �̿�ٶ��ϴ�.");
			return;
		}
		System.out.print("��ȭ ��ȣ:");
		r.setMno(sc.nextInt());
		System.out.print("����(0 ~ 100):");
		r.setScore(sc.nextInt());
		if(r.getScore() > 100 || r.getScore() < 0) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		System.out.print("�ı�(100�� �̳�):");
		r.setMemo(sc.nextLine());
		r.setMemo(sc.nextLine());
		service.addReview(r);
		System.out.println("�߰� �Ϸ�");
	}

	public void rewrite(Scanner sc) {
		Review r = new Review();
		if(MembersController.getLoginId().equals("")) {
			System.out.println("�α��� �� �̿�ٶ��ϴ�.");
			return;
		}
		ArrayList<Review> list = service.getByMid(MembersController.getLoginId());
		if(list == null) {
			System.out.println("�ۼ����� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("���� �ۼ��� ������");
		for(Review r2 : list)
			System.out.println(r2);
		System.out.print("������ ������ ��ȣ:");
		r.setRno(sc.nextInt());
		Review r3 = service.getMovie(r.getRno());
		if (r3 == null) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		if (r3.getMid().equals(MembersController.getLoginId())) {
			System.out.print("������ ����(0 ~ 100):");
			r.setScore(sc.nextInt());
			System.out.print("������ �ı� ����:");
			r.setMemo(sc.next());
			service.editReview(r);
			System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
		} else {
			System.out.println("���� �۸� ���� �����մϴ�.");
		}

	}

	public void delete(Scanner sc) {
		if(MembersController.getLoginId().equals("")) {
			System.out.println("�α��� �� �̿�ٶ��ϴ�.");
			return;
		}
		System.out.println("���� �ۼ��� ������");
		ArrayList<Review> list = service.getByMid(MembersController.getLoginId());
		if(list == null) {
			System.out.println("�ۼ����� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("���� �ۼ��� ������");
		for(Review r1 : list)
			System.out.println(r1);
		System.out.print("������ ������ ��ȣ:");
		Review r2 = service.getMovie(sc.nextInt());
		if (r2 == null) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		}
		if (r2.getMid().equals(MembersController.getLoginId())) {
			service.delReview(r2.getRno());
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("������ �۸� ���� �����մϴ�.");
		}

	}

	public void search(Scanner sc) {
		System.out.print("�˻��� ���� ��ȣ:");
		Review r = service.getMovie(sc.nextInt());
		if (r == null) {
			System.out.println("�߸��� �Է��Դϴ�.");
			return;
		} else {
			System.out.println(r);
		}
	}

	public void searchByName(Scanner sc) {
		System.out.println("�˻��� ��ȭ �̸�:");
		ArrayList<Review> list = service.getByMname(sc.nextLine());
		list = service.getByMname(sc.nextLine());
		if (list == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		}
		for (Review r : list) {
			System.out.println(r);
		}
	}

	public void searchAVG() {
		if (service.getAvgScore() == null) {
			System.out.println("����� ������ϴ�.");
			return;
		}
		for (Review r : service.getAvgScore()) {
			System.out.println("Review [mname=" + r.getMname() + ", write=" + r.getMid() + "��, avg(score)=" + r.getScore() + "]");
		}
	}

	public void searchByScore(Scanner sc) {
		System.out.print("�˻��� ����:");
		int score = sc.nextInt();
		ArrayList<Review> list = service.getByScore(score);
		if (list == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.println("������ " + score + "�̻��� �˻� ��ϵ��Դϴ�.");
		for (Review r : list) {
			System.out.println(r);
		}
	}

	public void searchAll() {
		if (service.getAll() == null) {
			System.out.println("����� ������ϴ�.");
			return;
		}
		for (Review r : service.getAll()) {
			System.out.println(r);
		}
	}

}
