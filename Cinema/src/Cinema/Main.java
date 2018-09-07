package Cinema;

import java.util.Scanner;

import Cinema.Menu.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		Menu m = new Menu();
		m.run(sc);
	}
}
