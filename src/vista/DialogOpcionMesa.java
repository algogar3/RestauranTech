package vista;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DialogOpcionMesa extends JOptionPane {
	// Variables
	private ButtonGroup buttonGroup;
	private JRadioButton radioButtonAbrirMesa;
	private JRadioButton radioButtonVerComanda;
	private JRadioButton radioButtonAnyadirProductos;
	
	// Constructor
	public DialogOpcionMesa(){
		iniciarDialog();
	}
	
	private void iniciarDialog(){
		JPanel panel = crearPanelDiaolg();
		showConfirmDialog(this, panel, "¿Qué quieres hacer con esta mesa?", JOptionPane.OK_CANCEL_OPTION);
	}
	
	// Método para elaborar el panel
	private JPanel crearPanelDiaolg(){
		// Panel que muestra las opciones de mesa con radiobuttons
		JPanel panelDialog = new JPanel();
		panelDialog.setLayout(new BoxLayout(panelDialog, BoxLayout.Y_AXIS));
		
		// Se instancian los radiobutton
		radioButtonAbrirMesa = new JRadioButton("Abrir mesa", true);
		radioButtonVerComanda = new JRadioButton("Ver Comanda", false);
		radioButtonAnyadirProductos = new JRadioButton("Añadir producto", false);
		
		// Se añaden los radiobutton al buttongroup
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButtonAbrirMesa);
		buttonGroup.add(radioButtonVerComanda);
		buttonGroup.add(radioButtonAnyadirProductos);
		
		// Se añaden los radiobutton al panel
		panelDialog.add(radioButtonAbrirMesa);
		panelDialog.add(radioButtonVerComanda);
		panelDialog.add(radioButtonAnyadirProductos);
		
		// Retorno del método
		return panelDialog;
	}
	
	
	

	
	

}
