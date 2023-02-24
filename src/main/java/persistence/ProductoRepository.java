package persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import crud.ProductoCrudRepository;
import entity.Producto;


@Repository
public class ProductoRepository {
	
	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAll() {
		return (List<Producto>) productoCrudRepository.findAll();
		
	}
	
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

}
