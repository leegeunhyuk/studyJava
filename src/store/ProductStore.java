package store;

import java.util.List;

import domain.Product;

public interface ProductStore {
	
//	��ü ��ǰ �˻�
	public List<Product> selectAll();
	
//	��ǰ ������ �Ǹ� �� �˻�
	public List<String> selectCountByCategory();

}
