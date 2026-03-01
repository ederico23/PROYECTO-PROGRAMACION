package modelo;

/**
 * Clase que representa una poción de vida
 * Esta poción restaura puntos de vida del personaje
 * Hereda de la clase Pociones
 * 
 * @author Mariano, Eder
 * @version 1.0 - 11/02/26
 */
public class PocionVida extends Pociones {
	
	/**
	 * Cantidad de vida que se restaura al personaje
	 */
	private Double cantidadVidaAñadida;
	
	/**
	 * Constructor completo de la clase PocionVida
	 * 
	 * @param precio el precio de la poción en monedas
	 * @param cantidadVidaAñadida La cantidad de vida que restaura la poción
	 */
	public PocionVida(Integer precio, Double cantidadVidaAñadida) {
		super(precio); 
		this.cantidadVidaAñadida = cantidadVidaAñadida;
	}
	
	/**
	 * Constructor con valores por defecto
	 * Crea una poción de vida básica
	 */
	public PocionVida() {
		super(20); // precio por defecto: 20 monedas
		this.cantidadVidaAñadida = 20.0; // restaura 20 puntos de vida
	}
	
	/**
	 * Obtiene la cantidad de vida que restaura la poción
	 * @return la cantidad de vida añadida
	 */
	public Double getCantidadVidaAñadida() {
		return cantidadVidaAñadida;
	}
	
	/**
	 * Establece la cantidad de vida que restaura la poción
	 * @param cantidadVidaAñadida la nueva cantidad de vida
	 */
	public void setCantidadVidaAñadida(Double cantidadVidaAñadida) {
		this.cantidadVidaAñadida = cantidadVidaAñadida;
	}
	
	@Override
	/**
	 * Usa la poción de vida en un personaje
	 * Restaura puntos de vida del personaje
	 * 
	 * @param personaje el personaje que usa la poción
	 */
	public void usar(Personaje personaje) {
		//Obtiene la vida actual del personaje
		Double vidaActual = personaje.getVida();
		
		//Aumenta la vida sumando la cantidad de la poción
		Double nuevaVida = vidaActual + this.cantidadVidaAñadida;
		
		if (nuevaVida > personaje.getVidaMax()) { //Si la vida despues de la pocion es mayor que el maximo de vida del personaje, no cura
			personaje.setVida(personaje.getVidaMax());
			System.out.println("Vida al maximo \nVida actual: " + personaje.getVida() + "/" + personaje.getVidaMax());
		} else {
			personaje.setVida(nuevaVida);
			System.out.println("Pocion de vida usada " + this.cantidadVidaAñadida + "HP\nVida actual: " + personaje.getVida() + "/" + personaje.getVidaMax());
		}
		
		//Establece el nuevo valor de vida en el personaje
		personaje.setVida(nuevaVida);
		 
	}
	
	@Override
	/**
	 * Devuelve una representación en texto de la poción de vida
	 * @return String con los datos de la poción
	 */
	public String toString() {
		return "Poción de Vida:\n" +
			   "Precio: " + precio + " monedas\n" +
			   "Vida restaurada: +" + cantidadVidaAñadida + " HP";
	}
}	