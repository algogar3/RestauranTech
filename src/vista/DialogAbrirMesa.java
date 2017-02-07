package vista;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import vista.PanelPad.OnBotonPulsado;

public class DialogAbrirMesa extends JOptionPane implements OnBotonPulsado{
	
	// Variables
	private JSplitPane panelDivisor;
	private JPanel panelTextField;
	private JTextField textFieldNumeroPersonas;
	private JLabel etiquetaCantidad;
	
	// Constructor
	public DialogAbrirMesa(){
		iniciarDialogAbrirMesa();
	}
	
	private void iniciarDialogAbrirMesa(){
		PanelPad panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		panelTextField = new JPanel();
		textFieldNumeroPersonas = new JTextField(10);
		etiquetaCantidad = new JLabel("¿Número de comensales?");
		panelTextField.add(etiquetaCantidad);
		panelTextField.add(textFieldNumeroPersonas);
		
		panelDivisor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTextField, panelPad);
		
		
		showConfirmDialog(this, panelDivisor, "Abrir mesa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		
		
	}

	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		textFieldNumeroPersonas.setText(buffer);
	}
}
