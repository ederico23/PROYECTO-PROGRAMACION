package modelo;

/**
 * clase que representa una pocion de defensa
 * esta pocion reduce temportalmente el daño recibido por un %
 * hereda de Pociones
 * @author Mariano, Eder
 * @version 1.0 - 12/02/26
 */

public class PocionDefensa extends Pociones {
	
	/**
	 * porcentaje de reducion (0.3 = 30%)
	 */
	private Double porcentajeReduccionDaño;

	/**
	 * duracion de la pocion por turnos
	 */
	private Integer duracion;

	/**
	 * construcor completo de la clase PocionDefensa
	 * @param precio = precio de la pocion (monedas)
	 * @param porcentajeReduccionDaño = % de reduccion
	 * @param duracion = turnos que dura el efecto
	 */
	public PocionDefensa (Integer precio, Double porcentajeReduccionDaño, Integer duracion) {
		super(precio); //llamamos al constructor de Pociones
		this.porcentajeReduccionDaño = porcentajeReduccionDaño;
		this.duracion = duracion;
	}
	/**
	 * construcor con valores predeterminados
	 * crea una pocion de defensa
	 */
	public PocionDefensa() {
		super(15);//ya estableceremos las cantidades
		this.porcentajeReduccionDaño = 0.3; 
		this.duracion = 2;
	}
	/**
	 * obtiene la duraacion
	 * @return duracion
	 */
	public Integer getDuracion() {
		return duracion;
	}
	/**
	 * establece la duracion
	 * @param duracion
	 */
	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	/**
	 * obtiene el % de la reduccion
	 * @return porcentajeReduccionDaño 
	 */
	public Double getPorcentajeReduccionDaño() {
		return porcentajeReduccionDaño;
	}
	/**
	 * estalece el % de la reduccion
	 * @param porcentajeReduccionDaño
	 */
	public void setPorcentajeReduccionDaño(Double porcentajeReduccionDaño) {
		this.porcentajeReduccionDaño = porcentajeReduccionDaño;
	}

	/**
	 * usar la pocion de defensa en un personaje
	 * aumenta la defensa
	 * @param personaje = personaje que la usa
	 */
	public void usarPocionDefensa(Personaje personaje) {
		//obtiene el stat de defensa del persoanje
		Double defensaActual = personaje.getStatDefensa();

		//calcular aumento defensa segun el %
		Double aumentoDefensa = defensaActual * this.porcentajeReduccionDaño;

		//aumentar la defensa
		Double nuevaDefensa = defensaActual + aumentoDefensa;

		//establecer la nueva defensa al personaje
		personaje.setStatDefensa(nuevaDefensa);

		//mensaje de uso
		System.out.println("has usado la pocion de defensa, +" + porcentajeReduccionDaño *100 
				+ "% durante " + this.duracion + " turnos");
	}

	@Override
	/**
	 * devuelve los datos de la pocion
	 * @return String con los datos
	 */
	public String toString() {
		return "pocion de defensa:\n " +
				" precio: " + precio + " monedas:\n"
				+ "daño reducido: -" + porcentajeReduccionDaño *100 
				+ "%\n duracion: " + duracion + " turnos";
	}
}

