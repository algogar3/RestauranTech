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
		itemInformacion = new JMenuItem("Información");
		itemInformacion.addActionListener(this);
		
		// Se añaden los items a los elementos del menú
		menuArchivo.add(itemGerencia);
		menuArchivo.addSeparator();
		menuArchivo.add(itemSalir);
		menuAyuda.add(itemInformacion);
		
		// Se añaden los elementos del menú al menubar
		add(menuArchivo);
		add(menuAyuda);
	}

	// Implementación de los métodos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == itemSalir){
			System.exit(0);
		}
		else if(e.getSource() == itemGerencia){
			// Se pide al usuario que haga login
			DialogLogin dialogLogin = new DialogLogin();
			empleado = dialogLogin.getEmpleado();
			
			// Comprobación de login correcto
			if(empleado != null){
				// Login correcto. Se comprueban los permisos del empleado
				if(empleado.isPermisos()){
					// El empleado tiene permisos de gerente. Se muestra el menú con las
					// opciones para gerencia
					new DialogGerencia();
				}
				else{
					// Login correcto pero el usuario no tiene permisos
					// Se muestra el diálogo falta de permisos
					new DialogPermisos();
				}
			}
			else{
				// Login incorrecto. Se muestra un diálogo con un mensaje de error
				new DialogLoginIncorrecto();
			}
		}
	}
}
