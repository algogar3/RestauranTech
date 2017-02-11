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
		// Se crea el panel que se mostrar� en el di�logo. Se hace uso del m�todo iniciarDialog
		JPanel panel = crearPanelDiaolg();
		// Se crea el di�logo. Se recoge la opci�n elegida por el usuario
		accionUsuario = showConfirmDialog(this, panel, "Selecciona una opci�n", JOptionPane.OK_CANCEL_OPTION);
		// Se modifica la funcionalidad si el usuario ha hecho click en el bot�n de aceptar
		if(accionUsuario == OK_OPTION){
			switch(radioButtonSeleccionado){
			
			case 0: 
				// CASO SE SELECCIONA GESTIONAR EMPLEADO
				// Se abre el dialog de gesti�n de empleado
				new DialogGestionarEmpleado();
				break;
			
			case 1:
				// CASE SE SELECCIONA GESTIONAR PRODUCTO
				// Se abre el dialog de gesti�n de producto
				new DialogGestionarProducto();
				break;
			}
		}
	}
	
	// M�todo para elaborar el panel
	private JPanel crearPanelDiaolg(){
		// Panel que muestra las opciones del men� de gerencia con radiobuttons
		JPanel panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
		
		// Se instancian los radiobutton y se les asigna un escuchador
		radioButtonGestionarEmpleado = new JRadioButton("Gesti�n empleados", true);
		radioButtonGestionarEmpleado.addActionListener(this);
		
		radioButtonGestionarProducto = new JRadioButton("Gesti�n productos", false);
		radioButtonGestionarProducto.addActionListener(this);
		
		// Se a�aden los radiobutton al buttongroup
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonGestionarEmpleado);
		buttonGroup.add(radioButtonGestionarProducto);
		
		// Se a�aden los radiobutton al panel
		panelDialog.add(radioButtonGestionarEmpleado);
		panelDialog.add(radioButtonGestionarProducto);
				
		// Retorno del m�todo
		return panelDialog;
	}

	// Desarrollo de los m�todos de la interfaz ActionPerformed
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
