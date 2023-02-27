package persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import crud.ProductoCrudRepository;
import domain.Product;
import domain.repository.ProductRepository;
import entity.Producto;
import persistence.mapper.ProductMapper;


@Repository
public class ProductoRepository implements ProductRepository{
	
	private ProductoCrudRepository productoCrudRepository;
	private ProductMapper mapper;
	
	public Optional<List<Producto>> getEscasos(int cantidad){
		return productoCrudRepository.findByCantidadStockLessThanAndEstadoProducto(cantidad, "");
	}
	
	public List<Producto> getProductoPorCodigo (String codigoBarras){
		return productoCrudRepository.findByCodigoBarras(codigoBarras);
	}
	

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Producto> producto = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(producto);
	}
		
	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		
		List<Producto> productos = productoCrudRepository.findByIdCategoria(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProduct(int quantity) {
		
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstadoProducto(quantity, null);
		return productos.map(prods -> mapper.toProducts(prods));
		
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return  productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
		
	}

	
	@Override
	public void delete(int productId) {
		
		productoCrudRepository.deleteById(productId);
		
	}

	@Override
	public Product save(Product product) {
		
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}

	


}
