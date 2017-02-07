package ui;

import java.util.List;
import java.util.Scanner;

import domain.Customer;
import service.CustomerService;
import service.impl.CustomerServiceLogic;

public class CustomerUI {

	private Scanner keyIn;
	private CustomerService service;

	public CustomerUI() {
		keyIn = new Scanner(System.in);
		service = new CustomerServiceLogic();

	}

	public void menuPrint() {
		int select;

		while (true) {
			System.out.println("1.ȸ�� ����");
			System.out.println("2.ȸ�� ����");
			System.out.println("3.ȸ�� �˻�");
			System.out.println("4.ȸ�� ����");
			System.out.println("5.ȸ�� ���");
			System.out.println("6.����");
			System.out.print("#�޴� : ");
			select = keyIn.nextInt();

			switch (select) {
			case 1:
				registerMenu();
				break;
			case 2:
				modifyMenu();
				break;
			case 3:
				searchMenu();
				break;
			case 4:
				deleteMenu();
				break;
			case 5:
				printAll();
				break;
			case 6:
				return;
			}
		}
	}

	private void registerMenu() {
		String id;

		System.out.println("-----ȸ�� ���-----");
		System.out.print("#ID : ");
		id = keyIn.next();

		// ID �ߺ� üũ
		if (service.checkId(id)) {
			System.out.println("*��� ���� ID �Դϴ�.");

			Customer customer = new Customer();
			customer.setId(id);

			System.out.print("#�̸� : ");
			customer.setName(keyIn.next());

			System.out.print("#PW : ");
			customer.setPasswd(keyIn.next());

			System.out.print("#���� : ");
			customer.setAge(keyIn.nextInt());

			System.out.print("#�ּ� : ");
			customer.setAddress(keyIn.next());

			// �� ���
			if (service.register(customer)) {
				System.out.println("-----�� ��� �Ϸ�-----");
			} else {
				System.out.println("-----��� ����-----");
			}
		} else {
			System.out.println("*��� �Ұ� ID");
		}
	}

	private void searchMenu() {
		int select;

		List<Customer> list = null;
		Customer customer = null;

		System.out.println("------�˻� �޴�-----");
		System.out.println("1.�̸� �˻�");
		System.out.println("2.���� �˻�");
		System.out.println("3.ID �˻�");
		System.out.print("#�޴� : ");
		select = keyIn.nextInt();

		if (select == 1) {
			System.out.print("#�̸� : ");
			list = service.searchByName(keyIn.next());
		} else if (select == 2) {
			System.out.print("#���� : ");
			list = service.serarchByAddress(keyIn.next());
		} else {
			System.out.print("#ID : ");
			customer = service.searchById(keyIn.next());
		}

		// ��� ���
		if (list != null) {
			for (Customer cus : list) {
				System.out.println(cus.toString());
			}
		} else {
			System.out.println(customer.toString());
		}
	}

	private void deleteMenu() {
		Customer customer = null;

		System.out.println("------���� �޴�-----");
		System.out.print("#ID : ");

		// �˻�
		customer = service.searchById(keyIn.next());
		// ����
		if (customer != null) {
			System.out.print(customer.getName() + "- ���� ���� �Ͻðڽ��ϱ�? (y/n) : ");
			if (keyIn.next().toLowerCase().equals("y")) {
				if (service.deleteCustomer(customer)) {
					System.out.println("���� �Ǿ����ϴ�.");
				}
			}
		}else{
			System.out.println("-- �ش� ���� �������� �ʽ��ϴ� --");
		}

	}

	private void modifyMenu() {
		Customer customer = null;
		System.out.println("------���� �޴�-----");

		System.out.print("#ID : ");

		// �˻�
		customer = service.searchById(keyIn.next());
		// ����
		if (customer != null) {
			System.out.println(customer.getName() + "- ���� �ּҸ� ���� �մϴ�.");
			System.out.print("#�ּ� : ");
			customer.setAddress(keyIn.next());
			if (service.modifyCustomer(customer)) {
				System.out.println("���� �Ǿ����ϴ�.");
			}
		} else {
			System.out.println("-- �ش� ���� �������� �ʽ��ϴ� --");
		}

	}

	private void printAll() {
		int select;
		System.out.println("------��� �޴�-----");
		System.out.println("1.�̸� �� ���");
		System.out.println("2.���� �� ���");
		System.out.print("#�޴� : ");
		select = keyIn.nextInt();

		List<Customer> list;
		if (select == 1) {
			list = service.printAllByName();
		} else {
			list = service.printAllByAge();
		}

		for (Customer customer : list) {
			System.out.println(customer.toString());
		}
	}
}
