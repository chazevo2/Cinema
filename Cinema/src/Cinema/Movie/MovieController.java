package Cinema.Movie;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieController {
	private MovieService service;
	private static MovieService s;

	@SuppressWarnings("static-access")
	public MovieController(MovieService service) {
		this.service = service;
		this.s = service;
	}

	public void add(Scanner sc) {
		Movie m = new Movie();
		System.out.print("��ȭ ����:");
		m.setMname(sc.nextLine());
		m.setMname(sc.nextLine());
		System.out.print("��ȭ �ٰŸ�(50�� �̳�):");
		m.setStory(sc.nextLine());
		System.out.print("�� �ð�(��):");
		m.setRuntime(sc.nextInt());
		System.out.print("��ȭ �帣:");
		m.setGenre(sc.next());
		System.out.print("���� ���(��������):");
		m.setRate(sc.nextInt());
		service.addMovie(m);
		System.out.println("�߰� �Ϸ� �Ǿ����ϴ�.");
	}

	public void search(Scanner sc) {
		System.out.print("ã�� ��ȭ ��ȣ:");
		int mno = sc.nextInt();
		Movie m = service.getMovie(mno);
		if (m == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		} else {
			System.out.println(m);
		}
	}

	public static int getRate(int mno) {
		return s.getMovie(mno).getRate();
	}

	public void searchByName(Scanner sc) {
		System.out.println("ã�� ��ȭ ����:");
		String mname = sc.nextLine();
		mname = sc.nextLine();
		ArrayList<Movie> list = service.getByName(mname);

		if (list == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		} else {
			for (Movie m : list) {
				System.out.println(m);
			}
		}

	}

	public void searchByStory(Scanner sc) {
		System.out.println("ã�� ��ȭ ����:");
		String story = sc.nextLine();
		story = sc.nextLine();
		ArrayList<Movie> list = service.getByStory(story);
		if (list == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		} else {
			for (Movie m : list)
				System.out.println(m);
		}
	}

	public void searchByGenre(Scanner sc) {
		System.out.println("ã�� ��ȭ �帣:");
		String genre = sc.next();
		ArrayList<Movie> list = service.getByGenre(genre);
		if (list == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		} else {
			for (Movie m : list)
				System.out.println(m);
		}
	}

	public void delete(Scanner sc) {
		System.out.print("������ ��ȭ�� ��ȣ:");
		int mno = sc.nextInt();
		Movie m = service.getMovie(mno);
		if (m == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		} else {
			service.delMovie(mno);
			System.out.println("�ش� ��ȭ�� ���� �Ǿ����ϴ�.");
		}

	}

	public void editStory(Scanner sc) {
		Movie m = new Movie();
		System.out.print("������ ��ȭ�� ��ȣ:");
		m.setMno(sc.nextInt());
		Movie m2 = service.getMovie(m.getMno());
		if (m2 == null) {
			System.out.println("�˻��Ͻ� ��ȭ�� �������� �ʽ��ϴ�.");
			return;
		} else {
			System.out.print("������ ��ȭ �ٰŸ�(50�� �̳�):");
			m.setStory(sc.next());
			service.editMovie(m);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}

	}

	public void getAll() {
		if (service.getAll() == null) {
			System.out.println("����� ������ϴ�.");
			return;
		}
		for (Movie m : service.getAll()) {
			System.out.println(m);
		}
	}

}
