package store;

import java.util.List;

import domain.Customer;

public interface CustomerStore {
//	ID �ߺ� Ȯ��
	public boolean selectId(String id);
	
//	�� ���
	public boolean insert(Customer customer);

//	�̸� �� ���
	public List<Customer> selectAllByName();
	
//	���� �� ���
	public List<Customer> selectAllByAge();
	
//	�̸� �˻�
	public List<Customer> selectByName(String name);

//	���� �˻�
	public List<Customer> selecthByAddress(String address);
	
//	ID �˻�
	public Customer selecthById(String id);
	
//	����
	public boolean delete(Customer customer);
	
//	����
	public boolean update(Customer customer);
	
	
}
