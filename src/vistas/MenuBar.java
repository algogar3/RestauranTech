package vistas;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import models.Empleado;

public class MenuBar extends JMenuBar implements ActionListener{
	// Variables
	private JMenuItem itemSalir;
	private JMenuItem itemGerencia;
	private JMenuItem itemInformacion;
	private Empleado empleado;
	
	// Constructor
	public MenuBar(){
		iniciarMenu();
	}
	
	public void iniciarMenu(){
		// Elementos del menu
		JMenu menuArchivo = new JMenu("Archivo");
		JMenu menuAyuda = new JMenu("Ayuda");
		
		// Items de archivo
		itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(this);
		itemGerencia = new JMenuItem("Gerencia");
		itemGerencia.addActionListener(this);
		
		// Items de ayuda
		itemInformacion = new JMenuItem("Informaci�n");
		itemInformacion.addActionListener(this);
		
		// Se a�aden los items a los elementos del men�
		menuArchivo.add(itemGerencia);
		menuArchivo.addSeparator();
		menuArchivo.add(itemSalir);
		menuAyuda.add(itemInformacion);
		
		// Se a�aden los elementos del men� al menubar
		add(menuArchivo);
		add(menuAyuda);
	}

	// Implementaci�n de los m�todos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == itemSalir){
			System.exit(0);
		}
		else if(e.getSource() == itemGerencia){
			// Se pide al usuario que haga login
			DialogLogin dialogLogin = new DialogLogin();
			empleado = dialogLogin.getEmpleado();
			
			// Comprobaci�n de login correcto
			if(empleado != null){
				// Login correcto. Se comprueban los permisos del empleado
				if(empleado.isPermisos()){
					// El empleado tiene permisos de gerente. Se muestra el men� con las
					// opciones para gerencia
					new DialogGerencia();
				}
				else{
					// Login correcto pero el usuario no tiene permisos
					// Se muestra el di�logo falta de permisos
					new DialogPermisos();
				}
			}
			else{
				// Login incorrecto. Se muestra un di�logo con un mensaje de error
				new DialogLoginIncorrecto();
			}
		}
	}
}
