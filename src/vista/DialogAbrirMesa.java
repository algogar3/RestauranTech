package vista;

import javax.swing.JOptionPane;

public class DialogAbrirMesa extends JOptionPane {
	
	// Constructor
	public DialogAbrirMesa(){
		iniciarDialogAbrirMesa();
	}
	
	private void iniciarDialogAbrirMesa(){
		showInputDialog(this, "¿Número de comensales?", "Abrir mesa", JOptionPane.INFORMATION_MESSAGE);
	}
}
