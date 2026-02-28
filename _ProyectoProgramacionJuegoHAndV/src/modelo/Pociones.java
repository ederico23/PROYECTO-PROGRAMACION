package modelo;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase base para todas las pociones del juego
 * Representa un objeto que puede ser usado por el jugador durante la batalla
 * 
 * @author Mariano, Eder
 * @version 1.0 - 11/02/26
 */
public abstract class Pociones {
	
	/**
	 * Precio de la poción en monedas
	 */
	protected Integer precio;
	
	/**
	 * Constructor de la clase Pociones
	 * 
	 * @param precio = el precio de la poción en monedas
	 */
	public Pociones(Integer precio) {
		this.precio = precio;
	}
	
	/**
	 * Constructor sin parámetros
	 * Inicializa el precio en 0
	 */
	public Pociones() {
		this.precio = 0;
	}
	
	/**
	 * Obtiene el precio de la poción
	 * 
	 * @return el precio de la poción
	 */
	public Integer getPrecio() {
		return precio;
	}
	
	/**
	 * Establece el precio de la poción
	 * @param precio el nuevo precio de la poción
	 */
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	@Override
	/**
	 * Devuelve una representación en texto de la poción
	 * @return string con el precio de la poción
	 */
	public String toString() {
		return "Precio: " + precio + " monedas";
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	/**
	 * Metodo para determinar cuando una pocion es igual a otra
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pociones other = (Pociones) obj;
		// Las pociones son iguales si su clase es igual, es decir, que PocionVida es igual a PocionVida
		return this.getClass().equals(other.getClass());
	}
	
	/**
	 * Metodo para que las pociones se puedan usar ellas mismas, a determinar en cada tipo de pocion
	 * @param personaje
	 */
	public abstract void usar (Personaje personaje);
	
}