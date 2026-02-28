package modelo;

/**
 * Clase que representa una pocion de defensa
 * Esta pocion reduce temportalmente el daño recibido por un %
 * Hereda de Pociones
 * 
 * @author Mariano, Eder
 * @version 1.0 - 12/02/26
 */

public class PocionDefensa extends Pociones {
	
	/**
	 * Porcentaje de reducion (0.3 = 30%)
	 */
	private Double añadirDefensa;

	/**
	 * Duracion de la pocion por turnos
	 */
	private Integer duracion;

	/**
	 * Construcor completo de la clase PocionDefensa
	 * 
	 * @param precio = precio de la pocion (monedas)
	 * @param añadirDefensa = % de reduccion
	 * @param duracion = turnos que dura el efecto
	 */
	public PocionDefensa (Integer precio, Integer duracion,  Double añadirDefensa) {
		super(precio);
		this.duracion = duracion;
		this.añadirDefensa = añadirDefensa;
	}
	
	/**
	 * Construcor con valores predeterminados
	 * Crea una pocion de defensa
	 */
	public PocionDefensa() {
		super(15);
		this.añadirDefensa = 0.3; 
		this.duracion = 2;
	}
	
	/**
	 * Obtiene la duraacion
	 * 
	 * @return duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}
	
	/**
	 * Establece la duracion
	 * 
	 * @param duracion
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
	/**
	 * Obtiene el % de la reduccion
	 * 
	 * @return porcentajeReduccionDaño 
	 */
	public Double getPorcentajeReduccionDaño() {
		return añadirDefensa;
	}
	
	/**
	 * Estalece el % de la reduccion
	 * 
	 * @param porcentajeReduccionDaño
	 */
	public void setPorcentajeReduccionDaño(Double porcentajeReduccionDaño) {
		this.añadirDefensa = porcentajeReduccionDaño;
	}
	
	@Override
	/**
	 * Usar la pocion de defensa en un personaje
	 * Aumenta la defensa
	 * 
	 * @param personaje = personaje que la usa
	 */
	public void usar(Personaje personaje) {
		//Obtiene el stat de defensa del persoanje
		Double defensaActual = personaje.getStatDefensa();

		//Calcular aumento defensa segun el %
		Double aumentoDefensa = defensaActual * this.añadirDefensa;

		//Aumentar la defensa
		Double nuevaDefensa = defensaActual + aumentoDefensa;

		//Establecer la nueva defensa al personaje
		personaje.setStatDefensa(nuevaDefensa);

		//Mensaje de uso
		System.out.println("Has usado la pocion de defensa, +" + añadirDefensa *100 
				+ "% durante " + this.duracion + " turnos");
	}

	@Override
	/**
	 * Devuelve los datos de la pocion
	 * @return String con los datos
	 */
	public String toString() {
		return "Pocion de defensa:\n" +
				"Precio: " + precio + " monedas:\n"
				+ "Daño reducido: -" + añadirDefensa *100 
				+ "%\nDuracion: " + duracion + " turnos";
	}
}

