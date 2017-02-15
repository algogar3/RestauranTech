package models;
// Generated 15-feb-2017 4:57:18 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Servicio generated by hbm2java
 */
public class Servicio implements java.io.Serializable {

	private Integer idServicio;
	private Empleado empleado;
	private Mesa mesa;
	private int comensales;
	private BigDecimal gasto;
	private Date fecha;
	private boolean servicioActivo;
	private Set comandas = new HashSet(0);

	public Servicio() {
	}

	public Servicio(Empleado empleado, Mesa mesa, int comensales, BigDecimal gasto, Date fecha,
			boolean servicioActivo) {
		this.empleado = empleado;
		this.mesa = mesa;
		this.comensales = comensales;
		this.gasto = gasto;
		this.fecha = fecha;
		this.servicioActivo = servicioActivo;
	}

	public Servicio(Empleado empleado, Mesa mesa, int comensales, BigDecimal gasto, Date fecha, boolean servicioActivo,
			Set comandas) {
		this.empleado = empleado;
		this.mesa = mesa;
		this.comensales = comensales;
		this.gasto = gasto;
		this.fecha = fecha;
		this.servicioActivo = servicioActivo;
		this.comandas = comandas;
	}

	public Integer getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Mesa getMesa() {
		return this.mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getComensales() {
		return this.comensales;
	}

	public void setComensales(int comensales) {
		this.comensales = comensales;
	}

	public BigDecimal getGasto() {
		return this.gasto;
	}

	public void setGasto(BigDecimal gasto) {
		this.gasto = gasto;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isServicioActivo() {
		return this.servicioActivo;
	}

	public void setServicioActivo(boolean servicioActivo) {
		this.servicioActivo = servicioActivo;
	}

	public Set getComandas() {
		return this.comandas;
	}

	public void setComandas(Set comandas) {
		this.comandas = comandas;
	}

}
