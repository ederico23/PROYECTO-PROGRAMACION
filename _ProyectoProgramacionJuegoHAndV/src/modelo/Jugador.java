package modelo;

import java.util.ArrayList;
/**
 * @author Mariano, Eder
 * @version 1.0
 * Clase de jugador 
 */
public class Jugador {
	private String nombre;
	private static Integer contadorBatallasGanadas;
	private static Integer contadorBatallasPerdidas;
	private Personaje personajeElegido;
	private Integer monedas;
	private ArrayList<Objeto> inventarioObjetos;
	/**
	 * @param nombre
	 * @param personajeElegido
	 * @param monedas
	 * @param inventarioObjetos
	 */
	public Jugador(String nombre, Personaje personajeElegido, Integer monedas) {
		super();
		this.nombre = nombre;
		this.personajeElegido = personajeElegido;
		this.monedas = monedas;
		this.inventarioObjetos = new ArrayList<Objeto>();
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the contadorBatallasGanadas
	 */
	public static Integer getContadorBatallasGanadas() {
		return contadorBatallasGanadas;
	}
	/**
	 * @param contadorBatallasGanadas the contadorBatallasGanadas to set
	 */
	public static void setContadorBatallasGanadas(Integer contadorBatallasGanadas) {
		Jugador.contadorBatallasGanadas = contadorBatallasGanadas;
	}
	/**
	 * @return the contadorBatallasPerdidas
	 */
	public static Integer getContadorBatallasPerdidas() {
		return contadorBatallasPerdidas;
	}
	/**
	 * @param contadorBatallasPerdidas the contadorBatallasPerdidas to set
	 */
	public static void setContadorBatallasPerdidas(Integer contadorBatallasPerdidas) {
		Jugador.contadorBatallasPerdidas = contadorBatallasPerdidas;
	}
	/**
	 * @return the personajeElegido
	 */
	public Personaje getPersonajeElegido() {
		return personajeElegido;
	}
	/**
	 * @param personajeElegido the personajeElegido to set
	 */
	public void setPersonajeElegido(Personaje personajeElegido) {
		this.personajeElegido = personajeElegido;
	}
	/**
	 * @return the monedas
	 */
	public Integer getMonedas() {
		return monedas;
	}
	/**
	 * @param monedas the monedas to set
	 */
	public void setMonedas(Integer monedas) {
		this.monedas = monedas;
	}
	/**
	 * @return the inventarioObjetos
	 */
	public ArrayList<Objeto> getInventarioObjetos() {
		return inventarioObjetos;
	}
	@Override
	public String toString() {
		return "Jugador: /n"
				+ "Nombre = "+nombre+"/n"
				+ "Personaje = "+personajeElegido+"/n"
				+ "Monedas = "+monedas;
	}
	
	
	
}
