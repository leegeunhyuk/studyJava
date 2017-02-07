package store;

import java.util.List;

import domain.Order;

public interface OrderStore {
	
//	��ü �ֹ� ��ȸ
	public List<Order> selectAll();
	
//  ����ں� �ֹ� ��ȸ
	public List<Order> selectOrderById(String id);
	
//	�⵵�� �ֹ� ��ȸ
	public List<Order> selectOrderByDate(String year);
	
//	�Ⱓ�� �ֹ� ��ȸ
	public List<Order> selectOrderByDate(String startYear, String endYear);

}
