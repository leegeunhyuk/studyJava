package ui;

import java.util.List;
import java.util.Scanner;

import domain.Order;
import service.OrderService;
import service.impl.OrderServiceLogic;

public class OrderUI {
	private Scanner keyIn;
	private OrderService service;

	public OrderUI() {
		keyIn = new Scanner(System.in);

		service = new OrderServiceLogic();
	}

	public void menuPrint() {
		int select;
		while (true) {
			System.out.println("------��ǰ �޴�-------");
			System.out.println("1. ��ü �ֹ� ���� ��ȸ");
			System.out.println("2. ����ں� �ֹ� ��ȸ");
			System.out.println("3. �ð� �ֹ� ��ȸ");
			System.out.println("4. ��������...");
			System.out.print("#�޴� : ");

			select = keyIn.nextInt();
			switch (select) {
			case 1:
				printAll();
				break;
			case 2:
				printOrderByUser();
				break;
			case 3:
				printOrderByDate();
				break;
			case 4:
				return;
			}
		}
	}

	private void printAll() {
		List<Order> list;

		list = service.searchAll();

		System.out.println("------��ü �ֹ� ����-------");
		for (Order o : list) {
			System.out.println(o.toString());
		}
	}

	private void printOrderByUser() {
		List<Order> list;
		System.out.print("ID: ");
		list = service.searchById(keyIn.next());
		System.out.println("------����� ���-------");
		for(Order o : list){
			System.out.println(o.toString());
		}
	}
	
	private void printOrderByDate(){
		List<Order> list = null;

		int select;
		String year;
		String sYear, eYear;

		System.out.println("------�⵵�� �ֹ� ����-------");
		System.out.println("1.�⵵��");
		System.out.println("2.�Ⱓ��");
		System.out.print("#�޴� : ");
		select = keyIn.nextInt();
		
		switch(select){
		case 1:
			System.out.print("�⵵ : ");
			year = keyIn.next();
			list = service.searchByDate(year);
			break;
		case 2:
			System.out.print("���� �⵵ : ");
			sYear = keyIn.next();
			System.out.print("���� �⵵ : ");
			eYear = keyIn.next();
			list = service.searchByDate(sYear, eYear);
			break;
			
		}
		
		for(Order o : list){
			System.out.println(o.toString());
		}
	}
}
