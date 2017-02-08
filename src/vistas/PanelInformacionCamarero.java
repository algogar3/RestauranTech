package vistas;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInformacionCamarero extends JPanel {
	
	// Variables
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaId;
	private JLabel etiquetaPermisos;
	private JLabel campoNombre;
	private JLabel campoApellidos;
	private JLabel campoId;
	private JLabel campoPermisos;
	
	// Constructor
	public PanelInformacionCamarero(){
		iniciarGUI();
		this.setVisible(true);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	// Método iniciarGUI()
	private void iniciarGUI(){
		
		// Instanciación de los omponenetes del panel 
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaApellidos = new JLabel("Apellidos: ");
		etiquetaId = new JLabel("Id: ");
		etiquetaPermisos = new JLabel("Permisos: ");
		
		/*
		// Se introducen los valores del usuario
		campoNombre.setText(DialogLogin.getEmpleado().getNombre());
		campoApellidos.setText(DialogLogin.getEmpleado().getApellidos());
		campoId.setText(String.valueOf(DialogLogin.getEmpleado().getIdEmpleado()));
		campoPermisos.setText(String.valueOf(DialogLogin.getEmpleado().isPermisos()));
		*/
		
		// Se añaden los componentes al panel
		add(etiquetaNombre);
		add(etiquetaApellidos);
		add(etiquetaId);
		add(etiquetaPermisos);
		
	}

	
}
