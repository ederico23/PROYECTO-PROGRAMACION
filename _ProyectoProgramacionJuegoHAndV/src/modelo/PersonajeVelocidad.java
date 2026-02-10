package modelo;
/**
 * Clase de personaje tipo Velocidad
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeVelocidad extends Personaje implements Ataque{

	private Double multiplicadorAtaque;
	
	public PersonajeVelocidad(Double vida, Double statAtaque, Double statInteligencia, Double statFuerza,
			Double statVelocidad, Double statResistencia) {
		super(
			vida = 100.0, 
			statAtaque = 1.0, 
			statInteligencia = 1.0, 
			statFuerza = 1.0, 
			statVelocidad = 1.0, 
			statResistencia = 1.0);
	}

	@Override
	public void ataqueNormal(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}
}
