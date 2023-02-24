package entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorias")
	private Integer idCategoria;
	
	@Column(name = "descripcion_categorias")
	private String descripcionCategoria;
	
	@Column(name = "estado_categorias")
	private String estadoCategoria;
	
	@OneToMany(mappedBy = "categoria")
	private List<Producto> productos;

	// Getters and Setters
	
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	public String getEstadoCategoria() {
		return estadoCategoria;
	}

	public void setEstadoCategoria(String estadoCategoria) {
		this.estadoCategoria = estadoCategoria;
	}
	
	
}
