package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import controllers.ControladorComanda;
import controllers.ControladorTablaProductos;
import vistas.PanelPad.OnBotonPulsado;

public class DialogAnyadirProductos extends JOptionPane implements OnBotonPulsado, MouseListener, ActionListener {
	
	// Constantes
	private final String KEY_COMIDA = "comida";
	private final String KEY_BEBIDA = "bebida";
	private final String KEY_POSTRE = "postre";
	
	// Variables
	private JPanel panelContenedorGlobal;
	private JPanel panelContenedorIzquierdo;
	private JPanel panelContenedorDerecho;
	private PanelPad panelPad;
	private JTabbedPane tabbedPaneSuperior;
	private JScrollPane scrollPaneInferior;
	private JPanel panelCantidad;
	private JButton botonAnyadirProducto;
	private JLabel etiquetaCantidad;
	private JTextField textFieldCantidad;
	private ControladorTablaProductos modeloComida;
	private ControladorTablaProductos modeloBebida;
	private ControladorTablaProductos modeloPostre;
	private JTable tablaComida;
	private JTable tablaBebida;
	private JTable tablaPostre;
	private int idMesa;
	private String nombreProducto;
	
	// Cosntructor
	public DialogAnyadirProductos(int idBotonMesa){
		iniciarPaneles(idBotonMesa);
	}
	
	// Método iniciarPaneles()
	private void iniciarPaneles(int idBotonMesa){
		
		// Se recupera el id de la mesa
		idMesa = idBotonMesa;
		
		// Se obtiene el modelo para cada tipo de producto
		modeloComida = new ControladorTablaProductos(FramePrincipal.session, KEY_COMIDA);
		modeloBebida = new ControladorTablaProductos(FramePrincipal.session, KEY_BEBIDA);
		modeloPostre = new ControladorTablaProductos(FramePrincipal.session, KEY_POSTRE);
		
		// Creación de tablas a partir de su modelo correspondiente
		tablaComida = new JTable(modeloComida);
		tablaBebida = new JTable(modeloBebida);
		tablaPostre = new JTable(modeloPostre);
		
		// Escuchadores
		tablaComida.addMouseListener(this);
		tablaBebida.addMouseListener(this);
		tablaPostre.addMouseListener(this);
		
		// Centrado de los valores en las columnas
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        // Tabla comida
        tablaComida.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaComida.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaComida.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaComida.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        // Tabla bebida
        tablaBebida.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaBebida.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaBebida.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaBebida.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
        // Tabla postre
        tablaPostre.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaPostre.getColumnModel().getColumn(1).setCellRenderer(modelocentrar);
        tablaPostre.getColumnModel().getColumn(2).setCellRenderer(modelocentrar);
        tablaPostre.getColumnModel().getColumn(3).setCellRenderer(modelocentrar);
		
		// No permitimos que nuestras columnas se muevan
		tablaComida.getTableHeader().setReorderingAllowed(false);
		tablaBebida.getTableHeader().setReorderingAllowed(false);
		tablaPostre.getTableHeader().setReorderingAllowed(false);
		
		// Paneles
		JPanel panelTablaComida = new JPanel();
		JPanel panelTablaBebida = new JPanel();
		JPanel panelTablaPostre = new JPanel();
		
		// Ponemos BorderLayout a nuestros paneles para que la tabla ocupe todo el espacio
		panelTablaComida.setLayout(new BorderLayout());
		panelTablaBebida.setLayout(new BorderLayout());
		panelTablaPostre.setLayout(new BorderLayout());
		
		// Para que se vean los titulos de las columnas, se introduce la tabla en un JScrollPane
		JScrollPane scrollComida = new JScrollPane(tablaComida);
		JScrollPane scrollBebida = new JScrollPane(tablaBebida);
		JScrollPane scrollPostre = new JScrollPane(tablaPostre);
		
		// Se introducen los JScrollPane dentro de los paneles creados anteriormente
		panelTablaComida.add(scrollComida);
		panelTablaBebida.add(scrollBebida);
		panelTablaPostre.add(scrollPostre);
		
		
		// Instanciamos el tabbedPane y metemos los paneles anteriores
		tabbedPaneSuperior = new JTabbedPane();
		tabbedPaneSuperior.addTab("Comida", panelTablaComida);
		tabbedPaneSuperior.addTab("Bebida", panelTablaBebida);
		tabbedPaneSuperior.addTab("Postre", panelTablaPostre);
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
		panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciamos el panel para especificar la cantidad de productos introducidos
		panelCantidad = new JPanel();
		etiquetaCantidad = new JLabel("Cantidad: ");
		textFieldCantidad = new JTextField(10);
		botonAnyadirProducto = new JButton("Añadir producto");
		botonAnyadirProducto.addActionListener(this);
		panelCantidad.add(etiquetaCantidad);
		panelCantidad.add(textFieldCantidad);
		panelCantidad.add(botonAnyadirProducto);
		
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

	// Desarrollo de los métodos de la interfaz MouseListener
	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		textFieldCantidad.setText(buffer);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// Se selecciona un producto de la tabla comida
		if(e.getSource() == tablaComida){
			int fila = tablaComida.rowAtPoint(e.getPoint());
			
			int filaSeleccionada = fila;
			nombreProducto = tablaComida.getValueAt(filaSeleccionada, 0).toString();
		}
		
		// Se selecciona un producto de la tabla bebida
		if(e.getSource() == tablaBebida){
			int fila = tablaBebida.rowAtPoint(e.getPoint());
			
			int filaSeleccionada = fila;
			nombreProducto = tablaBebida.getValueAt(filaSeleccionada, 0).toString();
		}
		
		// Se selecciona un producto de la tabla postre
		if(e.getSource() == tablaPostre){
			int fila = tablaPostre.rowAtPoint(e.getPoint());
			
			int filaSeleccionada = fila;
			nombreProducto = tablaPostre.getValueAt(filaSeleccionada, 0).toString();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	// Desarrollo de los métodos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// Se llama al controlador para que genere una nueva comanda
		ControladorComanda.crearComanda(FramePrincipal.session, idMesa, nombreProducto, 
				Integer.valueOf(textFieldCantidad.getText().toString()));
		
		// Se borra el contenido del JTextField de cantidad
		panelPad.botonBorrar.doClick();
	}
	
}
