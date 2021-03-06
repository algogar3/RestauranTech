package models;
// Generated 15-feb-2017 4:57:18 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado implements java.io.Serializable {

	private Integer idEmpleado;
	private String nombre;
	private String apellidos;
	private int passwordEmpleado;
	private Integer telefono;
	private String dni;
	private boolean permisos;
	private Set servicios = new HashSet(0);

	public Empleado() {
	}

	public Empleado(String nombre, String apellidos, int passwordEmpleado, String dni, boolean permisos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.passwordEmpleado = passwordEmpleado;
		this.dni = dni;
		this.permisos = permisos;
	}

	public Empleado(String nombre, String apellidos, int passwordEmpleado, Integer telefono, String dni,
			boolean permisos, Set servicios) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.passwordEmpleado = passwordEmpleado;
		this.telefono = telefono;
		this.dni = dni;
		this.permisos = permisos;
		this.servicios = servicios;
	}

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getPasswordEmpleado() {
		return this.passwordEmpleado;
	}

	public void setPasswordEmpleado(int passwordEmpleado) {
		this.passwordEmpleado = passwordEmpleado;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isPermisos() {
		return this.permisos;
	}

	public void setPermisos(boolean permisos) {
		this.permisos = permisos;
	}

	public Set getServicios() {
		return this.servicios;
	}

	public void setServicios(Set servicios) {
		this.servicios = servicios;
	}

}
