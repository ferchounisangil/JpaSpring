package entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compras")
	private Integer idCompra;

	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "fecha_compra")
	private LocalDateTime fechaCompra;

	@Column(name = "medio_pago_compra")
	private Character medioPagoCompra;

	@Column(name = "comentario_compra")
	private String comentarioCompra;

	@Column(name = "estado_compra")
	private Character estadoCompra;
	
	@ManyToOne 
	@JoinColumn(name = "id_clientes", insertable = false, updatable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "producto")
	private List<CompraProducto> productos;
	
	// Getters and Setters

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Character getMedioPagoCompra() {
		return medioPagoCompra;
	}

	public void setMedioPagoCompra(Character medioPagoCompra) {
		this.medioPagoCompra = medioPagoCompra;
	}

	public String getComentarioCompra() {
		return comentarioCompra;
	}

	public void setComentarioCompra(String comentarioCompra) {
		this.comentarioCompra = comentarioCompra;
	}

	public Character getEstadoCompra() {
		return estadoCompra;
	}

	public void setEstadoCompra(Character estadoCompra) {
		this.estadoCompra = estadoCompra;
	}

}
