package vista;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPad extends JPanel {
	
	// Variables de clase
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
	private JButton botonAceptar;
	private JButton botonBorrar;
	
	// Constructor
	public PanelPad(){
		iniciarPad();
		this.setVisible(true);
	}
	
	public void iniciarPad(){
		setLayout(new GridLayout(4,3));
		
		boton1 = new JButton("1");
		boton2 = new JButton("2");
		boton3 = new JButton("3");
		boton4 = new JButton("4");
		boton5 = new JButton("5");
		boton6 = new JButton("6");
		boton7 = new JButton("7");
		boton8 = new JButton("8");
		boton9 = new JButton("9");
		boton0 = new JButton("0");
		botonAceptar = new JButton();
		botonAceptar.setIcon(new ImageIcon("img/tick102.png"));
		botonBorrar = new JButton();
		botonBorrar.setIcon(new ImageIcon("img/back102.png"));
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
		add(boton5);
		add(boton6);
		add(boton7);
		add(boton8);
		add(boton9);
		add(botonAceptar);
		add(boton0);
		add(botonBorrar);
	}

}
