package vistas;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class DialogLogin extends JOptionPane implements OnBotonPulsado, KeyListener{
	
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
	
	// Método iniciarGUI()
	private void iniciarGUI(){
		
		// Instanciación del panelLogin
		panelLogin = new JPanel();
		
		// Declaración de los elementos del panelLogin
		textoPassword = new JLabel("Password");
		campoPassword = new JPasswordField(10); // ojo dimensiones del campo contraseña en la base de datos
		campoPassword.addKeyListener(this);
		
		
		// Se introducen los elementos en el panelLogin
		panelLogin.add(textoPassword);
		panelLogin.add(campoPassword);
		
		// Instanciación del panelPad
		panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this);
		
		// Instanciación del panelContenedor e introducción de su contenido
		panelContenedor = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelLogin, panelPad);
		
		// Instanciación del diálogo
		confirmacionUsuario = showConfirmDialog(this, panelContenedor, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		// Llamada al método para preparar los datos de id y password
		prepararDatosLogin();
		
		// Llamada al controlador para que compruebe los datos
		// El controlador devuelve el empleado si existen coincidencias, o null en caso contrario
		empleado = Login.comprobarLogin(FramePrincipal.session, String.valueOf(password));
	}
	
	// Método prepararDatosLogin()
	private void prepararDatosLogin(){
		if(confirmacionUsuario == JOptionPane.OK_OPTION){
			password = campoPassword.getPassword();
		}
	}

	// Desarrollo de los métodos de la interfaz OnBotonPulsado
	@Override
	public void botonPulsado(String buffer) {
		// TODO Auto-generated method stub
		campoPassword.setText(buffer);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
	      if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	         e.consume();  // ignore event
	      }
	}
}
