package entity;

import org.springframework.format.number.money.MonetaryAmountFormatter;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras_productos")
public class CompraProducto {

	@EmbeddedId
	private CompraProductoPK id;
	
	private Integer cantidad;
	private Double total;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_compras", insertable = false, updatable = false)
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name = "id_productos", insertable = false, updatable = false)
	private Producto producto;
	
	// Getters and Setters
	
	
	
	public Integer getCantidad() {
		return cantidad;
	}
	public CompraProductoPK getId() {
		return id;
	}
	public void setId(CompraProductoPK id) {
		this.id = id;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
