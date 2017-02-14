package vistas;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import controllers.ControladorTablaProductos;
import vistas.PanelPad.OnBotonPulsado;

public class DialogAnyadirProductos extends JOptionPane implements OnBotonPulsado {
	
	// Constantes
	private final String KEY_COMIDA = "comida";
	private final String KEY_BEBIDA = "bebida";
	private final String KEY_POSTRE = "postre";
	
	// Variables
	private JPanel panelContenedorGlobal;
	private JPanel panelContenedorIzquierdo;
	private JPanel panelContenedorDerecho;
	private JTabbedPane tabbedPaneSuperior;
	private JScrollPane scrollPaneInferior;
	private JPanel panelCantidad;
	private JButton botonAnyadirProducto;
	private JScrollPane panelComida;
	private JScrollPane panelBebida;
	private JScrollPane panelPostre;
	private JLabel etiquetaCantidad;
	private JTextField textFieldCantidad;
	private ControladorTablaProductos modeloComida;
	private ControladorTablaProductos modeloBebida;
	private ControladorTablaProductos modeloPostre;
	private TablaProductos tablaComida;
	private TablaProductos tablaBebida;
	private TablaProductos tablaPostre;
	
	// Cosntructor
	public DialogAnyadirProductos(int idBotonMesa){
		iniciarPaneles(idBotonMesa);
	}
	
	private void iniciarPaneles(int idBotonMesa){
		
		// Instanciamos los paneles contenidos dentro del tabbedpane
		panelComida = new JScrollPane();
		panelBebida = new JScrollPane();
		panelPostre = new JScrollPane();
		
		modeloComida = new ControladorTablaProductos(FramePrincipal.session, KEY_COMIDA);
		modeloBebida = new ControladorTablaProductos(FramePrincipal.session, KEY_BEBIDA);
		modeloPostre = new ControladorTablaProductos(FramePrincipal.session, KEY_POSTRE);
		
		tablaComida = new TablaProductos(modeloComida);
		tablaBebida = new TablaProductos(modeloBebida);
		tablaPostre = new TablaProductos(modeloPostre);
		
		// Paneles
		JPanel panelTabla = new JPanel();
		
		// Para que se vean los titulos de las columnas
		JScrollPane scroll = new JScrollPane(tablaComida);
		panelTabla.add(scroll);
		
		panelComida.add(panelTabla);
		panelBebida.add(tablaBebida);
		panelPostre.add(tablaPostre);
		
		// Instanciamos el tabbedPane y metemos los paneles anteriores
		tabbedPaneSuperior = new JTabbedPane();
		tabbedPaneSuperior.addTab("Comida", panelComida);
		tabbedPaneSuperior.addTab("Bebida", panelBebida);
		tabbedPaneSuperior.addTab("Postre", panelPostre);
		tabbedPaneSuperior.setPreferredSize(new Dimension(600,200));
		
		// Instanciamos el scrollPane
		scrollPaneInferior = new JScrollPane();
		scrollPaneInferior.setPreferredSize(new Dimension(600,200));
		
		// Instanciamos el panel contenedor izquierdo y a�adimos los 2 paneles anteriores
		panelContenedorIzquierdo = new JPanel();
		panelContenedorIzquierdo.setLayout(new BoxLayout(panelContenedorIzquierdo, BoxLayout.Y_AXIS));
		panelContenedorIzquierdo.add(tabbedPaneSuperior);
		panelContenedorIzquierdo.add(scrollPaneInferior);
		
		// Instanciamos el panel del pad num�rico
		PanelPad panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciamos el panel para especificar la cantidad de productos introducidos
		panelCantidad = new JPanel();
		etiquetaCantidad = new JLabel("Cantidad: ");
		textFieldCantidad = new JTextField(10);
		botonAnyadirProducto = new JButton("A�adir producto");
		panelCantidad.add(etiquetaCantidad);
		panelCantidad.add(textFieldCantidad);
		panelCantidad.add(botonAnyadirProducto);
		
		// Instanciamos el panel contenedor derecho y a�adimos los 2 paneles anteriores
		panelContenedorDerecho = new JPanel();
		panelContenedorDerecho.setLayout(new BoxLayout(panelContenedorDerecho, BoxLayout.Y_AXIS));
		panelContenedorDerecho.add(panelPad);
		panelContenedorDerecho.add(panelCantidad);
		
		// A�adimos los dos paneles contenedores anteriores al panel contenedor global
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
