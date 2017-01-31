package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonMesa extends JButton implements ActionListener{
	
	// Constructor
	public BotonMesa(){
		iniciarBotonMesa();
	}
	
	public void iniciarBotonMesa(){
		setIcon(new ImageIcon("img/mesa256.png"));
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		
		addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.print("Boton click");
	}
	
	

}