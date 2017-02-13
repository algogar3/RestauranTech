package vistas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controllers.ControladorCobrosYFacturacion;
import vistas.PanelPad.OnBotonPulsado;

public class DialogVerComanda extends JOptionPane implements OnBotonPulsado, ActionListener{
	
	// Variables
	private JScrollPane panelVerComanda;
	private JPanel panelCobrar;
	private JPanel panelCantidadEntregada;
	private JPanel panelContenedorIquierdo;
	private PanelPad panelPad; 
	private JPanel panelContenedorGlobal;
	private JLabel importe;
	private JLabel textoCantidadEntregada;
	private JTextField cantidadEntregada;
	private JLabel cambio;
	private JButton botonCobrar;
	
	// Constructor
	public DialogVerComanda(int idBotonMesa){
		iniciarGUI(idBotonMesa);
	}
	
	// Método iniciarGUI
	private void iniciarGUI(int idBotonMesa){
		
		// Panel verComanda
		panelVerComanda = new JScrollPane();
		panelVerComanda.setPreferredSize(new Dimension(600,400));
		
		
		// Panel cobrar
		panelCobrar = new JPanel();
		panelCobrar.setLayout(new BoxLayout(panelCobrar, BoxLayout.Y_AXIS));
		
		// Componentes del panel cobrar
		importe = new JLabel("Total mesa: 0,00€");
		panelCobrar.add(importe);
		// Subpanel cantidad entregada
		panelCantidadEntregada = new JPanel();
		panelCantidadEntregada.setLayout(new BoxLayout(panelCantidadEntregada, BoxLayout.X_AXIS));
		textoCantidadEntregada = new JLabel("Cantidad entregada: ");
		cantidadEntregada = new JTextField(10);
		botonCobrar = new JButton("Cobrar");
		botonCobrar.addActionListener(this);
		
		panelCantidadEntregada.add(textoCantidadEntregada);
		panelCantidadEntregada.add(cantidadEntregada);
		panelCantidadEntregada.add(botonCobrar);
		panelCobrar.add(panelCantidadEntregada);		
		
		cambio = new JLabel("Importe a devolver: 0,00€");
		panelCobrar.add(cambio);
		
		// Panel contenedor iquierdo
		panelContenedorIquierdo = new JPanel();
		panelContenedorIquierdo.setLayout(new BoxLayout(panelContenedorIquierdo, BoxLayout.Y_AXIS));
		panelContenedorIquierdo.add(panelVerComanda);
		panelContenedorIquierdo.add(panelCobrar);
		
		// Panel pad
		panelPad = new PanelPad();
		panelPad.setOnBotonPulsadoListener(this); // Escuchador de la interfaz OnBotonPulsado
		
		// Panel contenedor global
		panelContenedorGlobal = new JPanel();
		panelContenedorGlobal.setLayout(new BoxLayout(panelContenedorGlobal, BoxLayout.X_AXIS));
		panelContenedorGlobal.add(panelContenedorIquierdo);
		panelContenedorGlobal.add(panelPad);
		
		// Diálogo de confirmación
		showConfirmDialog(this, panelContenedorGlobal, "Comanda de la mesa " + idBotonMesa, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	}

	// Desarrollo de los métodos de la interfaz OnBotonPulsado
	@Override
	public void botonPulsado(String buffer) {
		// Actualización del JTextField
		cantidadEntregada.setText(buffer);
	}

	
	// Desarrollo de los métodos de la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		// Llamada al controlador de cobros para acutalizar el JTextField que muestra el cambio a devolver
		//cambio.setText(ControladorCobrosYFacturacion.obtenerCambio(gastoMesa, cantidadEntregada.getText()));
		
		// Llamada al controlador de cobros para registrar la facturación y cerrar la mesa
		//ControladorCobrosYFacturacion.insertarFacturacion(FramePrincipal.session, servicio);
	}

	



}
