package vista;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class DialogAnyadirProductos extends JOptionPane {
	
	// Variables
	private JPanel panelContenedor;
	private JTabbedPane tabbedPaneSuperior;
	private JScrollPane scrollPaneInferior;
	private JPanel panelComida;
	private JPanel panelBebida;
	private JPanel panelPostre;
	
	// Cosntructor
	public DialogAnyadirProductos(){
		iniciarPaneles();
	}
	
	private void iniciarPaneles(){
		// Instanciamos el tabbedPane y metemos los paneles
		tabbedPaneSuperior = new JTabbedPane();
		tabbedPaneSuperior.addTab("Comida", panelComida);
		tabbedPaneSuperior.addTab("Bebida", panelBebida);
		tabbedPaneSuperior.addTab("Postre", panelPostre);
		
		// Instanciamos el scrollPane
		scrollPaneInferior = new JScrollPane();
		
		// Instanciamos el panel contenedor y añadimos los 2 paneles
		panelContenedor = new JPanel();
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
		panelContenedor.add(tabbedPaneSuperior);
		panelContenedor.add(scrollPaneInferior);
	}
	
}
