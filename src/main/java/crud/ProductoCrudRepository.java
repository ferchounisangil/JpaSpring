package crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

	//@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
	List<Producto> findByIdCategoria(int idCategoria);
	
	Optional<List<Producto>> findByCantidadStockLessThanAndEstadoProducto(int cantidadStock,String estadoProducto);
	
	List<Producto> findByCodigoBarras(String codigoBarras );
}


