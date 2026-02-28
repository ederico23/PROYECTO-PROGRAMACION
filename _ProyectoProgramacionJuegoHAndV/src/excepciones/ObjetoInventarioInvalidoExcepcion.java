package excepciones;

/**
 * Excepcion que salta si el objeto del inventario no existe
 * 
 * @author Mariano, Eder
 * @version 1.0
 */

public class ObjetoInventarioInvalidoExcepcion extends Exception{
	
	public ObjetoInventarioInvalidoExcepcion(String mensaje) {
		super(mensaje);
	}
}
