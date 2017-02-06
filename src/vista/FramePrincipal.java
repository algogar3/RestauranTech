package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

public class FramePrincipal extends JFrame {

	public void iniciarGUI(){
		// MenuBar
		setJMenuBar(new MenuBar());
		// Panel Iquierdo
		PanelIzquierdo panelIzquierdo = new PanelIzquierdo();
		
		// Panel Logo
		PanelLogo panelLogo = new PanelLogo();
		//JScrollPane scroll = new JScrollPane(panelLogo);
		
		// Panel Pad
		PanelInformacionCamarero panelInfoCamarero = new PanelInformacionCamarero();
		
		// Panel base que contiene otros 3 paneles
		JSplitPane splitPaneDerecho = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelLogo, panelInfoCamarero);
		splitPaneDerecho.setResizeWeight(0.5);
		splitPaneDerecho.setEnabled(false);
		
		
		
		// Panel base que contiene otros 3 paneles
		JSplitPane splitPanelPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, splitPaneDerecho);
		splitPanelPrincipal.setEnabled(true);
		splitPanelPrincipal.setResizeWeight(0.7);
		getContentPane().add(splitPanelPrincipal);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	// Constructor
	public FramePrincipal(){
		super("RESTAURANTECH");
		iniciarGUI();
	}
	
	public static void main(String[] args){
		new FramePrincipal();
	}

}
