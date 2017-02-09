package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.ControladorJComboBoxEmpleados;
import models.Empleado;

public class DialogConsultarModificarEmpleado extends JOptionPane implements ChangeListener, ActionListener, ItemListener{
	
	// Variables
	private JPanel panelContenedor;
	private JPanel panelComboBox;
	private JPanel panelEditables;
	private JPanel panelCheckBox;
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
	private boolean permisosEdicion = false;
	private int confirmacionUsuario;
	
	// Constructor
	public DialogConsultarModificarEmpleado(){
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
		listaEmpleados = ControladorJComboBoxEmpleados.obtenerListaEmpleados(FramePrincipal.session);
		// JComboBox no admite ArrayList como par�metro. Se pasa el ArrayList a Array
		arrayEmpleados = new Empleado[listaEmpleados.size()];
		arrayEmpleados = listaEmpleados.toArray(arrayEmpleados);
		// Obtenemos la informaci�n que nos interesa
		arrayInfoEmpleados = new String[arrayEmpleados.length];
		for(int i=0; i<arrayEmpleados.length; i++){
			arrayInfoEmpleados[i] = arrayEmpleados[i].getNombre() + " " + arrayEmpleados[i].getApellidos();
		}
		seleccionEmpleado = new JLabel("Selecciona un empleado");
		empleadosDisponibles = new JComboBox<String>(arrayInfoEmpleados);
		empleadosDisponibles.addItemListener(this);
		
		// Se a�aden los elementos al panel
		panelComboBox.add(seleccionEmpleado);
		panelComboBox.add(empleadosDisponibles);
		
		/*** Instanciaci�n del panelEditables ***/
		panelEditables = new JPanel(new GridLayout(6,2));
		
		// Instanciaci�n de los elementos del panelEditables
		labelNombre = new JLabel("Nombre: ");
		labelApellidos = new JLabel("Apellidos: ");
		labelPassword = new JLabel("Password: ");
		labelTelefono = new JLabel("Tel�fono: ");
		labelDNI = new JLabel("DNI: ");
		labelPermisos = new JLabel("Permisos: ");
		labelPermisos.setToolTipText("Gerencia: 1, Personal: 0");
		
		campoNombre = new JTextField(10);
		campoApellidos = new JTextField(10);
		campoPassword = new JTextField(10);
		campoTelefono = new JTextField(10);
		campoDNI = new JTextField(10);
		campoPermisos = new JComboBox<Integer>(arrayPermisos);
		
		// Visibilidad inicial de los campos editables
		campoNombre.setEditable(permisosEdicion);
		campoApellidos.setEditable(permisosEdicion);
		campoPassword.setEditable(permisosEdicion);
		campoTelefono.setEditable(permisosEdicion);
		campoDNI.setEditable(permisosEdicion);
		campoPermisos.setEnabled(permisosEdicion);
		
		// Se a�aden los elementos al panel
		panelEditables.add(labelNombre);
		panelEditables.add(campoNombre);
		panelEditables.add(labelApellidos);
		panelEditables.add(campoApellidos);
		panelEditables.add(labelPassword);
		panelEditables.add(campoPassword);
		panelEditables.add(labelTelefono);
		panelEditables.add(campoTelefono);
		panelEditables.add(labelDNI);
		panelEditables.add(campoDNI);
		panelEditables.add(labelPermisos);
		panelEditables.add(campoPermisos);
		
		/*** Instanciaci�n del panelRadioButton ***/
		panelCheckBox = new JPanel();
		
		// Instanciaci�n de los elementos del panel
		checkBoxEdicion = new JCheckBox("�Permitir edici�n?", false);
		checkBoxEdicion.addChangeListener(this);
		
		// Se a�aden los elementos al panel
		panelCheckBox.add(checkBoxEdicion);
		
		/*** Se a�aden los paneles anteriores al panelContenedor ***/
		panelContenedor.add(panelComboBox);
		panelContenedor.add(panelEditables);
		panelContenedor.add(panelCheckBox);
		
		/*** Se muestra el di�logo ***/
		confirmacionUsuario = showConfirmDialog(this, panelContenedor, "Consultar/Modificar empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null);
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
			campoNombre.setEditable(permisosEdicion);
			campoApellidos.setEditable(permisosEdicion);
			campoPassword.setEditable(permisosEdicion);
			campoTelefono.setEditable(permisosEdicion);
			campoDNI.setEditable(permisosEdicion);
			campoPermisos.setEnabled(permisosEdicion);
		}
		else{
			// CheckBox NO seleccionado. No se permite la edici�n
			permisosEdicion = false;
			campoNombre.setEditable(permisosEdicion);
			campoApellidos.setEditable(permisosEdicion);
			campoPassword.setEditable(permisosEdicion);
			campoTelefono.setEditable(permisosEdicion);
			campoDNI.setEditable(permisosEdicion);
			campoPermisos.setEnabled(permisosEdicion);
		}
	}

	// Desarrollo de los m�todos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// Capturar el evento click del bot�n aceptar
		if(confirmacionUsuario == JOptionPane.DEFAULT_OPTION){
			
		}
	}

	// Desarrollo de los m�todos de la interfaz ItemListener
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == empleadosDisponibles){
			// Se captura el �ndice del elemento seleccionado del JComboBox
			int indice = empleadosDisponibles.getSelectedIndex();
			// Se rellena la informaci�n del empleado seleccionado
			campoNombre.setText(listaEmpleados.get(indice).getNombre());
			campoApellidos.setText(listaEmpleados.get(indice).getApellidos());
			campoPassword.setText(String.valueOf(listaEmpleados.get(indice).getPasswordEmpleado()));
			campoTelefono.setText(String.valueOf(listaEmpleados.get(indice).getTelefono()));
			campoDNI.setText(listaEmpleados.get(indice).getDni());
			// Para modificar el JComboBox, hay que transformar un boolean a entero
			int indicePermisos;
			if(listaEmpleados.get(indice).isPermisos()){
				// El empleado tiene permisos de gerencia
				indicePermisos = 1;
			}
			else{
				// El empleado no tiene permisos de gerencia
				indicePermisos = 0;
			}
			campoPermisos.setSelectedIndex(indicePermisos);
		}
	}
}
