package modelo;

/**
 * Clase que representa un poersonaje personalizado
 * 
 * @author Maraiano, Eder
 * @version 1.0
 */
public class PersonajePersonalizado extends Personaje{

	/**
     * Constructor que recibe todas las stats elegidas por el jugador
     *
     * @param vida  = puntos de vida del personaje
     * @param statAtaque  = estadística de ataque
     * @param statDefensa  =   estadística de defensa
     * @param statInteligencia  = estadística de inteligencia
     * @param statFuerza = estadística de fuerza
     * @param statVelocidad  = estadística de velocidad
     * @param statResistencia = estadística de resistencia
     */
    public PersonajePersonalizado(double vida, double statAtaque, double statDefensa,
            double statInteligencia, double statFuerza,
            double statVelocidad, double statResistencia) {
    	
        super(vida, statAtaque, statDefensa, statInteligencia,
              statFuerza, statVelocidad, statResistencia);
    }
	
    /**
     * Calcular el ataque fisico 
     * 
     * @param personajeObjetivo
     * @return danyo  = cantidad de daño que ha jecho
     */
    @Override
    public double ataqueFisico(Personaje personajeObjetivo) {

    	double danyoBase = (statAtaque + statFuerza) - personajeObjetivo.getStatDefensa();
    	
    	//El daño no puede ser menor que 1
    	double danyo = Math.max(1, danyoBase) * SistemaAfinidad.calcular(this, personajeObjetivo);
    	
    	return danyo;
    }
	
    /**
     * Calcular el ataque magico
     * 
     * @param personajeObjetivo = personaje que recibe el daño
     * @return danyo = cantidad de daño que ha hecho
     */
    @Override
    public double ataqueMagico(Personaje personajeObjetivo) {
   
    	double danyoBase = (statAtaque + statInteligencia) - personajeObjetivo.getStatDefensa();
    	
    	//El daño no puede ser menor que 1
    	double danyo = Math.max(1, danyoBase) * SistemaAfinidad.calcular(this, personajeObjetivo);
    	
    	return danyo;
    	
    }
    
    /**
     * Movimiento especial
     * 
     * @return personajeObjetivo = personahje que recibe daño
     */
    @Override
    public void movimientoEspecialDeClase(Personaje personajeObjetivo) {
    	//falta por implementar (a la hora de crear el personaje custom deberiamos de hacer un menu con opciones de 
    	//varios movimientos especiales y se meten aqui yya
    }
    
    /**
     * Devuelve los datos de personaje custom
     * 
     * @return String con tipo y stats
     */
    @Override 
    public String toString() {
    	return "Tipo: personalizado\n" + super.toString();
    }
    
    
    
}