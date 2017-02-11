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
	public static final int KEY_GESTIONAR_EMPLEADO = 0;
	public static final int KEY_GESTIONAR_PRODUCTO = 1;
	
	// Variables
	private ButtonGroup buttonGroup;
	private JRadioButton radioButtonGestionarEmpleado;
	private JRadioButton radioButtonGestionarProducto;
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
				// CASO SE SELECCIONA GESTIONAR EMPLEADO
				// Se abre el dialog de gestión de empleado
				new DialogGestionarEmpleado();
				break;
			
			case 1:
				// CASE SE SELECCIONA GESTIONAR PRODUCTO
				// Se abre el dialog de gestión de producto
				new DialogGestionarProducto();
				break;
			}
		}
	}
	
	// Método para elaborar el panel
	private JPanel crearPanelDiaolg(){
		// Panel que muestra las opciones del menú de gerencia con radiobuttons
		JPanel panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
		
		// Se instancian los radiobutton y se les asigna un escuchador
		radioButtonGestionarEmpleado = new JRadioButton("Gestión empleados", true);
		radioButtonGestionarEmpleado.addActionListener(this);
		
		radioButtonGestionarProducto = new JRadioButton("Gestión productos", false);
		radioButtonGestionarProducto.addActionListener(this);
		
		// Se añaden los radiobutton al buttongroup
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonGestionarEmpleado);
		buttonGroup.add(radioButtonGestionarProducto);
		
		// Se añaden los radiobutton al panel
		panelDialog.add(radioButtonGestionarEmpleado);
		panelDialog.add(radioButtonGestionarProducto);
				
		// Retorno del método
		return panelDialog;
	}

	// Desarrollo de los métodos de la interfaz ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioButtonGestionarEmpleado){
			// Caso se selecciona gestionar empleado
			radioButtonSeleccionado = KEY_GESTIONAR_EMPLEADO;
		}
		else {
			// Caso se selecciona gestionar producto
			radioButtonSeleccionado = KEY_GESTIONAR_PRODUCTO;
		}
	}
}
