package vistas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import vistas.PanelPad.OnBotonPulsado;

public class DialogAnyadirProductos extends JOptionPane implements OnBotonPulsado {
	
	// Variables
	private JPanel panelContenedorGlobal;
	private JPanel panelContenedorIzquierdo;
	private JPanel panelContenedorDerecho;
	private JTabbedPane tabbedPaneSuperior;
	private JScrollPane scrollPaneInferior;
	private JPanel panelCantidad;
	private JScrollPane panelComida;
	private JScrollPane panelBebida;
	private JScrollPane panelPostre;
	private JLabel etiquetaCantidad;
	private JTextField textFieldCantidad;
	
	// Cosntructor
	public DialogAnyadirProductos(int idBotonMesa){
		iniciarPaneles(idBotonMesa);
	}
	
	private void iniciarPaneles(int idBotonMesa){
		
		// Instanciamos los paneles contenidos dentro del tabbedpane
		panelComida = new JScrollPane();
		panelBebida = new JScrollPane();
		panelPostre = new JScrollPane();
		
		// Instanciamos el tabbedPane y metemos los paneles anteriores
		tabbedPaneSuperior = new JTabbedPane();
		tabbedPaneSuperior.addTab("Comida", panelComida);
		tabbedPaneSuperior.addTab("Bebida", panelBebida);
		tabbedPaneSuperior.addTab("Postre", panelPostre);
		tabbedPaneSuperior.setPreferredSize(new Dimension(600,200));
		
		// Instanciamos el scrollPane
		scrollPaneInferior = new JScrollPane();
		scrollPaneInferior.setPreferredSize(new Dimension(600,200));
		
		// Instanciamos el panel contenedor izquierdo y añadimos los 2 paneles anteriores
		panelContenedorIzquierdo = new JPanel();
		panelContenedorIzquierdo.setLayout(new BoxLayout(panelContenedorIzquierdo, BoxLayout.Y_AXIS));
		panelContenedorIzquierdo.add(tabbedPaneSuperior);
		panelContenedorIzquierdo.add(scrollPaneInferior);
		
		// Instanciamos el panel del pad numérico
		PanelPad panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciamos el panel para especificar la cantidad de productos introducidos
		panelCantidad = new JPanel();
		etiquetaCantidad = new JLabel("Cantidad: ");
		textFieldCantidad = new JTextField(10);
		panelCantidad.add(etiquetaCantidad);
		panelCantidad.add(textFieldCantidad);
		
		// Instanciamos el panel contenedor derecho y añadimos los 2 paneles anteriores
		panelContenedorDerecho = new JPanel();
		panelContenedorDerecho.setLayout(new BoxLayout(panelContenedorDerecho, BoxLayout.Y_AXIS));
		panelContenedorDerecho.add(panelPad);
		panelContenedorDerecho.add(panelCantidad);
		
		// Añadimos los dos paneles contenedores anteriores al panel contenedor global
		panelContenedorGlobal = new JPanel();
		panelContenedorGlobal.setLayout(new BoxLayout(panelContenedorGlobal, BoxLayout.X_AXIS));
		panelContenedorGlobal.add(panelContenedorIzquierdo);
		panelContenedorGlobal.add(panelContenedorDerecho);
		
		// Mostral panel mediante un Dialog
		showConfirmDialog(this, panelContenedorGlobal, "Introduce productos para la mesa " + idBotonMesa, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		textFieldCantidad.setText(buffer);
	}
	
}
