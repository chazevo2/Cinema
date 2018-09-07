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
		System.out.print("영화 제목:");
		m.setMname(sc.nextLine());
		m.setMname(sc.nextLine());
		System.out.print("영화 줄거리(50자 이내):");
		m.setStory(sc.nextLine());
		System.out.print("상영 시간(분):");
		m.setRuntime(sc.nextInt());
		System.out.print("영화 장르:");
		m.setGenre(sc.next());
		System.out.print("관람 등급(연령제한):");
		m.setRate(sc.nextInt());
		service.addMovie(m);
		System.out.println("추가 완료 되었습니다.");
	}

	public void search(Scanner sc) {
		System.out.print("찾을 영화 번호:");
		int mno = sc.nextInt();
		Movie m = service.getMovie(mno);
		if (m == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		} else {
			System.out.println(m);
		}
	}

	public static int getRate(int mno) {
		return s.getMovie(mno).getRate();
	}

	public void searchByName(Scanner sc) {
		System.out.println("찾을 영화 제목:");
		String mname = sc.nextLine();
		mname = sc.nextLine();
		ArrayList<Movie> list = service.getByName(mname);

		if (list == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		} else {
			for (Movie m : list) {
				System.out.println(m);
			}
		}

	}

	public void searchByStory(Scanner sc) {
		System.out.println("찾을 영화 내용:");
		String story = sc.nextLine();
		story = sc.nextLine();
		ArrayList<Movie> list = service.getByStory(story);
		if (list == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		} else {
			for (Movie m : list)
				System.out.println(m);
		}
	}

	public void searchByGenre(Scanner sc) {
		System.out.println("찾을 영화 장르:");
		String genre = sc.next();
		ArrayList<Movie> list = service.getByGenre(genre);
		if (list == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		} else {
			for (Movie m : list)
				System.out.println(m);
		}
	}

	public void delete(Scanner sc) {
		System.out.print("삭제할 영화의 번호:");
		int mno = sc.nextInt();
		Movie m = service.getMovie(mno);
		if (m == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		} else {
			service.delMovie(mno);
			System.out.println("해당 영화가 삭제 되었습니다.");
		}

	}

	public void editStory(Scanner sc) {
		Movie m = new Movie();
		System.out.print("수정할 영화의 번호:");
		m.setMno(sc.nextInt());
		Movie m2 = service.getMovie(m.getMno());
		if (m2 == null) {
			System.out.println("검색하신 영화가 존재하지 않습니다.");
			return;
		} else {
			System.out.print("수정할 영화 줄거리(50자 이내):");
			m.setStory(sc.next());
			service.editMovie(m);
			System.out.println("변경이 완료되었습니다.");
		}

	}

	public void getAll() {
		if (service.getAll() == null) {
			System.out.println("목록이 비었습니다.");
			return;
		}
		for (Movie m : service.getAll()) {
			System.out.println(m);
		}
	}

}
