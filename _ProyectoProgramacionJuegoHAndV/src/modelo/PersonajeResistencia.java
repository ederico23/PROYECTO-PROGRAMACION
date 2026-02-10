package modelo;
/**
 * Clase de personaje tipo Resistencia
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeResistencia extends Personaje implements Ataque{

	private Double multiplicadorAtaque;
	
	public PersonajeResistencia(Double vida, Double statAtaque, Double statDefensa, Double statInteligencia, Double statFuerza,
			Double statVelocidad, Double statResistencia) {
		super(
			vida = 100.0, 
			statAtaque = 1.0, 
			statDefensa = 10.0,
			statInteligencia = 1.0, 
			statFuerza = 1.0, 
			statVelocidad = 1.0, 
			statResistencia = 1.0);
	}

	@Override
	public void ataqueFisico(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ataqueMagico(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}
}
