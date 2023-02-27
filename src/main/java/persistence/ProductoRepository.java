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
	
	
	public List<Producto> getByCategoria(int idCategoria){
		return productoCrudRepository.findByIdCategoria(idCategoria);
	}
	
	public Optional<List<Producto>> getEscasos(int cantidad){
		return productoCrudRepository.findByCantidadStockLessThanAndEstadoProducto(cantidad, "");
	}
	
	public List<Producto> getProductoPorCodigo (String codigoBarras){
		return productoCrudRepository.findByCodigoBarras(codigoBarras);
	}
	
	public Optional<Producto> getProducto (int id){
		return productoCrudRepository.findById(id);
	}
	
	public Producto saveProducto(Producto producto) {
		return productoCrudRepository.save(producto);
	}
	
	public void deleteProducto(int id) {
		productoCrudRepository.deleteById(id);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Producto> producto = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(producto);
	}

	@Override
	public Optional<List<Producto>> getByCategory(int categoryId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<List<Producto>> getScarseProduct(int quantity) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<List<Product>> getProduct(int productId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Product save(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
		
	}


}
