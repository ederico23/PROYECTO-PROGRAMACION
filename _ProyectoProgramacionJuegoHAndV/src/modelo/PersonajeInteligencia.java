package modelo;
/**
 * Clase de personaje tipo Inteligencia
 * 
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeInteligencia extends Personaje {
	
	/**
	 *  Constructor con estadisticas predeterminadas
	 */
	public PersonajeInteligencia() {
		super(85.0, // vida
			7.0,    // ataque
			6.0,    // defensa
			14.0,     // inteligencia     
			5.0,     // fuerza
			8.0,     // velocidad  
			10.0);	 // resistencia
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
		// Aun por implementar
		
	}
	
	
}
