package vistas;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import controllers.Login;
import models.Empleado;
import vistas.PanelPad.OnBotonPulsado;

public class DialogLogin extends JOptionPane implements OnBotonPulsado{
	
	// Variables
	private JSplitPane panelContenedor;
	private JPanel panelLogin;
	private PanelPad panelPad;
	private JLabel textoPassword;
	private JPasswordField campoPassword;
	private char[] password = {' '};
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
		
		// Instanciaci�n del panelLogin
		panelLogin = new JPanel();
		
		// Declaraci�n de los elementos del panelLogin

		textoPassword = new JLabel("Password");
		campoPassword = new JPasswordField(10); // ojo dimensiones del campo contrase�a en la base de datos
		
		// Se introducen los elementos en el panelLogin
		panelLogin.add(textoPassword);
		panelLogin.add(campoPassword);
		
		// Instanciaci�n del panelPad
		panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciaci�n del panelContenedor e introducci�n de su contenido
		panelContenedor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelLogin, panelPad);
		
		// Instanciaci�n del di�logo
		confirmacionUsuario = showConfirmDialog(this, panelContenedor, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		// Llamada al m�todo para preparar los datos de id y password
		prepararDatosLogin();
		
		// Llamada al controlador para que compruebe los datos
		// El controlador devuelve el empleado si existen coincidencias, o null en caso contrario
		empleado = Login.comprobarLogin(FramePrincipal.session, String.valueOf(password));
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
			password = campoPassword.getPassword();
		}
	}

	// Desarrollo de los m�todos de la interfaz OnBotonPulsado
	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		campoPassword.setText(buffer);
	}
}
