package vista;

import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener{
	// Variables
	private JMenuItem itemSalir;
	private JMenuItem itemInformacion;
	
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
		
		// Items de ayuda
		itemInformacion = new JMenuItem("Informaci�n");
		itemInformacion.addActionListener(this);
		
		// Se a�aden los items a los elementos del men�
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
		
	}
}
