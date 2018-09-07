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
		String str = "1.���� �ۼ� 2.���� ���� 3.���� ���� 4.���� �˻� 5.��ȭ������ �˻� 6.�������� �˻� 7.��� ���� �˻� 8.��ü �˻� 9.����";
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
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

}
