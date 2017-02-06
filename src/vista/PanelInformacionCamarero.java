package vista;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacionCamarero extends JPanel {
	
	// Variables
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaId;
	private JLabel etiquetaPermisos;
	
	// Constructor
	public PanelInformacionCamarero(){
		iniciarGUI();
		this.setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	private void iniciarGUI(){
		
		// Labels
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaApellidos = new JLabel("Apellidos: ");
		etiquetaId = new JLabel("Id: ");
		etiquetaPermisos = new JLabel("Permisos: ");
		
		add(etiquetaNombre);
		add(etiquetaApellidos);
		add(etiquetaId);
		add(etiquetaPermisos);
		
	}

	
}
