package vistas;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.Login;
import models.Empleado;

public class DialogLogin extends JOptionPane{
	
	// Variables
	private JPanel panel;
	private JLabel textoId;
	private JLabel textoPassword;
	private JTextField campoId;
	private JPasswordField campoPassword;
	private String id;
	private char[] password;
	private int confirmacionUsuario;
	private static Empleado empleado;
	
	// Constructor
	public DialogLogin(){
		iniciarGUI();
	}
	
	// Getters and setters
	public static Empleado getEmpleado() {
		return empleado;
	}

	public static void setEmpleado(Empleado empleado) {
		DialogLogin.empleado = empleado;
	}
	
	// M�todo iniciarGUI()
	private void iniciarGUI(){
		// Instanciaci�n del panel
		panel = new JPanel(new GridLayout(2,2));
		
		// Declaraci�n de los elementos del panel
		textoId = new JLabel("ID usuario");
		textoPassword = new JLabel("Password");
		campoId = new JTextField(10); // ojo dimensiones del campo contrase�a en la base de datos
		campoPassword = new JPasswordField(10); // ojo dimensiones del campo contrase�a en la base de datos
		
		// Se introducen los elementos en el panel
		panel.add(textoId);
		panel.add(campoId);
		panel.add(textoPassword);
		panel.add(campoPassword);
		
		// Instanciaci�n del di�logo
		confirmacionUsuario = showConfirmDialog(this, panel, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		// Llamada al m�todo para preparar los datos de id y password
		prepararDatosLogin();
		
		// Llamada al controlador para que compruebe los datos
		// El controlador devuelve el empleado si existen coincidencias, o null en caso contrario
		empleado = Login.comprobarLogin(FramePrincipal.session, id, String.valueOf(password));
		// Comprobaci�n del objeto devuelto por el controlador
		if(empleado != null){
			// Se ha encontrado una coincidencia. El login es correcto
			// Lanzar Dialog de bienvenida (hacer)
			// �Interfaz para avisar a PanelInformacionCamarero de que se ha hecho login?
		}
		else{
			// El login no es correcto, se lanza un di�logo con un mensaje de error (hacer)
			// Se vuelve a lanzar el di�ologo de login
		}
	}
	
	// M�todo prepararDatosLogin()
	private void prepararDatosLogin(){
		if(confirmacionUsuario == JOptionPane.OK_OPTION){
			id = campoId.getText();
			password = campoPassword.getPassword();
			System.out.println(id);
			System.out.println(password);
		}
	}
}
