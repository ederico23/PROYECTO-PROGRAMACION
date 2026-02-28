package modelo;

/**
 * Interfaz de Ataque
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public interface Ataque {
	double ataqueFisico(Personaje personajeObjetivo);
	double ataqueMagico(Personaje personajeObjetivo);
	void movimientoEspecialDeClase(Personaje personajeObjetivo);
}
