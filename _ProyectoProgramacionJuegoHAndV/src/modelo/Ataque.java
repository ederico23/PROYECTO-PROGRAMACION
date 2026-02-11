package modelo;

public interface Ataque {
	double ataqueFisico(Personaje personajeObjetivo);
	double ataqueMagico(Personaje personajeObjetivo);
	void movimientoEspecialDeClase(Personaje personajeObjetivo);
}
