package modelo;
/**
 * Clase de personaje tipo Fuerza
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeFuerza extends Personaje implements Ataque{
	/**
	 *  Constructor base
	 */
	public PersonajeFuerza() {
		super(100.0, // vida
			10.0,    // ataque
			10.0,    // defensa
			2.0,     // inteligencia     
			9.0,     // fuerza
			3.0,     // velocidad  
			5.0);	 // resistencia
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
	 * 
	 */
	@Override
	public double ataqueFisico(Personaje personajeObjetivo) {
		double dañoBase = (statAtaque + statFuerza) - personajeObjetivo.getStatDefensa();
		// Para que el daño no pueda ser negativo y sea minimo 1
		double daño = Math.max(1, dañoBase) * SistemaAfinidad.calcular(this, personajeObjetivo);

		return daño;
	}
	@Override
	public double ataqueMagico(Personaje personajeObjetivo) {
		double dañoBase = (statAtaque + statFuerza) - personajeObjetivo.getStatDefensa();
		// Para que el daño no pueda ser negativo y sea minimo 1
		double daño = Math.max(1, dañoBase) * SistemaAfinidad.calcular(this, personajeObjetivo);
		return daño;
	}
	@Override
	public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}

}
