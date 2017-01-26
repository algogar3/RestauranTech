package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;

public class FramePrincipal extends JFrame {

	public void iniciarGUI(){
		// Panel Iquierda
		JPanel panelIzquierdo = new JPanel();
		
		// Panel Logo
		JPanel panelLogo = new JPanel();
		panelLogo.add(new PanelLogo());
		
		
		// Panel Pad
		JPanel panelPad = new JPanel();
		panelPad.add(new PanelPad());
		
		// Panel base que contiene otros 3 paneles
		JSplitPane splitPaneDerecho = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelLogo, panelPad);
		splitPaneDerecho.setResizeWeight(0.5);
		splitPaneDerecho.setEnabled(false);
		
		
		// Panel base que contiene otros 3 paneles
		JSplitPane splitPanelPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzquierdo, splitPaneDerecho);
		splitPanelPrincipal.setResizeWeight(0.7);
		getContentPane().add(splitPanelPrincipal);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		//pack();
	}
	
	// Constructor
	public FramePrincipal(){
		iniciarGUI();
	}
	
	public static void main(String[] args){
		new FramePrincipal();
	}

}
