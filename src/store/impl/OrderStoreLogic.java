package store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Order;
import domain.Product;
import store.OrderStore;
import store.util.ConnectionFactory;
import store.util.JdbcUtils;

public class OrderStoreLogic implements OrderStore {
	private ConnectionFactory factory;

	public OrderStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Order> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> list = null;
		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, productid, orderdate, quantity from order_tb");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Order o = new Order(rs.getString("id"), rs.getString("productid"), rs.getDate("orderdate"),
						rs.getInt("quantity"));
				list.add(o);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public List<Order> selectOrderByDate(String year) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"select id, productid, orderdate, quantity from order_tb where extract(year from orderdate) = ?");
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Order o = new Order(rs.getString("id"), rs.getString("productid"), rs.getDate("orderdate"),
						rs.getInt("quantity"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Order> selectOrderByDate(String startYear, String endYear) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement(
					"select id, productid, orderdate, quantity from order_tb where orderdate between to_date(?, 'yyyy/mm/dd') and to_date(?,'yyyy/mm/dd')");
			pstmt.setString(1, startYear+"0101");
			pstmt.setString(2, endYear+"1231");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Order o = new Order(rs.getString("id"), rs.getString("productid"), rs.getDate("orderdate"),
						rs.getInt("quantity"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Order> selectOrderById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Order> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, productid, orderdate, quantity from order_tb where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Order o = new Order(rs.getString("id"), rs.getString("productid"), rs.getDate("orderdate"),
						rs.getInt("quantity"));
				list.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
