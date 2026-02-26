package modelo;
/**
 * Clase de personaje tipo Resistencia
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeResistencia extends Personaje {
	/**
	 * Constructor para estadisticas predeterminadas
	 */
	public PersonajeResistencia() {
		super(120.0, // vida
			8.0,    // ataque
			13.0,    // defensa
			5.0,     // inteligencia     
			7.0,     // fuerza
			4.0,     // velocidad  
			13.0);	 // resistencia
	}
	/**
	 * Constructor para personalizar
	 * @param vida
	 * @param statAtaque
	 * @param statDefensa
	 * @param statInteligencia
	 * @param statFuerza
	 * @param statVelocidad
	 * @param statResistencia
	 */
	public PersonajeResistencia(double vida, double statAtaque, double statDefensa, double statInteligencia,
			double statFuerza, double statVelocidad, double statResistencia) {
		super(vida, statAtaque, statDefensa, statInteligencia, statFuerza, statVelocidad, statResistencia);
	}
	/**
	 *  Metodo de ataque de tipo fisico
	 *  @param personajeObjetivo se le pasa como parametro el personaje al que se va a atacar
	 *  para tomar su stat de defensa y calcular el daño 
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
	 *  @param personajeObjetivo se le pasa como parametro el personaje al que se va a atacar
	 *  para tomar su stat de defensa y calcular el daño 
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
