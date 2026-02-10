package modelo;

/**
 * clase que representa una poción de vida
 * esta poción restaura puntos de vida del personaje
 * hereda de la clase Pociones
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PocionVida extends Pociones {
	
	/**
	 * cantidad de vida que se restaura al personaje
	 */
	private Double cantidadVidaAñadida;
	
	/**
	 * constructor completo de la clase PocionVida
	 * @param precio el precio de la poción en monedas
	 * @param cantidadVidaAñadida La cantidad de vida que restaura la poción
	 */
	public PocionVida(Integer precio, Double cantidadVidaAñadida) {
		super(precio); // llama al constructor de la clase padre(Pociones)
		this.cantidadVidaAñadida = cantidadVidaAñadida;
	}
	
	/**
	 * constructor con valores por defecto
	 * crea una poción de vida básica
	 */
	public PocionVida() {
		super(20); // precio por defecto: 20 monedas
		this.cantidadVidaAñadida = 20.0; // restaura 20 puntos de vida
	}
	
	/**
	 * obtiene la cantidad de vida que restaura la poción
	 * @return la cantidad de vida añadida
	 */
	public Double getCantidadVidaAñadida() {
		return cantidadVidaAñadida;
	}
	
	/**
	 * establece la cantidad de vida que restaura la poción
	 * @param cantidadVidaAñadida la nueva cantidad de vida
	 */
	public void setCantidadVidaAñadida(Double cantidadVidaAñadida) {
		this.cantidadVidaAñadida = cantidadVidaAñadida;
	}
	
	/**
	 * usa la poción de vida en un personaje
	 * restaura puntos de vida del personaje
	 * @param personaje el personaje que usa la poción
	 */
	public void usarPocionVida(Personaje personaje) {
		// obtiene la vida actual del personaje
		Double vidaActual = personaje.getVida();
		
		// aumenta la vida sumando la cantidad de la poción
		Double nuevaVida = vidaActual + this.cantidadVidaAñadida;
		
		// establece el nuevo valor de vida en el personaje
		personaje.setVida(nuevaVida);
		
		// mensaje informativo
		System.out.println("poción de vida usada!!! vida restaurada: +" + 
						   this.cantidadVidaAñadida + " de vida");
	}
	
	@Override
	/**
	 * Devuelve una representación en texto de la poción de vida
	 * @return String con los datos de la poción
	 */
	public String toString() {
		return "Poción de Vida:\n" +
			   "  Precio: " + precio + " monedas\n" +
			   "  Vida restaurada: +" + cantidadVidaAñadida + " HP";
	}
}