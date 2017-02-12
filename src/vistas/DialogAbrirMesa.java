package vistas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import vistas.PanelPad.OnBotonPulsado;

public class DialogAbrirMesa extends JOptionPane implements OnBotonPulsado, KeyListener{
	
	// Variables
	private JSplitPane panelContenedor;
	private JPanel panelTextField;
	private JTextField textFieldNumeroPersonas;
	private JLabel etiquetaCantidad;
	
	// Constructor
	public DialogAbrirMesa(int idBotonMesa){
		iniciarDialogAbrirMesa(idBotonMesa);
	}
	
	// Mëtodo iniciarDialogAbrirMesa
	private void iniciarDialogAbrirMesa(int idBotonMesa){
		// Instanciación del panel Pad y suscripción a la interfaz OnBotonPulsado
		PanelPad panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciación del panel TextField e introducción de sus elementos
		panelTextField = new JPanel();
		textFieldNumeroPersonas = new JTextField(10);
		textFieldNumeroPersonas.addKeyListener(this);
		etiquetaCantidad = new JLabel("¿Número de comensales?");
		panelTextField.add(etiquetaCantidad);
		panelTextField.add(textFieldNumeroPersonas);
		
		// Instanciación del panel Contenedor, que contiene los 2 paneles anteriores
		panelContenedor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTextField, panelPad);
		
		// Instanciaciónd del diálogo
		showConfirmDialog(this, panelContenedor, "Abrir mesa " + idBotonMesa, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	// Desarrollo de los métodos de la interfaz OnBotonPulsado
	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		textFieldNumeroPersonas.setText(buffer);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
	      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	         e.consume();  // ignore event
	      }
	}
}
