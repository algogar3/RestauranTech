/*
 * Controlador para obtener un tipo de producto a partir
 * de un índice de una lista desplegable (JComboBox). El 
 * controlador permite también hacer el proceso inverso 
 * (obtener un índice de la lista a partir de un tipo de 
 * producto)
 * */

package controllers;

public class ControladorTipoProducto {
	
	// Constantes
	private static final int KEY_COMIDA = 0;
	private static final int KEY_BEBIDA = 1;
	private static final int KEY_POSTRE = 2;
	
	// Método obtenerTipoProducto
	public static String obtenerTipoProducto(int clave){
		String tipoProducto = "";
		switch(clave){
			case KEY_COMIDA: tipoProducto = "comida"; break;	
			case KEY_BEBIDA: tipoProducto = "bebida"; break;	
			default: tipoProducto = "postre"; break;	
		}
		return tipoProducto;
	}
	
	// Método obtenerIndiceTipoProducto()
	public static int obtenerIndiceTipoProducto(String tipoProducto){
		if(tipoProducto.equals("comida")){
			return KEY_COMIDA;
		}
		else if(tipoProducto.equals("bebida")){
			return KEY_BEBIDA;
		}
		return KEY_POSTRE;
	}	
}
