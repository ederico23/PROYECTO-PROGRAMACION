package modelo;

import java.util.Objects;

/**
 * Clase principal de creacion de personajes, conteniendo sus estadisticas
 * @author Mariano, Eder
 * @version 1.0 - 02/09/2026
 */
public class Personaje {
	/**
	 * Identificador de personaje
	 */
	private static int idPersonaje;
	/**
	 * vida del personaje
	 */
	protected Double vida;
	/**
	 * Estadistica de ataque del personaje
	 */
	protected Double statAtaque;
	/**
	 * Estadistica de defensa del personaje
	 */
	protected Double statDefensa;
	/**
	 * Estadistica de inteligencia del personaje
	 */
	protected Double statInteligencia;
	/**
	 * Estadistica de fuerza del personaje
	 */
	protected Double statFuerza;
	/**
	 * Estadistica de velocidad del personaje
	 */
	protected Double statVelocidad;
	/**
	 * Estadistica de resistencia del personaje
	 */
	protected Double statResistencia;
	/**
	 * Constructor de clase
	 * @param vida
	 * @param statAtaque
	 * @param statInteligencia
	 * @param statFuerza
	 * @param statVelocidad
	 * @param statResistencia
	 */
	public Personaje(Double vida, Double statAtaque, Double statDefensa, Double statInteligencia, Double statFuerza, 
			Double statVelocidad, Double statResistencia) {
		this.vida = vida;
		this.statAtaque = statAtaque;
		this.statDefensa = statDefensa;
		this.statInteligencia = statInteligencia;
		this.statFuerza = statFuerza;
		this.statVelocidad = statVelocidad;
		this.statResistencia = statResistencia;
		idPersonaje++;
	}
	/**
	 * @return the vida
	 */
	public Double getVida() {
		return vida;
	}
	/**
	 * @param vida the vida to set
	 */
	public void setVida(Double vida) {
		this.vida = vida;
	}
	/**
	 * @return the statAtaque
	 */
	public Double getStatAtaque() {
		return statAtaque;
	}
	/**
	 * @param statAtaque the statAtaque to set
	 */
	public void setStatAtaque(Double statAtaque) {
		this.statAtaque = statAtaque;
	}
	/**
	 * @return the statDefensa
	 */
	public Double getStatDefensa() {
		return statDefensa;
	}
	/**
	 * @param statDefensa the statDefensa to set
	 */
	public void setStatDefensa(Double statDefensa) {
		this.statDefensa = statDefensa;
	}
	/**
	 * @return the statInteligencia
	 */
	public Double getStatInteligencia() {
		return statInteligencia;
	}
	/**
	 * @param statInteligencia the statInteligencia to set
	 */
	public void setStatInteligencia(Double statInteligencia) {
		this.statInteligencia = statInteligencia;
	}
	/**
	 * @return the statFuerza
	 */
	public Double getStatFuerza() {
		return statFuerza;
	}
	/**
	 * @param statFuerza the statFuerza to set
	 */
	public void setStatFuerza(Double statFuerza) {
		this.statFuerza = statFuerza;
	}
	/**
	 * @return the statVelocidad
	 */
	public Double getStatVelocidad() {
		return statVelocidad;
	}
	/**
	 * @param statVelocidad the statVelocidad to set
	 */
	public void setStatVelocidad(Double statVelocidad) {
		this.statVelocidad = statVelocidad;
	}
	/**
	 * @return the statResistencia
	 */
	public Double getStatResistencia() {
		return statResistencia;
	}
	/**
	 * @param statResistencia the statResistencia to set
	 */
	public void setStatResistencia(Double statResistencia) {
		this.statResistencia = statResistencia;
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personaje other = (Personaje) obj;
		return Objects.equals(idPersonaje, other.idPersonaje);
	}
	
	
	
	
	
}
