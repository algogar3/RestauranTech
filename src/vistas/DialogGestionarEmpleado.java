package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controllers.ControladorInsertarActualizarEmpleados;
import controllers.ControladorJComboBoxEmpleados;
import controllers.ControladorPermisos;
import models.Empleado;

public class DialogGestionarEmpleado extends JOptionPane implements ChangeListener, ActionListener, ItemListener, DocumentListener{
	
	// Variables
	private JPanel panelContenedor;
	private JPanel panelComboBox;
	private JPanel panelCampos;
	private JPanel panelEditarEmpleado;
	private JPanel panelCrearEmpleado;
	private JComboBox empleadosDisponibles;
	private Empleado[] arrayEmpleados;
	private String[] arrayInfoEmpleados;
	private ArrayList<Empleado> listaEmpleados;
	private JLabel seleccionEmpleado;
	private JLabel labelNombre;
	private JLabel labelApellidos;
	private JLabel labelPassword;
	private JLabel labelTelefono;
	private JLabel labelDNI;
	private JLabel labelPermisos;
	private JTextField campoNombre;
	private JTextField campoApellidos;
	private JTextField campoPassword;
	private JTextField campoTelefono;
	private JTextField campoDNI;
	private JComboBox campoPermisos;
	private Integer[] arrayPermisos = {0, 1};
	private JCheckBox checkBoxEdicion;
	private JButton botonCrearEmpleado;
	private JButton botonConsultarEditarEmpleado;
	private boolean permisosEdicion = false;
	private int confirmacionUsuario;
	private Empleado empleadoTemporal; 
	private boolean creandoEmpleado = false;
	
	// Constructor
	public DialogGestionarEmpleado(){
		iniciarGUI();
	}
	
	// Método iniciarGUI()
	private void iniciarGUI(){
		/*** Instanciación del panelContenedor ***/
		panelContenedor = new JPanel();
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
		
		// Instanciación del panelComboBox
		panelComboBox = new JPanel();
		
		// Instanciación de los elementos del panelComboBox
		listaEmpleados = ControladorJComboBoxEmpleados.obtenerListaEmpleados(FramePrincipal.session);
		// JComboBox no admite ArrayList como parámetro. Se pasa el ArrayList a Array
		arrayEmpleados = new Empleado[listaEmpleados.size()];
		arrayEmpleados = listaEmpleados.toArray(arrayEmpleados);
		// Obtenemos la información que nos interesa
		arrayInfoEmpleados = new String[arrayEmpleados.length];
		for(int i=0; i<arrayEmpleados.length; i++){
			arrayInfoEmpleados[i] = arrayEmpleados[i].getNombre() + " " + arrayEmpleados[i].getApellidos();
		}
		seleccionEmpleado = new JLabel("Selecciona un empleado");
		empleadosDisponibles = new JComboBox<String>(arrayInfoEmpleados);
		empleadosDisponibles.addItemListener(this);
		
		// Se añaden los elementos al panel
		panelComboBox.add(seleccionEmpleado);
		panelComboBox.add(empleadosDisponibles);
		
		/*** Instanciación del panelCampos ***/
		panelCampos = new JPanel(new GridLayout(6,2));
		
		// Instanciación de los elementos del panelCampos
		labelNombre = new JLabel("Nombre: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelPassword = new JLabel("Password: ");
		labelTelefono = new JLabel("Teléfono: ");
		labelDNI = new JLabel("DNI: ");
		labelPermisos = new JLabel("Permisos: ");
		labelPermisos.setToolTipText("Gerencia: 1, Personal: 0");
		
		campoNombre = new JTextField(10);
		campoApellidos = new JTextField(10);
		campoPassword = new JTextField(10);
		campoTelefono =  new JTextField(10);
		campoDNI = new JTextField(10);
		campoPermisos = new JComboBox<Integer>(arrayPermisos);
		
		// Visibilidad inicial de los campos editables
		campoNombre.setEditable(permisosEdicion);
		campoApellidos.setEditable(permisosEdicion);
		campoPassword.setEditable(permisosEdicion);
		campoTelefono.setEditable(permisosEdicion);
		campoDNI.setEditable(permisosEdicion);
		campoPermisos.setEnabled(permisosEdicion);
		
		// Escuchadores
		campoNombre.getDocument().addDocumentListener(this);
		campoApellidos.getDocument().addDocumentListener(this);
		campoPassword.getDocument().addDocumentListener(this);
		campoTelefono.getDocument().addDocumentListener(this);
		campoDNI.getDocument().addDocumentListener(this);
		campoPermisos.addItemListener(this);
		
		// Se añaden los elementos al panel
		panelCampos.add(labelNombre);
		panelCampos.add(campoNombre);
		panelCampos.add(labelApellidos);
		panelCampos.add(campoApellidos);
		panelCampos.add(labelPassword);
		panelCampos.add(campoPassword);
		panelCampos.add(labelTelefono);
		panelCampos.add(campoTelefono);
		panelCampos.add(labelDNI);
		panelCampos.add(campoDNI);
		panelCampos.add(labelPermisos);
		panelCampos.add(campoPermisos);
		
		/*** Instanciación del panelEditarEmpleado ***/
		panelEditarEmpleado = new JPanel();
		
		// Instanciación de los elementos del panel
		checkBoxEdicion = new JCheckBox("¿Permitir edición?", false);
		checkBoxEdicion.addChangeListener(this);
		
		// Se añaden los elementos al panel
		panelEditarEmpleado.add(checkBoxEdicion);;
		
		/*** Instanciación del panel panelCrearEmpleado ***/
		panelCrearEmpleado = new JPanel();
		
		// Instanciación de los elementos del panel
		botonCrearEmpleado = new JButton("Nuevo empleado");
		botonCrearEmpleado.addActionListener(this);
		botonConsultarEditarEmpleado = new JButton("Consultar/Editar empleado");
		botonConsultarEditarEmpleado.addActionListener(this);
		botonConsultarEditarEmpleado.setEnabled(false);
		
		// Se añaden los elementos al panel
		panelCrearEmpleado.add(botonCrearEmpleado);
		panelCrearEmpleado.add(botonConsultarEditarEmpleado);
		
		/*** Se añaden los paneles anteriores al panelContenedor ***/
		panelContenedor.add(panelComboBox);
		panelContenedor.add(panelCampos);
		panelContenedor.add(panelEditarEmpleado);
		panelContenedor.add(panelCrearEmpleado);
		
		/*** Se muestra el diálogo ***/
		confirmacionUsuario = showConfirmDialog(this, panelContenedor, "Gestionar empleados", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
		
		/*** Acciones del botón ACEPTAR ***/
		if(confirmacionUsuario == JOptionPane.OK_OPTION){
			// Se llama al controlador para que realice la transacción en la base de datos, en caso
			// de que se haya registrado alguna modificación en los datos o se haya creado un nuevo
			// empleado
			if(!empleadoTemporal.getNombre().isEmpty()){
				// Se han registrado cambios
				if(creandoEmpleado){
					// Se ha creado un nuevo empleado
					ControladorInsertarActualizarEmpleados.realizarTransaccionEmpleado(FramePrincipal.session, empleadoTemporal, creandoEmpleado, null);
				}
				else{
					// Se ha modificado un empleado existente
					ControladorInsertarActualizarEmpleados.realizarTransaccionEmpleado(FramePrincipal.session, empleadoTemporal, creandoEmpleado,
							empleadosDisponibles.getSelectedIndex());
				}
			}
		}
	}

	// Desarrollo de los métodos de la interfaz ChangeListener
	@Override
	public void stateChanged(ChangeEvent e) {
		// Se recoge el checkbox que generó el evento
		JCheckBox checkBox = (JCheckBox) e.getSource();
		// Comprobación del estado del checkbox
		if(checkBox.isSelected()){
			// CheckBox seleccionado. Se permite la edición
			permisosEdicion = true;
			campoNombre.setEditable(permisosEdicion);
			campoApellidos.setEditable(permisosEdicion);
			campoPassword.setEditable(permisosEdicion);
			campoTelefono.setEditable(permisosEdicion);
			campoDNI.setEditable(permisosEdicion);
			campoPermisos.setEnabled(permisosEdicion);
			
			// Se prepara un objeto empleado para guardar los cambios
			empleadoTemporal = new Empleado();			
		}
		else{
			// CheckBox NO seleccionado. No se permite la edición
			permisosEdicion = false;
			campoNombre.setEditable(permisosEdicion);
			campoApellidos.setEditable(permisosEdicion);
			campoPassword.setEditable(permisosEdicion);
			campoTelefono.setEditable(permisosEdicion);
			campoDNI.setEditable(permisosEdicion);
			campoPermisos.setEnabled(permisosEdicion);
		}
	}

	// Desarrollo de los métodos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// Capturar el evento click del boton crear empleado
		if(e.getSource() == botonCrearEmpleado){
			// Se oculta la lista desplegable de empleados y se desactiva el checkbox editar
			empleadosDisponibles.setVisible(false);
			checkBoxEdicion.setEnabled(false);
			
			// Se hacen los campos editables y se limpian de contendio
			campoNombre.setEditable(true);
			campoNombre.setText("");
			
			campoApellidos.setEditable(true);
			campoApellidos.setText("");
			
			campoPassword.setEditable(true);
			campoPassword.setText("");
			
			campoTelefono.setEditable(true);
			campoTelefono.setText("");
			
			campoDNI.setEditable(true);
			campoDNI.setText("");
			
			campoPermisos.setEnabled(true);
			campoPermisos.setSelectedIndex(0);
			
			// Visibilidad de los botones para no confundir al usuario
			botonCrearEmpleado.setEnabled(false);
			botonConsultarEditarEmpleado.setEnabled(true);
			
			// Título del diálogo
			seleccionEmpleado.setText("Introduce los datos del nuevo empleado");
			
			// Variable de control
			creandoEmpleado = true;
			
			// Se prepara un objeto empleado para guardar los cambios
			empleadoTemporal = new Empleado();
		}
		
		// Capturar el evento click del boton consultar/editar empleado
		else if(e.getSource() == botonConsultarEditarEmpleado){
			// Se vuelve a mostrar la lista desplegable de empleados y el checkbox
			empleadosDisponibles.setVisible(true);
			empleadosDisponibles.setSelectedIndex(0);
			checkBoxEdicion.setEnabled(true);
			
			// Visibilidad de los botones para no confundir al usuario
			botonConsultarEditarEmpleado.setEnabled(false);
			botonCrearEmpleado.setEnabled(true);
			
			// Título del diálogo
			seleccionEmpleado.setText("Selecciona un empleado");
			
			// Variable de control
			creandoEmpleado = false;
		}
	}

	// Desarrollo de los métodos de la interfaz ItemListener
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Lista desplegable de empleados
		if(e.getSource() == empleadosDisponibles){
			// Se captura el índice del elemento seleccionado del JComboBox
			int indice = empleadosDisponibles.getSelectedIndex();
			// Se rellena la información del empleado seleccionado
			campoNombre.setText(listaEmpleados.get(indice).getNombre());
			campoApellidos.setText(listaEmpleados.get(indice).getApellidos());
			campoPassword.setText(String.valueOf(listaEmpleados.get(indice).getPasswordEmpleado()));
			campoTelefono.setText(String.valueOf(listaEmpleados.get(indice).getTelefono()));
			campoDNI.setText(listaEmpleados.get(indice).getDni());
			campoPermisos.setSelectedIndex(ControladorPermisos.obtenerTinyint(listaEmpleados.get(indice).isPermisos()));
		}
		
		// Lista desplegable de permisos
		else if(e.getSource() == campoPermisos){
			// Se han editado los permisos de alguno de los empleados
			if(checkBoxEdicion.isSelected() || creandoEmpleado){
				empleadoTemporal.setNombre(campoNombre.getText());
				empleadoTemporal.setApellidos(campoApellidos.getText());
				// Se comprueba que los campos password y teléfono no estén vacios para que no salte 
				// una excepción al castear
				if(!campoPassword.getText().isEmpty() && !campoTelefono.getText().isEmpty()){
					empleadoTemporal.setPasswordEmpleado(Integer.valueOf(campoPassword.getText().toString()));
					empleadoTemporal.setTelefono(Integer.valueOf(campoTelefono.getText().toString()));
					empleadoTemporal.setPermisos(ControladorPermisos.obtenerBooleano(campoPermisos.getSelectedIndex()));
				}
				empleadoTemporal.setDni(campoDNI.getText());
				empleadoTemporal.setPermisos(ControladorPermisos.obtenerBooleano(campoPermisos.getSelectedIndex()));
				System.out.println("Empleado:");
				System.out.println(empleadoTemporal.isPermisos());
			}
		}
	}

	// Desarrollo de los métodos de la interfaz DocumentListener
	@Override
	public void changedUpdate(DocumentEvent e) {
		// Vacío
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// No es necesario capturar el elemento que dió origen al evento, ya que en actualizaremos
		// el objeto empleado en la base de datos, no un campo concreto
		if(checkBoxEdicion.isSelected() || creandoEmpleado){
			empleadoTemporal.setNombre(campoNombre.getText());
			empleadoTemporal.setApellidos(campoApellidos.getText());
			// Se comprueba que los campos password y teléfono no estén vacios para que no salte 
			// una excepción al castear
			if(!campoPassword.getText().isEmpty() && !campoTelefono.getText().isEmpty()){
				empleadoTemporal.setPasswordEmpleado(Integer.valueOf(campoPassword.getText().toString()));
				empleadoTemporal.setTelefono(Integer.valueOf(campoTelefono.getText().toString()));
				empleadoTemporal.setPermisos(ControladorPermisos.obtenerBooleano(campoPermisos.getSelectedIndex()));
			}
			empleadoTemporal.setDni(campoDNI.getText());
			empleadoTemporal.setPermisos(ControladorPermisos.obtenerBooleano(campoPermisos.getSelectedIndex()));
			
			System.out.println("Empleado:");
			System.out.println(empleadoTemporal.getNombre() + " " + empleadoTemporal.getApellidos() + " " + empleadoTemporal.getPasswordEmpleado() + 
					" " + empleadoTemporal.getTelefono() + " " + empleadoTemporal.getDni() + " " + empleadoTemporal.isPermisos());
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// No es necesario capturar el elemento que dió origen al evento, ya que en actualizaremos
		// el objeto empleado en la base de datos, no un campo concreto
		if(checkBoxEdicion.isSelected()){
			empleadoTemporal.setNombre(campoNombre.getText());
			empleadoTemporal.setApellidos(campoApellidos.getText());
			if(!campoPassword.getText().isEmpty() && !campoTelefono.getText().isEmpty()){
				empleadoTemporal.setPasswordEmpleado(Integer.valueOf(campoPassword.getText().toString()));
				empleadoTemporal.setTelefono(Integer.valueOf(campoTelefono.getText().toString()));
			}
			empleadoTemporal.setDni(campoDNI.getText());
			empleadoTemporal.setPermisos(ControladorPermisos.obtenerBooleano(campoPermisos.getSelectedIndex()));
			
			System.out.println("Empleado:");
			System.out.println(empleadoTemporal.getNombre() + " " + empleadoTemporal.getApellidos() + " " + empleadoTemporal.getPasswordEmpleado() + 
					" " + empleadoTemporal.getTelefono() + " " + empleadoTemporal.getDni() + " " + empleadoTemporal.isPermisos());
		}
	}
}
