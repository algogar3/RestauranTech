package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controllers.EstadoMesa;

public class DialogOpcionMesa extends JOptionPane implements ActionListener {
	// Constantes
	public static final int KEY_ABRIR_MESA = 0;
	public static final int KEY_VER_COMANDA = 1;
	public static final int KEY_ANAYDIR_PRODUCTO = 2;
	
	// Variables
	private ButtonGroup buttonGroup;
	private JRadioButton radioButtonAbrirMesa;
	private JRadioButton radioButtonVerComanda;
	private JRadioButton radioButtonAnyadirProductos;
	private int accionUsuario;
	private int radioButtonSeleccionado;
	private int idBotonMesa;
	
	// Constructor
	public DialogOpcionMesa(int idBotonMesa){
		iniciarDialog(idBotonMesa);
	}
	
	private void iniciarDialog(int idBotonMesa){
		// Se crea el panel que se mostrar� en el di�logo. Se hace uso del m�todo iniciarDialog
		JPanel panel = crearPanelDiaolg();
		// Se crea el di�logo. Se recoge la opci�n elegida por el usuario
		accionUsuario = showConfirmDialog(this, panel, "�Qu� quieres hacer la mesa " + idBotonMesa + "?", JOptionPane.OK_CANCEL_OPTION);
		// Se modifica la funcionalidad si el usuario ha hecho click en el bot�n de aceptar
		if(accionUsuario == OK_OPTION){
			switch(radioButtonSeleccionado){
			
			case 0: 
				// CASO SE SELECCIONA ABRIR MESA
				// Se comprueba que la mesa seleccionada no se encuentre ya abierta
				if(EstadoMesa.comprobarEstadoMesa(FramePrincipal.session, idBotonMesa)){
					// La mesa se encuentra abierta. Se manda mensaje de error
					new DiaologMesaAbierta(idBotonMesa);
				}
				else{
					// La mesa est� cerrada. Se continua con la operaci�n
					new DialogAbrirMesa(idBotonMesa);
				}
				break;
			
			case 1:
				// CASO SE SELECCIONA VER LA COMANDA DE UNA MESA
				// Se comprueba que la mesa seleccionada se encuentre ya abierta
				if(EstadoMesa.comprobarEstadoMesa(FramePrincipal.session, idBotonMesa)){
					// La mesa se encuentra abierta. Se continua con la operaci�n
					new DialogVerComanda(idBotonMesa);
				}
				else{
					// La mesa est� cerrada. Se manda mensaje de error
					new DialogMesaCerrada(idBotonMesa);
				}
				break;
			
			case 2:
				// CASE SE SELECCIONA A�ADIR UN PRODUCTO A LA MESA
				if(EstadoMesa.comprobarEstadoMesa(FramePrincipal.session, idBotonMesa)){
					// La mesa se encuentra abierta. Se continua con la operaci�n
					new DialogAnyadirProductos(idBotonMesa);
				}
				else{
					// La mesa est� cerrada. Se manda mensaje de error
					new DialogMesaCerrada(idBotonMesa);
				}
				break;
			}
		}
	}
	
	// M�todo para elaborar el panel
	private JPanel crearPanelDiaolg(){
		// Panel que muestra las opciones de mesa con radiobuttons
		JPanel panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
		
		// Se instancian los radiobutton y se les asigna un escuchador
		radioButtonAbrirMesa = new JRadioButton("Abrir mesa", true);
		radioButtonAbrirMesa.addActionListener(this);
		
		radioButtonVerComanda = new JRadioButton("Ver Comanda", false);
		radioButtonVerComanda.addActionListener(this);
		
		radioButtonAnyadirProductos = new JRadioButton("A�adir producto", false);
		radioButtonAnyadirProductos.addActionListener(this);
		
		// Se a�aden los radiobutton al buttongroup
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonAbrirMesa);
		buttonGroup.add(radioButtonVerComanda);
		buttonGroup.add(radioButtonAnyadirProductos);
		
		// Se a�aden los radiobutton al panel
		panelDialog.add(radioButtonAbrirMesa);
		panelDialog.add(radioButtonVerComanda);
		panelDialog.add(radioButtonAnyadirProductos);
				
		// Retorno del m�todo
		return panelDialog;
	}

	// Desarrollo de los m�todos de la interfaz ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioButtonAbrirMesa){
			// Caso se selecciona abrir mesa
			radioButtonSeleccionado = KEY_ABRIR_MESA;
		}
		else if(e.getSource() == radioButtonVerComanda){
			// Caso se selecciona ver comanda
			radioButtonSeleccionado = KEY_VER_COMANDA;
		}
		else{
			// Caso se selecciona a�adir producto
			radioButtonSeleccionado = KEY_ANAYDIR_PRODUCTO;
		}
	}
	
	
	

	
	

}
