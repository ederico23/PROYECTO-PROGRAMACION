package modelo;
/**
 * Clase de personaje tipo Fuerza
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeFuerza extends Personaje {
	/**
	 *  Constructor con estadisticas predeterminadas
	 */
	public PersonajeFuerza() {
		super(110.0, // vida
			12.0,    // ataque
			9.0,    // defensa
			4.0,     // inteligencia     
			13.0,     // fuerza
			5.0,     // velocidad  
			7.0);	 // resistencia
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
	public PersonajeFuerza(double vida, double statAtaque, double statDefensa, double statInteligencia,
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
		// 
		
	}

}
