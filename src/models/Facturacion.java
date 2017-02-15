package models;
// Generated 15-feb-2017 4:57:18 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * Facturacion generated by hbm2java
 */
public class Facturacion implements java.io.Serializable {

	private Integer idFacturacion;
	private Date fecha;
	private int cantidadComensales;
	private BigDecimal cantidadFacturada;

	public Facturacion() {
	}

	public Facturacion(Date fecha, int cantidadComensales, BigDecimal cantidadFacturada) {
		this.fecha = fecha;
		this.cantidadComensales = cantidadComensales;
		this.cantidadFacturada = cantidadFacturada;
	}

	public Integer getIdFacturacion() {
		return this.idFacturacion;
	}

	public void setIdFacturacion(Integer idFacturacion) {
		this.idFacturacion = idFacturacion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidadComensales() {
		return this.cantidadComensales;
	}

	public void setCantidadComensales(int cantidadComensales) {
		this.cantidadComensales = cantidadComensales;
	}

	public BigDecimal getCantidadFacturada() {
		return this.cantidadFacturada;
	}

	public void setCantidadFacturada(BigDecimal cantidadFacturada) {
		this.cantidadFacturada = cantidadFacturada;
	}

}
