package vista;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacionCamarero extends JPanel {
	
	// Variables
	private JPanel panelContenedor;
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaId;
	private JLabel etiquetaPermisos;
	
	// Constructor
	public PanelInformacionCamarero(){
		iniciarGUI();
	}
	
	private void iniciarGUI(){
		// Panel
		panelContenedor = new JPanel();
		panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));
		
		// Labels
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaNombre = new JLabel("Apellidos: ");
		etiquetaNombre = new JLabel("Id: ");
		etiquetaNombre = new JLabel("Permisos: ");
		
	}

	
}
