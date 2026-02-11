package modelo;

import java.util.Objects;

/**
 * Clase principal de creacion de personajes, conteniendo sus estadisticas
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class Personaje {
	/**
	 * Contador para el identificador
	 */
	private static int contadorId = 0;
	/**
	 * Identificador de personaje
	 */
	private int idPersonaje;
	/**
	 * vida del personaje
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
	 * Constructor de clase
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

	@Override
	/**
	 * Metodo para observar caracteristicas de personaje
	 */
	public String toString() {
		return "Estadisticas de Personaje: /n"
				+ "Vida = " +vida+"/n"
				+ "Ataque = " +statAtaque+"/n"
				+ "Inteligencia = " +statInteligencia+"/n"
				+ "Fuerza = " +statFuerza+ "/n "
				+ "Velocidad = " +statVelocidad+ "/n "
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
	
	
	
	
	
}
