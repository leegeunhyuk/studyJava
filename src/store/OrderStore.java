package store;

import java.util.List;

import domain.Order;

public interface OrderStore {
	
//	전체 주문 조회
	public List<Order> selectAll();
	
//  사용자별 주문 조회
	public List<Order> selectOrderById(String id);
	
//	년도별 주문 조회
	public List<Order> selectOrderByDate(String year);
	
//	기간별 주문 조회
	public List<Order> selectOrderByDate(String startYear, String endYear);

}
