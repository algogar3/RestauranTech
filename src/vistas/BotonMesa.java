package vistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotonMesa extends JButton implements ActionListener{
	
	// Atributos
	private int idBotonMesa;

	// Constructor
	public BotonMesa(){
		iniciarBotonMesa();
	}
	
	// Setters y Getters
	public int getIdBotonMesa() {
		return idBotonMesa;
	}

	public void setIdBotonMesa(int idBotonMesa) {
		this.idBotonMesa = idBotonMesa;
	}
	
	// M�todo iniciarBoton
	public void iniciarBotonMesa(){
		setIcon(new ImageIcon("img/mesa256.png"));
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);
		
		// Escuchadores
		addActionListener(this);
	}

	// Desarrollo de los m�todos de la interfaz ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Se captura el objeto (BotonMesa) que di� lugar al evento
		BotonMesa boton = (BotonMesa) e.getSource();
		// Se recoge el id de la mesa, que viene dada como atriburo del objeto BotonMesa
		int idBotonMesa = boton.getIdBotonMesa();
		// Se muestra un men� con las posibles opciones
		new DialogOpcionMesa(idBotonMesa);
	}
}
