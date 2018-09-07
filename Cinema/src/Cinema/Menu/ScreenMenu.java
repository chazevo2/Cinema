package Cinema.Menu;


import java.util.Scanner;

import Cinema.Screen.ScreenController;
import Cinema.Screen.ScreenDaoImpl;
import Cinema.Screen.ScreenServiceImpl;

public class ScreenMenu {
	private ScreenController scrCont;
	public ScreenMenu() {
		scrCont = new ScreenController(new ScreenServiceImpl(new ScreenDaoImpl()));
	}
	
	public void runAdmin(Scanner sc) {
		String str = "1.스크린추가 2.스크린 수정(라인, 좌석)3.스크린 삭제 4.스크린 찾기 5.전체 검색 9.메인";
		int menu;
		while (true) {
			System.out.println(str);
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				scrCont.addScreen(sc);
				break;
			case 2:
				scrCont.editScreen(sc);
				break;
			case 3:
				scrCont.delScreen(sc);
				break;
			case 4:
				scrCont.search(sc);
				break;
			case 5:
				scrCont.searchAll();
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
