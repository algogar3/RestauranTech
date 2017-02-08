package vistas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import vistas.PanelPad.OnBotonPulsado;

public class DialogAbrirMesa extends JOptionPane implements OnBotonPulsado{
	
	// Variables
	private JSplitPane panelContenedor;
	private JPanel panelTextField;
	private JTextField textFieldNumeroPersonas;
	private JLabel etiquetaCantidad;
	
	// Constructor
	public DialogAbrirMesa(int idBotonMesa){
		iniciarDialogAbrirMesa(idBotonMesa);
	}
	
	// M�todo iniciarDialogAbrirMesa
	private void iniciarDialogAbrirMesa(int idBotonMesa){
		// Instanciaci�n del panel Pad y suscripci�n a la interfaz OnBotonPulsado
		PanelPad panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciaci�n del panel TextField e introducci�n de sus elementos
		panelTextField = new JPanel();
		textFieldNumeroPersonas = new JTextField(10);
		etiquetaCantidad = new JLabel("�N�mero de comensales?");
		panelTextField.add(etiquetaCantidad);
		panelTextField.add(textFieldNumeroPersonas);
		
		// Instanciaci�n del panel Contenedor, que contiene los 2 paneles anteriores
		panelContenedor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTextField, panelPad);
		
		// Instanciaci�nd del di�logo
		showConfirmDialog(this, panelContenedor, "Abrir mesa " + idBotonMesa, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	// Desarrollo de los m�todos de la interfaz OnBotonPulsado
	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		textFieldNumeroPersonas.setText(buffer);
	}
}