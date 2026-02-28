package modelo;

/**
 * Clase de personaje tipo Resistencia
 * 
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeResistencia extends Personaje {
	
	/**
	 * Constructor para estadisticas predeterminadas
	 */
	public PersonajeResistencia() {
		super(120.0, // Vida
			8.0,    // Ataque
			13.0,    // Defensa
			5.0,     // Inteligencia     
			7.0,     // Fuerza
			4.0,     // Velocidad  
			13.0);	 // Resistencia
	}

	/**
	 *  Metodo de ataque de tipo fisico
	 *  @param personajeObjetivo se le pasa como parametro el personaje al que se va a atacar para tomar su stat de defensa y calcular el daño 
	 *  @return double cantidad de daño a hacer
	 */
	
	@Override
	public double ataqueFisico(Personaje personajeObjetivo) {
		double danyoBase = (statAtaque + statFuerza) - personajeObjetivo.getStatDefensa();
		// Para que el daño no pueda ser negativo y sea minimo 1
		double danyo = Math.max(1, danyoBase) * SistemaAfinidad.calcular(this, personajeObjetivo);

		return danyo;
	}
	
	/**
	 *  Metodo de ataque de tipo magico
	 * 
	 *  @param personajeObjetivo se le pasa como parametro el personaje al que se va a atacar para tomar su stat de defensa y calcular el daño 
	 *  @return double cantidad de daño a hacer
	 */
	@Override
	public double ataqueMagico(Personaje personajeObjetivo) {
		double danyoBase = (statAtaque + statInteligencia) - personajeObjetivo.getStatResistencia();
		// Para que el daño no pueda ser negativo y sea minimo 1
		double danyo = Math.max(1, danyoBase) * SistemaAfinidad.calcular(this, personajeObjetivo);
		return danyo;
	}
	
	@Override
	public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
		// no atacar durante un par de turnos y coger un porcentaje del daño recibido y sumarlo a 
		// su ataque al terminar los tres turnos
		
	}
	
}
