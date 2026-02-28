package excepciones;

/**
 * Excepcion que salta si no puedes comprar un objeto al no tener monedas suficientes
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class MonedasInsuficientesExcepcion extends Exception{
	
	public MonedasInsuficientesExcepcion(String mensaje) {
		super(mensaje);
	}

}
