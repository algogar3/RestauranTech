/*
 * Controlador para obtener un booleano a partir de una 
 * variable tinyint (MySQL), que puede tomar valores de 
 * bien 0 ó bien 1. El controlador permite también hacer 
 * el proceso inverso (obtener un tinyint a partir de un 
 * booleano)
 * */

package controllers;

public class ControladorPermisos {
	
	// Constantes
	private static final int KEY_TINYINT_FALSE = 0;
	private static final int KEY_TINYINT_TRUE = 1;
	
	// Método obtenerBooleano
	public static boolean obtenerBooleano(int tinyint){
		if(tinyint == KEY_TINYINT_FALSE){
			return false;
		}
		return true;
	}
	
	// Método obtenerTyniint()
	public static int obtenerTinyint(boolean esGerente){
		if(esGerente){
			return KEY_TINYINT_TRUE;
		}
		return KEY_TINYINT_FALSE;
	}	
}
