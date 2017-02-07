package service;

import java.util.List;

import domain.Order;

public interface OrderService {
	
//	��ü �ֹ� ��ȸ
	public List<Order> searchAll();
	
//	�� �� �ֹ� ��ȸ
	public List<Order> searchById(String id);
	
//	�⵵�� �ֹ� ��ȸ
	public List<Order> searchByDate(String year);
	
//	�Ⱓ �� �ֹ� ��ȸ
	public List<Order> searchByDate(String startYear, String endYear);
}
