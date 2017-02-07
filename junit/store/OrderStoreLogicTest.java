package store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Order;
import store.impl.OrderStoreLogic;

public class OrderStoreLogicTest {

	@Test
	public void testSearchAll() {
		OrderStoreLogic test = new OrderStoreLogic();
		List<Order> list = test.selectAll();
		assertEquals(6, list.size());
	}

	@Test
	public void testSearchByDateString() {
		OrderStoreLogic test = new OrderStoreLogic();
		String year = "2016";
		List<Order> list = test.selectOrderByDate(year);
		assertEquals(2, list.size());
	}

	@Test
	public void testSearchByDateStringString() {
		OrderStoreLogic test = new OrderStoreLogic();
		String startYear = "2016";
		String endYear = "2016";
		List<Order> list = test.selectOrderByDate(startYear, endYear);
		assertEquals(2, list.size());
	}

}
