package excepciones;

/**
 * Excepcion que salta si el valor está fuera del rango que se le pide
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class ValorFueraRangoExcepcion extends Exception{

	public ValorFueraRangoExcepcion(String mensaje) {
		super(mensaje);
	}
	
}
