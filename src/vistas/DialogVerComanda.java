package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

import controllers.ControladorCobrosYFacturacion;
import controllers.ControladorServicioActivoMesa;
import controllers.ControladorTablaComandas;
import controllers.ControladorTablaProductos;
import controllers.EstadoMesa;
import vistas.PanelPad.OnBotonPulsado;

public class DialogVerComanda extends JOptionPane implements OnBotonPulsado, ActionListener{
	
	// Variables
	private JScrollPane panelVerComanda;
	private JPanel panelCobrar;
	private JPanel panelCantidadEntregada;
	private JPanel panelContenedorIquierdo;
	private PanelPad panelPad; 
	private JPanel panelContenedorGlobal;
	private JLabel importe;
	private JLabel textoCantidadEntregada;
	private JTextField cantidadEntregada;
	private JLabel cambio;
	private JButton botonCobrar;
	private int idMesa;
	private ControladorTablaComandas modeloComanda;
	private JTable tablaComanda;
	DecimalFormat df = new DecimalFormat("#.00");
	
	// Constructor
	public DialogVerComanda(int idBotonMesa){
		iniciarGUI(idBotonMesa);
	}
	
	// Método iniciarGUI
	private void iniciarGUI(int idBotonMesa){
		// Se recoge el valor de la variable idMesa
		idMesa = idBotonMesa;
		
		/************* INICIO TABLAS *********************/
		
		// Se obtiene el modelo
		modeloComanda = new ControladorTablaComandas(FramePrincipal.session, 
				ControladorServicioActivoMesa.obtenerServicioActivoMesa(FramePrincipal.session, idMesa).getIdServicio());
		
		// Creación de la tabla
		tablaComanda = new JTable(modeloComanda);
		
		// Centrado de los valores en las columnas
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
        tablaComanda.getColumnModel().getColumn(0).setCellRenderer(modelocentrar);
        tablaComanda.getColumnModel().getColumn(1).setCellRenderer(modelocentrar); 
		
		// No permitimos que nuestras columnas se muevan
		tablaComanda.getTableHeader().setReorderingAllowed(false);
		
		// Paneles
		JPanel panelTablaComanda = new JPanel();;
		
		// Ponemos BorderLayout a nuestros paneles para que la tabla ocupe todo el espacio
		panelTablaComanda.setLayout(new BorderLayout());
		
		// Para que se vean los titulos de las columnas, se introduce la tabla en un JScrollPane
		JScrollPane scroll = new JScrollPane(tablaComanda);

		// Se introducen los JScrollPane dentro de los paneles creados anteriormente
		panelTablaComanda.add(scroll);

		/************ FIN TABLAS **************/
		
		// Panel verComanda
		panelVerComanda = new JScrollPane();
		panelVerComanda.setPreferredSize(new Dimension(600,400));
		
		
		// Panel cobrar
		panelCobrar = new JPanel();
		panelCobrar.setLayout(new BoxLayout(panelCobrar, BoxLayout.Y_AXIS));
		
		// Componentes del panel cobrar
		importe = new JLabel("Total mesa: " + 
		df.format(ControladorServicioActivoMesa.obtenerServicioActivoMesa(FramePrincipal.session, idMesa).getGasto()).toString() + "€");
		panelCobrar.add(importe);
		// Subpanel cantidad entregada
		panelCantidadEntregada = new JPanel();
		panelCantidadEntregada.setLayout(new BoxLayout(panelCantidadEntregada, BoxLayout.X_AXIS));
		textoCantidadEntregada = new JLabel("Cantidad entregada: ");
		cantidadEntregada = new JTextField(10);
		botonCobrar = new JButton("Cobrar");
		botonCobrar.addActionListener(this);
		
		panelCantidadEntregada.add(textoCantidadEntregada);
		panelCantidadEntregada.add(cantidadEntregada);
		panelCantidadEntregada.add(botonCobrar);
		panelCobrar.add(panelCantidadEntregada);		
		
		cambio = new JLabel("Importe a devolver: 0,00€");
		panelCobrar.add(cambio);
		
		// Panel contenedor iquierdo
		panelContenedorIquierdo = new JPanel();
		panelContenedorIquierdo.setLayout(new BoxLayout(panelContenedorIquierdo, BoxLayout.Y_AXIS));
		panelContenedorIquierdo.add(panelTablaComanda);
		panelContenedorIquierdo.add(panelCobrar);
		
		// Panel pad
		panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this); // Escuchador de la interfaz OnBotonPulsado
		
		// Panel contenedor global
		panelContenedorGlobal = new JPanel();
		panelContenedorGlobal.setLayout(new BoxLayout(panelContenedorGlobal, BoxLayout.X_AXIS));
		panelContenedorGlobal.add(panelContenedorIquierdo);
		panelContenedorGlobal.add(panelPad);
		
		// Diálogo de confirmación
		showConfirmDialog(this, panelContenedorGlobal, "Comanda de la mesa " + idBotonMesa, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	// Desarrollo de los métodos de la interfaz OnBotonPulsado
	@Override
	public void botonPulsado(String buffer) {
		// Actualización del JTextField
		cantidadEntregada.setText(buffer);
	}

	
	// Desarrollo de los métodos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == botonCobrar){
			
			// Llamada al controlador de cobros para acutalizar el JTextField que muestra el cambio a devolver
			cambio.setText("Importe a devolver: " + ControladorCobrosYFacturacion.obtenerCambio(
					ControladorServicioActivoMesa.obtenerServicioActivoMesa(FramePrincipal.session, idMesa),
					Double.valueOf(cantidadEntregada.getText())) + "€");
			
			// Llamada al controlador de cobros para registrar la facturación y cambiar el estado del servicio
			ControladorCobrosYFacturacion.insertarFacturacion(FramePrincipal.session, 
					ControladorServicioActivoMesa.obtenerServicioActivoMesa(FramePrincipal.session, idMesa));
			
			// Llamada al controlador de estado de mesa para dejarla libre para un nuevo servicio
			EstadoMesa.cambiarEstadoMesa(FramePrincipal.session, idMesa, false);
		}
	}
}
