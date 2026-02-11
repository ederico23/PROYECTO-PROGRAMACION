package modelo;
/**
 * Clase de personaje tipo Inteligencia
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeInteligencia extends Personaje implements Ataque{

	private Double multiplicadorAtaque;
	
	public PersonajeInteligencia() {
		super(100.0, // vida
			10.0,    // ataque
			10.0,    // defensa
			2.0,     // inteligencia     
			9.0,     // fuerza
			3.0,     // velocidad  
			5.0);	 // resistencia
	}
	public PersonajeInteligencia(double vida, double statAtaque, double statDefensa, double statInteligencia,
			double statFuerza, double statVelocidad, double statResistencia) {
		super(vida, statAtaque, statDefensa, statInteligencia, statFuerza, statVelocidad, statResistencia);
	}

	@Override
	public double ataqueFisico(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		return 0.0;
	}
	@Override
	public double ataqueMagico(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		return 0.0;
	}

	@Override
	public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}
	
	
}
