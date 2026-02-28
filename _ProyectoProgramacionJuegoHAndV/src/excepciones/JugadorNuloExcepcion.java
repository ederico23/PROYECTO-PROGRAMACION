package excepciones;

/**
 * Excepcion que salta si el jugador no existe
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class JugadorNuloExcepcion extends Exception{

	public JugadorNuloExcepcion(String mensaje) {
		super(mensaje);
	}

}
