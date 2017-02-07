package store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import store.CustomerStore;
import store.util.ConnectionFactory;
import store.util.JdbcUtils;

public class CustomerStoreLogic implements CustomerStore {
	ConnectionFactory factory;

	public CustomerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public boolean selectId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, passwd, age, name, address from customer_tb where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return true;
	}

	@Override
	public boolean insert(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("insert into customer_tb values(?,?,?,?,?)");
			pstmt.setString(1, customer.getId());
			pstmt.setString(2, customer.getPasswd());
			pstmt.setString(3, customer.getName());
			pstmt.setInt(4, customer.getAge());
			pstmt.setString(5, customer.getAddress());

			if (pstmt.executeUpdate() == 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return false;
	}

	@Override
	public List<Customer> selectAllByName() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, passwd, name, age, address from customer_tb order by name asc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer cus = new Customer(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getInt("age"), rs.getString("address"));
				list.add(cus);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public List<Customer> selectAllByAge() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, passwd, name, age, address from customer_tb order by age desc");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer cus = new Customer(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getInt("age"), rs.getString("address"));
				list.add(cus);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Customer> selectByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, passwd, name, age, address from customer_tb where name Like ?");
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer cus = new Customer(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getInt("age"), rs.getString("address"));
				list.add(cus);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public List<Customer> selecthByAddress(String address) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Customer> list = null;

		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn
					.prepareStatement("select id, passwd, name, age, address from customer_tb where address Like ?");
			pstmt.setString(1, "%" + address + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer cus = new Customer(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getInt("age"), rs.getString("address"));
				list.add(cus);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public Customer selecthById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer cus = null;

		try {

			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select id, passwd, name, age, address from customer_tb where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cus = new Customer(rs.getString("id"), rs.getString("passwd"), rs.getString("name"), rs.getInt("age"),
						rs.getString("address"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return cus;
	}

	@Override
	public boolean delete(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		System.out.println(customer.toString());
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("delete from customer_tb where id = ?");
			
			pstmt.setString(1, customer.getId());
			
			deleteCount = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.closeResource(conn, pstmt);
		}
		
		return deleteCount > 0 ? true : false;
	}

	@Override
	public boolean update(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println(customer.toString());
		try {
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("update customer_tb set address = ? where id = ?");
			
			pstmt.setString(1, customer.getAddress());
			pstmt.setString(2, customer.getId());
			
			
		    pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JdbcUtils.closeResource(conn, pstmt);
		}
		return false;
	}

}
