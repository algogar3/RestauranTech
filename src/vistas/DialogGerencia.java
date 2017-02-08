package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controllers.EstadoMesa;

public class DialogGerencia extends JOptionPane implements ActionListener{
	// Constantes
	public static final int KEY_MODIFICAR_EMPLEADO = 0;
	public static final int KEY_ALTA_EMPLEADO = 1;
	public static final int KEY_MODIFICAR_PRODUCTO = 2;
	public static final int KEY_ALTA_PRODUCTO = 3;
	
	// Variables
	private ButtonGroup buttonGroup;
	private JRadioButton radioButtonModificarEmpleado;
	private JRadioButton radioButtonAltaEmpleado;
	private JRadioButton radioButtonModificarProducto;
	private JRadioButton radioButtonAltaProducto;
	private int accionUsuario;
	private int radioButtonSeleccionado;
	
	// Constructor
	public DialogGerencia(){
		iniciarDialog();
	}
	
	private void iniciarDialog(){
		// Se crea el panel que se mostrará en el diálogo. Se hace uso del método iniciarDialog
		JPanel panel = crearPanelDiaolg();
		// Se crea el diálogo. Se recoge la opción elegida por el usuario
		accionUsuario = showConfirmDialog(this, panel, "Selecciona una opción", JOptionPane.OK_CANCEL_OPTION);
		// Se modifica la funcionalidad si el usuario ha hecho click en el botón de aceptar
		if(accionUsuario == OK_OPTION){
			switch(radioButtonSeleccionado){
			
			case 0: 
				// CASO SE SELECCIONA MODIFICAR EMPLEADO
				// Se abre el dialog de modificacion de empleado
				break;
			
			case 1:
				// CASO SE SELECCIONA DAR DE ALTA A UN NUEVO EMPLEADO
				// Se abre el dialog de dar de alta a un nuevo empleado
				break;
			
			case 2:
				// CASE SE SELECCIONA MODIFICAR PRODUCTO
				// Se abre el dialog de modificacion de producto
				break;
				
			case 3:
				// CASO SE SELECCIONA DAR DE ALTA UN NUEVO PRODUCTO
				// Se abre el dialog de alta de un nuevo producto
				break;
			}
		}
	}
	
	// Método para elaborar el panel
	private JPanel crearPanelDiaolg(){
		// Panel que muestra las opciones de mesa con radiobuttons
		JPanel panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
		
		// Se instancian los radiobutton y se les asigna un escuchador
		radioButtonModificarEmpleado = new JRadioButton("Modificar empleado", true);
		radioButtonModificarEmpleado.addActionListener(this);
		
		radioButtonAltaEmpleado = new JRadioButton("Dar de alta a un nuevo empleado", false);
		radioButtonAltaEmpleado.addActionListener(this);
		
		radioButtonModificarProducto = new JRadioButton("Modificar producto", false);
		radioButtonModificarProducto.addActionListener(this);
		
		radioButtonAltaProducto = new JRadioButton("Dar de alta un nuevo producto", false);
		radioButtonAltaProducto.addActionListener(this);
		
		// Se añaden los radiobutton al buttongroup
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonModificarEmpleado);
		buttonGroup.add(radioButtonAltaEmpleado);
		buttonGroup.add(radioButtonModificarProducto);
		buttonGroup.add(radioButtonAltaProducto);
		
		// Se añaden los radiobutton al panel
		panelDialog.add(radioButtonModificarEmpleado);
		panelDialog.add(radioButtonAltaEmpleado);
		panelDialog.add(radioButtonModificarProducto);
		panelDialog.add(radioButtonAltaProducto);
				
		// Retorno del método
		return panelDialog;
	}

	// Desarrollo de los métodos de la interfaz ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioButtonModificarEmpleado){
			// Caso se selecciona abrir mesa
			radioButtonSeleccionado = KEY_MODIFICAR_EMPLEADO;
		}
		else if(e.getSource() == radioButtonAltaEmpleado){
			// Caso se selecciona ver comanda
			radioButtonSeleccionado = KEY_ALTA_EMPLEADO;
		}
		else if(e.getSource() == radioButtonModificarProducto){
			// Caso se selecciona ver comanda
			radioButtonSeleccionado = KEY_MODIFICAR_PRODUCTO;
		}
		else{
			// Caso se selecciona añadir producto
			radioButtonSeleccionado = KEY_ALTA_PRODUCTO;
		}
	}
}
