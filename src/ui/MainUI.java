package ui;

import java.util.Scanner;

public class MainUI {
	private CustomerUI cui;
	private ProductUI pui;
	private OrderUI oui;

	private Scanner keyIn;

	public MainUI() {
		cui = new CustomerUI();
		pui = new ProductUI();
		oui = new OrderUI();

		keyIn = new Scanner(System.in);
	}

	public void mainPrint() {
		int select;
		while (true) {
			System.out.println("=======Shop Manager=======");
			System.out.println("1. 雀盔 包府");
			System.out.println("2. 惑前 包府");
			System.out.println("3. 林巩 包府");
			System.out.println("4. 辆丰");
			System.out.print("#皋春 : ");
			select = keyIn.nextInt();

			switch (select) {
			case 1:
				cui.menuPrint();
				break;
			case 2:
				pui.menuPrint();
				break;
			case 3:
				oui.menuPrint();
				break;
			case 4:
				return;
			}
		}
	}

	public static void main(String[] args) {
		new MainUI().mainPrint();
		System.out.println("ぞし");
	}

}
