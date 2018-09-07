package Cinema.Menu;

import java.util.Scanner;

import Cinema.Members.MembersController;
import Cinema.Movie.MovieController;
import Cinema.Movie.MovieDaoImpl;
import Cinema.Movie.MovieServiceImpl;
import Cinema.Review.ReviewController;
import Cinema.Review.ReviewDaoImpl;
import Cinema.Review.ReviewServiceImpl;

public class ReviewMenu {
	private ReviewController rCont;
	private MovieController movCont;

	public ReviewMenu() {
		rCont = new ReviewController(new ReviewServiceImpl(new ReviewDaoImpl()));
		movCont = new MovieController(new MovieServiceImpl(new MovieDaoImpl()));
	}
	

	public void run(Scanner sc) {
		String str = "1.리뷰 작성 2.리뷰 수정 3.리뷰 삭제 4.리뷰 검색 5.영화명으로 검색 6.평점으로 검색 7.평균 평점 검색 8.전체 검색 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				if(!MembersController.getLoginId().equals("")) {
					movCont.getAll();
				}
				rCont.write(sc);
				break;
			case 2:
				rCont.rewrite(sc);
				break;
			case 3:
				rCont.delete(sc);
				break;
			case 4:
				rCont.search(sc);
				break;
			case 5:
				rCont.searchByName(sc);
				break;
			case 6:
				rCont.searchByScore(sc);
				break;
			case 7:
				rCont.searchAVG();
				break;
			case 8:
				rCont.searchAll();
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
