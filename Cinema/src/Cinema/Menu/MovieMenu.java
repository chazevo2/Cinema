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
		String str = "1.��ȭ �߰� 2.��ȭ �˻� 3.�̸����� �˻� 4.�ٰŸ��� �˻� \n5.�帣�� �˻� 6.��ȭ ���� 7.��ȭ �ٰŸ� ���� 8.��ü �˻� 9.����";
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
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}

	public void runMember(Scanner sc) {
		String str = "1.��ȭ �˻� 2.�̸����� �˻� 3.�ٰŸ��� �˻� 4.�帣�� �˻� 5.��ü �˻� 9.����";
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
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}
