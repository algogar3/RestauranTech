package models;
// Generated 08-feb-2017 18:06:27 by Hibernate Tools 4.3.1.Final

/**
 * Comanda generated by hbm2java
 */
public class Comanda implements java.io.Serializable {

	private Integer idComanda;
	private Producto producto;
	private Servicio servicio;
	private int cantidad;

	public Comanda() {
	}

	public Comanda(Producto producto, Servicio servicio, int cantidad) {
		this.producto = producto;
		this.servicio = servicio;
		this.cantidad = cantidad;
	}

	public Integer getIdComanda() {
		return this.idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
