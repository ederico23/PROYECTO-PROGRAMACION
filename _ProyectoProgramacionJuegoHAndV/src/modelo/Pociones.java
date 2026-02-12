package modelo;

/**
 * clase base para todas las pociones del juego
 * representa un objeto que puede ser usado por el jugador durante la batalla
 * @author Mariano, Eder
 * @version 1.0 - 11/02/26
 */
public class Pociones {
	
	/**
	 * precio de la poción en monedas
	 */
	protected Integer precio;
	
	/**
	 * constructor de la clase Pociones
	 * @param precio = el precio de la poción en monedas
	 */
	public Pociones(Integer precio) {
		this.precio = precio;
	}
	
	/**
	 * constructor sin parámetros
	 * inicializa el precio en 0
	 */
	public Pociones() {
		this.precio = 0;
	}
	
	/**
	 * obtiene el precio de la poción
	 * @return el precio de la poción
	 */
	public Integer getPrecio() {
		return precio;
	}
	
	/**
	 * establece el precio de la poción
	 * @param precio el nuevo precio de la poción
	 */
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	@Override
	/**
	 * devuelve una representación en texto de la poción
	 * @return string con el precio de la poción
	 */
	public String toString() {
		return "precio: " + precio + " monedas";
	}
}