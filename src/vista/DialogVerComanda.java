package vista;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogVerComanda extends JOptionPane {
	
	// Variables
	private JPanel panelVerComanda;
	private JPanel panelCobrar;
	private JPanel panelContenedor;
	private JTextField dineroCobrado;
	private JLabel precioComanda;
	
	// Constructor
	public DialogVerComanda(){
		iniciarGUI();
		
	}
	
	private void iniciarGUI(){
		
		// Panel verComanda
		panelVerComanda = new JPanel();
		panelVerComanda.setPreferredSize(new Dimension(600,300));
		
		// Panel cobrar
		panelCobrar = new JPanel();
		dineroCobrado = new JTextField(10);
		precioComanda = new JLabel("TOTAL: ");
		panelCobrar.add(precioComanda);
		panelCobrar.add(dineroCobrado);
		
		// Panel contenedor
		panelContenedor = new JPanel();
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
		panelContenedor.add(panelVerComanda);
		panelContenedor.add(panelCobrar);
		
		showConfirmDialog(this, panelContenedor, "Comanda de la mesa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

}
