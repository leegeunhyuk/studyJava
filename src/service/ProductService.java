package service;

import java.util.List;

import domain.Product;

public interface ProductService {
	
//	��ü ��ǰ �˻�
	public List<Product> searchAll();
	
//	��ǰ ������ �Ǹ� �� �˻�
	public List<String> searchCountByCategory();

}
