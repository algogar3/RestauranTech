package vistas;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

import controllers.Login;
import controllers.Login.OnLogeo;
import models.Empleado;

public class PanelInformacionCamarero extends JPanel implements OnLogeo{
	
	// Variables
	private JLabel etiquetaNombre;
	private JLabel etiquetaApellidos;
	private JLabel etiquetaId;
	private JLabel etiquetaPermisos;
	private JLabel campoNombre;
	private JLabel campoApellidos;
	private JLabel campoId;
	private JLabel campoPermisos;
	private Login log;
	
	// Constructor
	public PanelInformacionCamarero(){
		iniciarGUI();
		this.setVisible(true);
		setLayout(new GridLayout(4,4));
	}
	
	// Método iniciarGUI()
	private void iniciarGUI(){
		
		// Instanciación de los omponenetes del panel 
		etiquetaNombre = new JLabel("Nombre: ");
		etiquetaApellidos = new JLabel("Apellidos: ");
		etiquetaId = new JLabel("Id: ");
		etiquetaPermisos = new JLabel("Gerente: ");
		
		campoNombre = new JLabel("");
		campoApellidos = new JLabel("");
		campoId = new JLabel("");
		campoPermisos = new JLabel("");
		
		// Formato de las etiquetas
		etiquetaNombre.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		etiquetaApellidos.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		etiquetaId.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		etiquetaPermisos.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		campoNombre.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		campoApellidos.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		campoId.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		campoPermisos.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO));
		
		// Escuchador de la interfaz
		log = new Login();
		log.setOnLogeo(this);
		
		// Se añaden los componentes al panel
		add(etiquetaNombre);
		add(campoNombre);
		add(etiquetaApellidos);
		add(campoApellidos);
		add(etiquetaId);
		add(campoId);
		add(etiquetaPermisos);
		add(campoPermisos);
	}

	// Desarrollo de los métodos de la interfaz OnLogeo
	@Override
	public void usuarioLogeado(Empleado empleado) {
		campoNombre.setText(empleado.getNombre());
		campoApellidos.setText(empleado.getApellidos());
		campoId.setText(String.valueOf(empleado.getIdEmpleado()));
		campoPermisos.setText(String.valueOf(empleado.isPermisos()));
	}
}
