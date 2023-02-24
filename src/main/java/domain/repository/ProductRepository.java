package domain.repository;

import java.util.List;
import java.util.Optional;

import domain.Product;
import entity.Producto;

public interface ProductRepository {

	List<Product> getAll();
	Optional<List<Producto>> getByCategory(int categoryId);
	Optional<List<Producto>> getScarseProduct(int quantity);
	Optional<List<Product>> getProduct(int productId);
	Product save(int productId);
	void delete(int productId);
	
}
