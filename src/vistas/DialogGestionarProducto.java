package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import controllers.ControladorInsertarActualizarProductos;
import controllers.ControladorJComboBoxProductos;
import controllers.ControladorTipoProducto;
import models.Producto;

public class DialogGestionarProducto extends JOptionPane implements ChangeListener, ActionListener, ItemListener, DocumentListener{
	
	// Variables
	private JPanel panelContenedor;
	private JPanel panelComboBox;
	private JPanel panelCampos;
	private JPanel panelEditarProducto;
	private JPanel panelAccionesDisponibles;
	private JComboBox productosDisponibles;
	private Producto[] arrayProductos;
	private String[] arrayInfoProductos;
	private ArrayList<Producto> listaProductos;
	private JLabel seleccionProducto;
	private JLabel labelDenominacion;
	private JLabel labelTipoProducto;
	private JLabel labelPrecio;
	private JLabel labelDescripcion;
	private JTextField campoDenominacion;
	private JComboBox campoTipoProducto;
	private JTextField campoPrecio;
	private JTextArea campoDescripcion;
	private String[] arrayTipoProducto = {"comida", "bebida", "postre"};
	private JCheckBox checkBoxEdicion;
	private JButton botonCrearProducto;
	private JButton botonConsultarEditarProducto;
	private boolean permisosEdicion = false;
	private int confirmacionUsuario;
	private Producto productoTemporal = new Producto(); 
	private boolean creandoProducto = false;
	
	// Constructor
	public DialogGestionarProducto(){
		iniciarGUI();
	}
	
	// M�todo iniciarGUI()
	private void iniciarGUI(){
		/*** Instanciaci�n del panelContenedor ***/
		panelContenedor = new JPanel();
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
		
		// Instanciaci�n del panelComboBox
		panelComboBox = new JPanel();
		
		// Instanciaci�n de los elementos del panelComboBox
		listaProductos = ControladorJComboBoxProductos.obtenerListaProductos(FramePrincipal.session);
		// JComboBox no admite ArrayList como par�metro. Se pasa el ArrayList a Array
		arrayProductos = new Producto[listaProductos.size()];
		arrayProductos = listaProductos.toArray(arrayProductos);
		// Obtenemos la informaci�n que nos interesa
		arrayInfoProductos = new String[arrayProductos.length];
		for(int i=0; i<arrayProductos.length; i++){
			arrayInfoProductos[i] = arrayProductos[i].getDenominacion();
		}
		seleccionProducto = new JLabel("Selecciona un producto");
		productosDisponibles = new JComboBox<String>(arrayInfoProductos);
		productosDisponibles.addItemListener(this);
		
		// Se a�aden los elementos al panel
		panelComboBox.add(seleccionProducto);
		panelComboBox.add(productosDisponibles);
		
		/*** Instanciaci�n del panelCampos ***/
		panelCampos = new JPanel(new GridLayout(4,2));
		
		// Instanciaci�n de los elementos del panelCampos
		labelDenominacion = new JLabel("Denominaci�n: ");
		labelTipoProducto = new JLabel("Tipo de producto: ");
		labelPrecio = new JLabel("Precio: ");
		labelDescripcion = new JLabel("Descripci�n");
		
		// Al instanciar los JTextField de cada producto, se asignan por defecto los valores de primer producto, 
		// ya que es �ste el que aparece seleccionado por defecto en el JComboBox
		campoDenominacion = new JTextField(arrayProductos[0].getDenominacion());
		campoTipoProducto = new JComboBox<String>(arrayTipoProducto);
		campoTipoProducto.setSelectedIndex(ControladorTipoProducto.obtenerIndiceTipoProducto(arrayProductos[0].getTipoProducto()));
		campoPrecio = new JTextField(String.valueOf(arrayProductos[0].getPrecio()));
		campoDescripcion = new JTextArea(3,20);
		campoDescripcion.setText(arrayProductos[0].getDescripcion());
		
		// Visibilidad inicial de los campos editables
		campoDenominacion.setEditable(permisosEdicion);
		campoTipoProducto.setEnabled(permisosEdicion);
		campoPrecio.setEditable(permisosEdicion);
		campoDescripcion.setEditable(permisosEdicion);
		
		// Escuchadores
		campoDenominacion.getDocument().addDocumentListener(this);
		campoTipoProducto.addItemListener(this);
		campoPrecio.getDocument().addDocumentListener(this);
		campoDescripcion.getDocument().addDocumentListener(this);
		
		
		// Se a�aden los elementos al panel
		panelCampos.add(labelDenominacion);
		panelCampos.add(campoDenominacion);
		panelCampos.add(labelTipoProducto);
		panelCampos.add(campoTipoProducto);
		panelCampos.add(labelPrecio);
		panelCampos.add(campoPrecio);
		panelCampos.add(labelDescripcion);
		panelCampos.add(campoDescripcion);
		
		/*** Instanciaci�n del panelEditarProducto ***/
		panelEditarProducto = new JPanel();
		
		// Instanciaci�n de los elementos del panel
		checkBoxEdicion = new JCheckBox("�Permitir edici�n?", false);
		checkBoxEdicion.addChangeListener(this);
		
		// Se a�aden los elementos al panel
		panelEditarProducto.add(checkBoxEdicion);;
		
		/*** Instanciaci�n del panel panelAccionesDisponibles ***/
		panelAccionesDisponibles = new JPanel();
		
		// Instanciaci�n de los elementos del panel
		botonCrearProducto = new JButton("Nuevo producto");
		botonCrearProducto.addActionListener(this);
		botonConsultarEditarProducto = new JButton("Consultar/Editar producto");
		botonConsultarEditarProducto.addActionListener(this);
		botonConsultarEditarProducto.setEnabled(false);
		
		// Se a�aden los elementos al panel
		panelAccionesDisponibles.add(botonCrearProducto);
		panelAccionesDisponibles.add(botonConsultarEditarProducto);
		
		/*** Se a�aden los paneles anteriores al panelContenedor ***/
		panelContenedor.add(panelComboBox);
		panelContenedor.add(panelCampos);
		panelContenedor.add(panelEditarProducto);
		panelContenedor.add(panelAccionesDisponibles);
		
		/*** Se muestra el di�logo ***/
		confirmacionUsuario = showConfirmDialog(this, panelContenedor, "Gestionar productos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
		
		/*** Acciones del bot�n ACEPTAR ***/
		if(confirmacionUsuario == JOptionPane.OK_OPTION){
			// Se llama al controlador para que realice la transacci�n en la base de datos, en caso
			// de que se haya registrado alguna modificaci�n en los datos o se haya creado un nuevo
			// producto
			if(!productoTemporal.getDenominacion().isEmpty()){
				// Se han registrado cambios
				if(creandoProducto){
					// Se ha creado un nuevo producto
					ControladorInsertarActualizarProductos.realizarTransaccionProducto(FramePrincipal.session, productoTemporal, creandoProducto, null);
				}
				else{
					// Se ha modificado un producto
					ControladorInsertarActualizarProductos.realizarTransaccionProducto(FramePrincipal.session, productoTemporal, creandoProducto,
							productosDisponibles.getSelectedIndex() + 1);
				}
			}
		}
	}

	// Desarrollo de los m�todos de la interfaz ChangeListener
	@Override
	public void stateChanged(ChangeEvent e) {
		// Se recoge el checkbox que gener� el evento
		JCheckBox checkBox = (JCheckBox) e.getSource();
		// Comprobaci�n del estado del checkbox
		if(checkBox.isSelected()){
			// CheckBox seleccionado. Se permite la edici�n
			permisosEdicion = true;
			campoDenominacion.setEditable(permisosEdicion);
			campoTipoProducto.setEnabled(permisosEdicion);
			campoPrecio.setEditable(permisosEdicion);
			campoDescripcion.setEditable(permisosEdicion);
		}
		else{
			// CheckBox NO seleccionado. No se permite la edici�n
			permisosEdicion = false;
			campoDenominacion.setEditable(permisosEdicion);
			campoTipoProducto.setEnabled(permisosEdicion);
			campoPrecio.setEditable(permisosEdicion);
			campoDescripcion.setEditable(permisosEdicion);
		}
	}

	// Desarrollo de los m�todos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// Capturar el evento click del boton crear 
		if(e.getSource() == botonCrearProducto){
			// Se oculta la lista desplegable de productos y se desactiva el checkbox editar
			productosDisponibles.setVisible(false);
			checkBoxEdicion.setEnabled(false);
			
			// Se hacen los campos editables y se limpian de contendio
			campoDenominacion.setEditable(true);
			campoDenominacion.setText("");
			
			campoTipoProducto.setEnabled(true);
			campoTipoProducto.setSelectedIndex(0);
			
			campoPrecio.setEditable(true);
			campoPrecio.setText("");
			
			campoDescripcion.setEditable(true);
			campoDescripcion.setText("");
			
			// Visibilidad de los botones para no confundir al usuario
			botonCrearProducto.setEnabled(false);
			botonConsultarEditarProducto.setEnabled(true);
			
			// T�tulo del di�logo
			seleccionProducto.setText("Introduce los datos del nuevo producto");
			
			// Variable de control
			creandoProducto = true;
			
			// Se prepara un objeto producto para guardar los cambios
			productoTemporal = new Producto();
		}
		
		// Capturar el evento click del boton consultar/editar producto
		else if(e.getSource() == botonConsultarEditarProducto){
			// Se vuelve a mostrar la lista desplegable de productos y el checkbox
			productosDisponibles.setVisible(true);
			productosDisponibles.setSelectedIndex(0);
			checkBoxEdicion.setEnabled(true);
			
			// Visibilidad de los botones para no confundir al usuario
			botonConsultarEditarProducto.setEnabled(false);
			botonCrearProducto.setEnabled(true);
			
			// T�tulo del di�logo
			seleccionProducto.setText("Selecciona un producto");
			
			// Variable de control
			creandoProducto = false;
			
			// Se prepara un objeto producto para guardar los cambios
			productoTemporal = new Producto();
		}
	}

	// Desarrollo de los m�todos de la interfaz ItemListener
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Lista desplegable de productos
		if(e.getSource() == productosDisponibles){
			// Se captura el �ndice del elemento seleccionado del JComboBox
			int indice = productosDisponibles.getSelectedIndex();
			// Se rellena la informaci�n del producto seleccionado
			campoDenominacion.setText(listaProductos.get(indice).getDenominacion());
			campoTipoProducto.setSelectedIndex(ControladorTipoProducto.obtenerIndiceTipoProducto(listaProductos.get(indice).getTipoProducto()));
			campoPrecio.setText(String.valueOf(listaProductos.get(indice).getPrecio()));
			campoDescripcion.setText(String.valueOf(listaProductos.get(indice).getDescripcion()));
			
		}
		
		// Lista desplegable de tipos de producto
		else if(e.getSource() == campoTipoProducto){
			// Se ha editado el tipo de producto de alguno de los productos
			if(checkBoxEdicion.isSelected() || creandoProducto){
				productoTemporal.setDenominacion(campoDenominacion.getText());
				productoTemporal.setTipoProducto(ControladorTipoProducto.obtenerTipoProducto(campoTipoProducto.getSelectedIndex()));
				// Se comprueba que el campo precio no est� vacio para que no salte una excepci�n al castar 
				if(!campoPrecio.getText().isEmpty()){
					productoTemporal.setPrecio(BigDecimal.valueOf(Double.valueOf(campoPrecio.getText().toString())));
				}
				productoTemporal.setDescripcion(campoDescripcion.getText());
				
				System.out.println("Producto:");
				System.out.println(productoTemporal.getTipoProducto());
			}
		}
	}

	// Desarrollo de los m�todos de la interfaz DocumentListener
	@Override
	public void changedUpdate(DocumentEvent e) {
		// Vac�o
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// No es necesario capturar el elemento que di� origen al evento, ya que en actualizaremos
		// el objeto producto al completo en la base de datos, no un campo concreto
		if(checkBoxEdicion.isSelected() || creandoProducto){
			productoTemporal.setDenominacion(campoDenominacion.getText());
			productoTemporal.setTipoProducto(ControladorTipoProducto.obtenerTipoProducto(campoTipoProducto.getSelectedIndex()));
			// Se comprueba que el campo precio no est� vacio para que no salte una excepci�n al castar 
			if(!campoPrecio.getText().isEmpty()){
				productoTemporal.setPrecio(BigDecimal.valueOf(Double.valueOf(campoPrecio.getText().toString())));
			}
			productoTemporal.setDescripcion(campoDescripcion.getText());
			
			
			System.out.println("producto:");
			System.out.println(productoTemporal.getDenominacion() + " " + productoTemporal.getTipoProducto() + " " + productoTemporal.getPrecio() + 
					" " + productoTemporal.getDescripcion());
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// No es necesario capturar el elemento que di� origen al evento, ya que en actualizaremos
		// el objeto producto al completo en la base de datos, no un campo concreto
		if(checkBoxEdicion.isSelected()){
			productoTemporal.setDenominacion(campoDenominacion.getText());
			productoTemporal.setTipoProducto(ControladorTipoProducto.obtenerTipoProducto(campoTipoProducto.getSelectedIndex()));
			// Se comprueba que el campo precio no est� vacio para que no salte una excepci�n al castar 
			if(!campoPrecio.getText().isEmpty()){
				productoTemporal.setPrecio(BigDecimal.valueOf(Double.valueOf(campoPrecio.getText().toString())));
			}
			productoTemporal.setDescripcion(campoDescripcion.getText());
			
			
			System.out.println("producto:");
			System.out.println(productoTemporal.getDenominacion() + " " + productoTemporal.getTipoProducto() + " " + productoTemporal.getPrecio() + 
					" " + productoTemporal.getDescripcion());
		}
	}
}
