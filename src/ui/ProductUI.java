package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Product;
import service.ProductService;
import service.impl.ProductServiceLogic;

public class ProductUI {
	private Scanner keyIn;
	private ProductService service;

	public ProductUI() {
		keyIn = new Scanner(System.in);
		service = new ProductServiceLogic();
		
	}

	public void menuPrint() {
		int select;
		while (true) {
			System.out.println("------��ǰ �޴�-------");
			System.out.println("1. ��ü ��ǰ ��ȸ");
			System.out.println("2. ��ǰ������ �ֹ� ���� ��ȸ");
			System.out.println("3. ��������...");
			System.out.print("#�޴� : ");

			select = keyIn.nextInt();
			switch (select) {
			case 1:
				printAll();
				break;
			case 2:
				printCountByCategory();
				break;
			case 3:
				return;
			}
		}
	}

	private void printAll() {
		List<Product> list=null;
		list = service.searchAll();

		System.out.println("------��ü ��ǰ-------");
		for (Product pdt : list) {
			System.out.println(pdt);
		}
	}

	private void printCountByCategory() {
		List<String> list;

		list = service.searchCountByCategory();

		System.out.println("------��ǰ�� �Ǹ� ��-------");
		for (String data : list) {
			System.out.println(data);
		}
	}

}
