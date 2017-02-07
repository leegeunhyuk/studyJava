package service;

import java.util.List;

import domain.Customer;

public interface CustomerService {
	
//	ID Ȯ��
	public boolean checkId(String id);
	
//	ȸ�� ���
	public boolean register(Customer customer);
	
//	�̸� �� ���
	public List<Customer> printAllByName();
	
//	���� �� ���
	public List<Customer> printAllByAge();
	
//	�̸� �˻�
	public List<Customer> searchByName(String name);

//	���� �˻�
	public List<Customer> serarchByAddress(String address);
	
//	ID �˻�
	public Customer searchById(String id);
	
//	����
	public boolean deleteCustomer(Customer customer);
	
//	����
	public boolean modifyCustomer(Customer customer);
}
