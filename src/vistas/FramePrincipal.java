package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import models.SessionFactoryUtil;
import javax.swing.JSplitPane;

public class FramePrincipal extends JFrame {
	
	// Variables
	public static SessionFactory sessionFactory;
	public static Session session;
	private ImageIcon icono;
	
	// Constructor
		public FramePrincipal(){
			// Título de la ventana
			super("RESTAURANTECH");
			
			// Llamada al método iniciarGUI()
			iniciarGUI();
		}

	public void iniciarGUI(){
		// MenuBar
		setJMenuBar(new MenuBar());
		// Panel Iquierdo
		PanelIzquierdo panelIzquierdo = new PanelIzquierdo();
		
		// Panel Logo
		PanelLogo panelLogo = new PanelLogo();
		
		// Panel Pad
		PanelInformacionCamarero panelInfoCamarero = new PanelInformacionCamarero();
		
		// Panel base que contiene otros 3 paneles
		JSplitPane splitPaneDerecho = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelLogo, panelInfoCamarero);
		splitPaneDerecho.setEnabled(false);
		
		// Panel base que contiene otros 3 paneles
		JSplitPane splitPanelPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, splitPaneDerecho);
		splitPanelPrincipal.setEnabled(true);
		splitPanelPrincipal.setResizeWeight(0.7);
		getContentPane().add(splitPanelPrincipal);
		
		// Ponemos el icono a nuestro frame
		icono = new ImageIcon("img/icon.png");
		setIconImage(icono.getImage());
		
		// Configuraciones de la ventana
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args){
		sessionFactory = SessionFactoryUtil.getSessionFactory();
		session = sessionFactory.openSession();
		new FramePrincipal();
	}

}
