package modelo;

/**
 * clase que representa una pocion de daño
 * esta pocion aumenta temportalmente el stat de 
 * ataque del personaje
 * Hereda de la clase Pociones
 * 
 * @author Mariano, Eder
 * @version 1.0 - 11/02/26
 */
public class PocionDaño extends Pociones {

	/**
	 * cantidad de stat de daño que se 
	 * añade al personaje
	 */
	private Double cantidadStatDañoAñadida; 
	
	/**
	 * duracion del efecto de la pocion, por turnos
	 */
	private Integer duracion;
	
	/**
	 * constructor completo de la clase PocionDaño
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
	 * constructor con valores por defecto
	 * crea una pocion de daño con unos valores predeterminados
	 */
	public PocionDaño() {
		super(50); //precio en monedas (ya pondremos uno acorde)
		this.cantidadStatDañoAñadida = 10.0; //aumento ataque (ya pondremos uno acorde)
		this.duracion = 2; //turnos que dura
	}
	
	/**
	 * obtiene la cantidad de stat de daño que añade la pocion
	 * @return cantidadStatDañoAñadida
	 */
	public Double getCantidadStatDañoAñadida() {
		return cantidadStatDañoAñadida;
	}
	
	/**
	 * establece la cantidad de stat de daño que añade la pocion
	 * @param cantidadStatDañoAñadida = la nueva cantidad de daño
	 */
	public void setCantidadStatDañoAñadida(Double cantidadStatDañoAñadida) {
		this.cantidadStatDañoAñadida = cantidadStatDañoAñadida;
	}

	/**
	 * obtiene la duracion del efecto de la pocion
	 * @return duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}
	
	/**
	 * establece la duracion del efecto de la pocion
	 * @return duracion = nueva duracion
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * usar la pocion de daño en un personaje
	 * aumenta temportalmente el stat de ataque del pj
	 * @param personaje = personaje que usa la pocion
	 */
	public void usarPocionDaño(Personaje personaje) {
		//obtener el stat de ataque actual del pj
		Double ataqueActual = personaje.getStatAtaque();
		
		//aumenta el stat de ataque, sumando la cantidad de la pocion
		Double nuevoAtaque = ataqueActual + this.cantidadStatDañoAñadida;
		
		//establecer el nuevo valor de ataque en el pj
		personaje.setStatAtaque(nuevoAtaque);
		
		//mensaje de pocion usada
		System.out.println("has usado la poción de daño.\n ataque "
				+ "aumentado en " + this.cantidadStatDañoAñadida 
				+ " de vida durante: " + this.duracion + " turnos");
	}
	
	@Override
	/**
	 * devuelve un mensaje de la pocion
	 * @return String con los datos de la pocion
	 */
	public String toString() {
		return "pocion de daño:\n " +
					" precio: " + precio + " monedas:\n"
					+ "daño añadido: +" + cantidadStatDañoAñadida 
					+ "\n duracion: " + duracion + " turnos";
	}
	
	
	
	
	
	

}
