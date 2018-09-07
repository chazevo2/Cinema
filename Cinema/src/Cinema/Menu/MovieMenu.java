package Cinema.Menu;

import java.util.Scanner;

import Cinema.Movie.MovieController;
import Cinema.Movie.MovieDaoImpl;
import Cinema.Movie.MovieServiceImpl;

public class MovieMenu {
	private MovieController movCont;

	public MovieMenu() {
		movCont = new MovieController(new MovieServiceImpl(new MovieDaoImpl()));
	}

	public void runAdmin(Scanner sc) {
		String str = "1.영화 추가 2.영화 검색 3.이름으로 검색 4.줄거리로 검색 \n5.장르로 검색 6.영화 삭제 7.영화 줄거리 수정 8.전체 검색 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				movCont.add(sc);
				break;
			case 2:
				movCont.search(sc);
				break;
			case 3:
				movCont.searchByName(sc);
				break;
			case 4:
				movCont.searchByStory(sc);
				break;
			case 5:
				movCont.searchByGenre(sc);
				break;
			case 6:
				movCont.delete(sc);
				break;
			case 7:
				movCont.editStory(sc);
				break;
			case 8:
				movCont.getAll();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}

	public void runMember(Scanner sc) {
		String str = "1.영화 검색 2.이름으로 검색 3.줄거리로 검색 4.장르로 검색 5.전체 검색 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				movCont.search(sc);
				break;
			case 2:
				movCont.searchByName(sc);
				break;
			case 3:
				movCont.searchByStory(sc);
				break;
			case 4:
				movCont.searchByGenre(sc);
				break;
			case 5:
				movCont.getAll();
				break;
			case 9:
				return;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}
