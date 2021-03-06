package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import models.Empleado;

public class BotonMesa extends JButton implements ActionListener{
	
	// Variables
	private int idBotonMesa;
	private Empleado empleado;

	// Constructor
	public BotonMesa(){
		iniciarBotonMesa();
	}
	
	// Setters y Getters
	public int getIdBotonMesa() {
		return idBotonMesa;
	}

	public void setIdBotonMesa(int idBotonMesa) {
		this.idBotonMesa = idBotonMesa;
	}
	
	// M�todo iniciarBoton
	public void iniciarBotonMesa(){
		setIcon(new ImageIcon("img/mesaPrueba1.png"));
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);
		
		// Escuchadores
		addActionListener(this);
	}

	// Desarrollo de los m�todos de la interfaz ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {		
		// Se recupera el empleado que ha hecho login
		DialogLogin dialogLogin = new DialogLogin();
		empleado = dialogLogin.getEmpleado();
		
		// Comprobaci�n de login correcto
		if(empleado != null){
			// Login correcto. Se lanza el di�logo con las opciones de la mesa
			// Se captura el objeto (BotonMesa) que di� lugar al evento
			BotonMesa boton = (BotonMesa) e.getSource();
			// Se recoge el id de la mesa, que viene dada como atriburo del objeto BotonMesa
			int idBotonMesa = boton.getIdBotonMesa();
			// Se muestra un men� con las posibles opciones
			new DialogOpcionMesa(idBotonMesa, empleado);
		}
		else{
			// Login incorrecto. Se muestra un di�logo con un mensaje de error
			new DialogLoginIncorrecto();
		}
		
	}
}
