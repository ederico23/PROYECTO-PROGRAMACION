package modelo;

import java.util.Objects;

/**
 * Clase principal de creacion de personajes, conteniendo sus estadisticas
 * 
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public abstract class Personaje implements Ataque{
		
	/**
	 * Contador para el identificador
	 */
	private static int contadorId = 0;
	
	/**
	 * Identificador de personaje
	 */
	private int idPersonaje;
	
	/**
	 * Vida del personaje
	 */
	protected double vida;
	
	/**
	 * Estadistica de ataque del personaje
	 */
	protected double statAtaque;
	
	/**
	 * Estadistica de defensa del personaje
	 */
	protected double statDefensa;
	
	/**
	 * Estadistica de inteligencia del personaje
	 */
	protected double statInteligencia;
	
	/**
	 * Estadistica de fuerza del personaje
	 */
	protected double statFuerza;
	
	/**
	 * Estadistica de velocidad del personaje
	 */
	protected double statVelocidad;
	
	/**
	 * Estadistica de resistencia del personaje
	 */
	protected double statResistencia;
	
	/**
	 * Estadistica de vida maxima del personaje
	 */
	protected double vidaMax;
	
	/**
	 * Constructor de clase
	 * 
	 * @param vida
	 * @param statAtaque
	 * @param statInteligencia
	 * @param statFuerza
	 * @param statVelocidad
	 * @param statResistencia
	 */
	public Personaje(double vida, double statAtaque, double statDefensa, double statInteligencia, double statFuerza, 
			double statVelocidad, double statResistencia) {
		this.vida = vida;
		this.statAtaque = statAtaque;
		this.statDefensa = statDefensa;
		this.statInteligencia = statInteligencia;
		this.statFuerza = statFuerza;
		this.statVelocidad = statVelocidad;
		this.statResistencia = statResistencia;
		idPersonaje = contadorId++;
		this.vidaMax = vida; 
	}
	
	/**
	 * @return the vida
	 */
	public double getVida() {
		return vida;
	}

	/**
	 * @param vida the vida to set
	 */
	public void setVida(double vida) {
		this.vida = vida;
	}

	/**
	 * @return the statAtaque
	 */
	public double getStatAtaque() {
		return statAtaque;
	}

	/**
	 * @param statAtaque the statAtaque to set
	 */
	public void setStatAtaque(double statAtaque) {
		this.statAtaque = statAtaque;
	}

	/**
	 * @return the statDefensa
	 */
	public double getStatDefensa() {
		return statDefensa;
	}

	/**
	 * @param statDefensa the statDefensa to set
	 */
	public void setStatDefensa(double statDefensa) {
		this.statDefensa = statDefensa;
	}

	/**
	 * @return the statInteligencia
	 */
	public double getStatInteligencia() {
		return statInteligencia;
	}

	/**
	 * @param statInteligencia the statInteligencia to set
	 */
	public void setStatInteligencia(double statInteligencia) {
		this.statInteligencia = statInteligencia;
	}

	/**
	 * @return the statFuerza
	 */
	public double getStatFuerza() {
		return statFuerza;
	}

	/**
	 * @param statFuerza the statFuerza to set
	 */
	public void setStatFuerza(double statFuerza) {
		this.statFuerza = statFuerza;
	}

	/**
	 * @return the statVelocidad
	 */
	public double getStatVelocidad() {
		return statVelocidad;
	}

	/**
	 * @param statVelocidad the statVelocidad to set
	 */
	public void setStatVelocidad(double statVelocidad) {
		this.statVelocidad = statVelocidad;
	}

	/**
	 * @return the statResistencia
	 */
	public double getStatResistencia() {
		return statResistencia;
	}

	/**
	 * @param statResistencia the statResistencia to set
	 */
	public void setStatResistencia(double statResistencia) {
		this.statResistencia = statResistencia;
	}

	/**
	 * @return the idPersonaje
	 */
	public int getIdPersonaje() {
		return idPersonaje;
	}
	
	/**
	 * @return the vidaMax
	 */
	public double getVidaMax() {
		return vidaMax;
	}

	@Override
	/**
	 * Metodo para observar caracteristicas de personaje
	 */
	public String toString() {
		return "Estadisticas de Personaje: \n"
				+ "Vida = " +vida+"\n"
				+ "Ataque = " +statAtaque+"\n"
				+ "Defensa = " +statDefensa+"\n"
				+ "Inteligencia = " +statInteligencia+"\n"
				+ "Fuerza = " +statFuerza+ "\n"
				+ "Velocidad = " +statVelocidad+ "\n"
				+ "Resistencia = "+ statResistencia;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idPersonaje);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Personaje))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(idPersonaje, other.idPersonaje);
	}
	
	/**
	 * Metodo para reducir la vida de personaje cuando recibe danyo
	 * @param danyo recibido
	 */
	public void recibirDanyo(double danyo) {
		// Reducir vida
		this.vida -= danyo;
		// Condicion para que vida no sea menor que 0
		if (this.vida < 0) {
			this.vida = 0;
		}
	}
	
	/**
	 * Metodo para determinar si un personaje esta vivo o no
	 * @return booleano con true si esta vivo y false si no lo esta
	 */
	public boolean estaVivo() {
		return this.vida > 0;
	}
	// Declaramos metodos de interfaz como abstractos
	public abstract double ataqueFisico(Personaje personajeObjetivo);
	public abstract double ataqueMagico(Personaje personajeObjetivo);
	public abstract void movimientoEspecialDeClase(Personaje personajeObjetivo);

	
	
	
	
}
