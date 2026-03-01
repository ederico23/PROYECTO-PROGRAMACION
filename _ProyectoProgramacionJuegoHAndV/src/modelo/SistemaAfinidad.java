package modelo;

/**
 * Clase para calcular el daño
 */
public class SistemaAfinidad {
	/**
	 * Metodo para calcular valor a multiplicar para reducir o aumentar el daño según que personajes se enfrentan
	 * @param a primer personaje
	 * @param d segundo personaje
	 * @return double cantidad a multiplicar
	 */
	public static double calcular(Personaje a, Personaje d) {
		
		//Fuerza 
        if (a instanceof PersonajeFuerza && d instanceof PersonajeResistencia) return 1.25;
        if (a instanceof PersonajeFuerza && d instanceof PersonajeVelocidad) return 0.75;
        
        // Velocidad
        if (a instanceof PersonajeVelocidad && d instanceof PersonajeFuerza) return 1.25;
        if (a instanceof PersonajeVelocidad && d instanceof PersonajeInteligencia) return 0.75;
        
        // Resistencia
        if (a instanceof PersonajeResistencia && d instanceof PersonajeInteligencia) return 1.25;
        if (a instanceof PersonajeResistencia && d instanceof PersonajeVelocidad) return 0.75;
        
        // Inteligencia
        if (a instanceof PersonajeInteligencia && d instanceof PersonajeVelocidad) return 1.25;
        if (a instanceof PersonajeInteligencia && d instanceof PersonajeResistencia) return 0.75;
        
        
        return 1.0;
    }
}
