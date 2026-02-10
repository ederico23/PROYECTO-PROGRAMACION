package modelo;
/**
 * Clase de personaje tipo Fuerza
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class PersonajeFuerza extends Personaje implements Ataque{

	private Double multiplicadorAtaque;
	
	public PersonajeFuerza(Double vida, Double statAtaque, Double statDefensa, Double statInteligencia, Double statFuerza,
			Double statVelocidad, Double statResistencia) {
		super(
			vida = 100.0, 
			statAtaque = 10.0, 
			statDefensa = 10.0,
			statInteligencia = 2.0, 
			statFuerza = 9.0, 
			statVelocidad = 3.0, 
			statResistencia = 8.0);
	}

	@Override
	public void ataqueFisico(Personaje personajeObjetivo) {
		Double daño = (statAtaque + statFuerza) - personajeObjetivo.getStatDefensa();
	}
	@Override
	public void ataqueMagico(Personaje personajeObjetivo) {
		Double daño = (statAtaque + statInteligencia) - personajeObjetivo.getStatResistencia();
	}
	@Override
	public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
		// TODO Auto-generated method stub
		
	}
}
