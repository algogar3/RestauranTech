package vistas;

import javax.swing.JOptionPane;

public class DialogPermisos extends JOptionPane{
	
	// Constructor
	public DialogPermisos(){
		iniciarGUI();
	}
	
	// M�todo iniciarGUI()
	private void iniciarGUI(){
		showConfirmDialog(this, "No tienes los permisos necesarios!!", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null);
	}

}
