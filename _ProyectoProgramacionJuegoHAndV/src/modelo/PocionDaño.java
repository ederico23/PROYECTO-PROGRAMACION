package modelo;

/**
 * Clase que representa una pocion de daño
 * Esta pocion aumenta temportalmente el stat de 
 * Ataque del personaje
 * Hereda de la clase Pociones
 * 
 * @author Mariano, Eder
 * @version 1.0 - 11/02/26
 */
public class PocionDaño extends Pociones {

	/**
	 * Cantidad de stat de daño que se 
	 * Añade al personaje
	 */
	private Double cantidadStatDañoAñadida; 
	
	/**
	 * Duracion del efecto de la pocion, por turnos
	 */
	private Integer duracion;
	
	/**
	 * Constructor completo de la clase PocionDaño
	 * 
	 * @param precio = precio de la pocion (monedas)
	 * @param cantidadStatDañoAñadida = la cantidad de daño que añade
	 * @param duracion = el numero de turnos que dura  
	 */
	public PocionDaño (Integer precio, Integer duracion , Double cantidadStatDañoAñadida) {
		super(precio); // constructor Pociones
		this.cantidadStatDañoAñadida = cantidadStatDañoAñadida;
		this.duracion = duracion;
	}
	
	/**
	 * Constructor con valores por defecto
	 * Crea una pocion de daño con unos valores predeterminados
	 */
	public PocionDaño() {
		super(50);
		this.cantidadStatDañoAñadida = 10.0;
		this.duracion = 2;
	}
	
	/**
	 * Obtiene la cantidad de stat de daño que añade la pocion
	 * @return cantidadStatDañoAñadida
	 */
	public Double getCantidadStatDañoAñadida() {
		return cantidadStatDañoAñadida;
	}
	
	/**
	 * Establece la cantidad de stat de daño que añade la pocion
	 * @param cantidadStatDañoAñadida = la nueva cantidad de daño
	 */
	public void setCantidadStatDañoAñadida(Double cantidadStatDañoAñadida) {
		this.cantidadStatDañoAñadida = cantidadStatDañoAñadida;
	}

	/**
	 * Obtiene la duracion del efecto de la pocion
	 * @return duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}
	
	/**
	 * Establece la duracion del efecto de la pocion
	 * @return duracion = nueva duracion
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	@Override
	/**
	 * Usar la pocion de daño en un personaje
	 * Aumenta temportalmente el stat de ataque del pj
	 * 
	 * @param personaje = personaje que usa la pocion
	 */
	public void usar(Personaje personaje) {
		//Obtener el stat de ataque actual del pj
		Double ataqueActual = personaje.getStatAtaque();
		
		//Aumenta el stat de ataque, sumando la cantidad de la pocion
		Double nuevoAtaque = ataqueActual + this.cantidadStatDañoAñadida;
		
		//Establecer el nuevo valor de ataque en el pj
		personaje.setStatAtaque(nuevoAtaque);
		
		//Mensaje de pocion usada
		System.out.println("Has usado la poción de daño.\nAtaque "
				+ "aumentado en " + this.cantidadStatDañoAñadida 
				+ " de vida durante: " + this.duracion + " turnos");
	}
	
	@Override
	/**
	 * devuelve un mensaje de la pocion
	 * @return String con los datos de la pocion
	 */
	public String toString() {
		return "Pocion de daño:\n" +
					"Precio: " + precio + " monedas:\n"
					+ "Daño añadido: +" + cantidadStatDañoAñadida 
					+ "\nDuracion: " + duracion + " turnos";
	}

}