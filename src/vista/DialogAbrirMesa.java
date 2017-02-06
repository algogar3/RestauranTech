package vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class DialogAbrirMesa extends JOptionPane {
	
	// Variables
	private JSplitPane panelDivisor;
	private JPanel panelTextField;
	private JTextField textFieldNumeroPersonas;
	
	// Constructor
	public DialogAbrirMesa(){
		iniciarDialogAbrirMesa();
	}
	
	private void iniciarDialogAbrirMesa(){
		PanelPad panelPad = new PanelPad();
		
		panelTextField = new JPanel();
		textFieldNumeroPersonas = new JTextField(10);
		panelTextField.add(textFieldNumeroPersonas);
		
		panelDivisor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTextField, panelPad);
		
		
		showConfirmDialog(this, panelDivisor, "¿Número de comensales?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		
		
	}
}
