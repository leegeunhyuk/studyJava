package store.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Product;
import store.ProductStore;
import store.util.ConnectionFactory;
import store.util.JdbcUtils;

public class ProductStoreLogic implements ProductStore {
	private ConnectionFactory factory;

	public ProductStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}

	@Override
	public List<Product> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Product> list = null;
		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select productid, productname, category, information from product_tb");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getString("productid"), rs.getString("productname"),
						rs.getString("category"), rs.getString("information"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

	@Override
	public List<String> selectCountByCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = null;
		try {
			list = new ArrayList<>();
			conn = factory.createConnection();
			pstmt = conn.prepareStatement("select category, sum(quantity) from order_tb o, product_tb p where o.productid = p.productid group by category");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String str = rs.getString("category") + ": " + rs.getString("sum(quantity)");
				list.add(str);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn, pstmt, rs);
		}

		return list;
	}

}
