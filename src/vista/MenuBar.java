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
		itemInformacion = new JMenuItem("Información");
		itemInformacion.addActionListener(this);
		
		// Se añaden los items a los elementos del menú
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
		
	}
}
