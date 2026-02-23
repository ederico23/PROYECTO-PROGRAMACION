package modelo;

import java.util.ArrayList;
/**
 * @author Mariano, Eder
 * @version 1.0
 * Clase de jugador 
 */
public class Jugador {
	private String nombre;
	private int contadorBatallasGanadas;
	private int contadorBatallasPerdidas;
	private Personaje personajeElegido;
	private Integer monedas;
	private ArrayList<Pociones> inventarioObjetos;
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
		this.inventarioObjetos = new ArrayList<Pociones>();
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
	public int getContadorBatallasGanadas() {
		return contadorBatallasGanadas;
	}
	/**
	 * @param contadorBatallasGanadas the contadorBatallasGanadas to set
	 */
	public void setContadorBatallasGanadas(int contadorBatallasGanadas) {
		this.contadorBatallasGanadas = contadorBatallasGanadas;
	}
	/**
	 * @return the contadorBatallasPerdidas
	 */
	public int getContadorBatallasPerdidas() {
		return contadorBatallasPerdidas;
	}
	/**
	 * @param contadorBatallasPerdidas the contadorBatallasPerdidas to set
	 */
	public void setContadorBatallasPerdidas(int contadorBatallasPerdidas) {
		this.contadorBatallasPerdidas = contadorBatallasPerdidas;
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
	public ArrayList<Pociones> getInventarioObjetos() {
		return inventarioObjetos;
	}
	@Override
	public String toString() {
		return "Jugador: \n"
				+ "Nombre = "+nombre+"\n"
				+ personajeElegido+"\n"
				+ "Monedas = "+monedas;
	}
	// Prueba git
	
	
	
}
