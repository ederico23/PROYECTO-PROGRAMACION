package modelo;

public class SistemaAfinidad {
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
