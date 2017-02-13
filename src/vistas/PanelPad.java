package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPad extends JPanel implements ActionListener {
	
	// Variables
	private JButton boton1;
	private JButton boton2;
	private JButton boton3;
	private JButton boton4;
	private JButton boton5;
	private JButton boton6;
	private JButton boton7;
	private JButton boton8;
	private JButton boton9;
	private JButton boton0;
	private JButton botonDecimal;
	private JButton botonBorrar;
	private String buffer;
	private OnBotonPulsado escuchador;
	private HashMap<JButton, String> mapBotones;
	
	// Constructor
	public PanelPad(){
		iniciarPad();
	}
	
	// Método iniciarPad
	public void iniciarPad(){
		// Definición del layout
		setLayout(new GridLayout(4,3));
		
		// Instanciación del HashMap
		mapBotones = new HashMap<JButton, String>();
		
		// Instanciación de los botones. Suscripción como escuchadores de la interfaz ActionListener
		boton1 = new JButton("1");
		boton1.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton1.addActionListener(this);
		mapBotones.put(boton1, "boton1");
		
		boton2 = new JButton("2");
		boton2.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton2.addActionListener(this);
		mapBotones.put(boton2, "boton2");
		
		boton3 = new JButton("3");
		boton3.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton3.addActionListener(this);
		mapBotones.put(boton3, "boton3");
		
		boton4 = new JButton("4");
		boton4.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton4.addActionListener(this);
		mapBotones.put(boton4, "boton4");
		
		boton5 = new JButton("5");
		boton5.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton5.addActionListener(this);
		mapBotones.put(boton5, "boton5");
		
		boton6 = new JButton("6");
		boton6.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton6.addActionListener(this);
		mapBotones.put(boton6, "boton6");
		
		boton7 = new JButton("7");
		boton7.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton7.addActionListener(this);
		mapBotones.put(boton7, "boton7");
		
		boton8 = new JButton("8");
		boton8.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton8.addActionListener(this);
		mapBotones.put(boton8, "boton8");
		
		boton9 = new JButton("9");
		boton9.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton9.addActionListener(this);
		mapBotones.put(boton9, "boton9");
		
		boton0 = new JButton("0");
		boton0.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		boton0.addActionListener(this);
		mapBotones.put(boton0, "boton0");
		
		botonDecimal = new JButton(".");
		botonDecimal.setFont(new java.awt.Font(Fuente.FUENTE_ARIAL, Fuente.ESTILO_NORMAL, Fuente.TAMANYO_BTN_PAD));
		botonDecimal.addActionListener(this);
		mapBotones.put(botonDecimal, "botonDecimal");
		
		botonBorrar = new JButton();
		botonBorrar.setIcon(new ImageIcon("img/back102.png"));
		botonBorrar.addActionListener(this);
		mapBotones.put(botonBorrar, "botonBorrar");;
		
		// Buffer del teclado.
		// Se inicializa a una cadena vacía para cada objeto de la clase instanciado
		buffer = "";
		
		// Se añaden los botones al panel
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		add(boton7);
		add(boton8);
		add(boton9);
		add(botonDecimal);
		add(boton0);
		add(botonBorrar);
	}

	// Acciones de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(mapBotones.get(e.getSource())){
		case "boton1": 
			actualizarBuffer("1");
			escuchador.botonPulsado(buffer);
			break;
		case "boton2": 
			actualizarBuffer("2");
			escuchador.botonPulsado(buffer);
			break;
		case "boton3": 
			actualizarBuffer("3");
			escuchador.botonPulsado(buffer);
			break;
		case "boton4": 
			actualizarBuffer("4");
			escuchador.botonPulsado(buffer);
			break;
		case "boton5": 
			actualizarBuffer("5");
			escuchador.botonPulsado(buffer);
			break;
		case "boton6": 
			actualizarBuffer("6");
			escuchador.botonPulsado(buffer);
			break;
		case "boton7": 
			actualizarBuffer("7");
			escuchador.botonPulsado(buffer);
			break;
		case "boton8": 
			actualizarBuffer("8");
			escuchador.botonPulsado(buffer);
			break;
		case "boton9": 
			actualizarBuffer("9");
			escuchador.botonPulsado(buffer);
			break;
		case "boton0": 
			actualizarBuffer("0");
			escuchador.botonPulsado(buffer);
			break;
		case "botonDecimal":
			actualizarBuffer(".");
			escuchador.botonPulsado(buffer);
			break;
		case "botonBorrar":
			buffer="";
			escuchador.botonPulsado(buffer);
		}
		
	}
	
	// Método actualizarBuffer
	public String actualizarBuffer(String digito){
		return buffer += digito;
	}
	
	// Interfaz OnBotonPulsado
	public interface OnBotonPulsado{
		public void botonPulsado(String buffer);
	}
	
	// Método de suscripción a la interfaz
	public void setOnBotonPulsadoListener(OnBotonPulsado escuchador){
		this.escuchador = escuchador;
	}
}
