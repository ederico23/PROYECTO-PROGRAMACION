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
				+ "Monedas = "+monedas
				+ "Inventario = " + inventarioObjetos.size();
	}
	/**
	 * muestra los objetos que tiene el jugador
	 * 
	 */
	public void mostrarInventario() {
		System.out.println("---- INVENTARIO DE " + nombre + " ----");
	
		//comprobar si el inventario está vacio
		if (inventarioObjetos.isEmpty()) {
			System.out.println("no tienes pociones en el inventario");
		} else {
			//si hay pociones se muestran
			for (int i = 0; i < inventarioObjetos.size(); i++) {
				//lo mismo que en la tienda, (i+1) para que empiece en 1
				System.out.println((i + 1) + ". " + inventarioObjetos.get(i));
			}
		}
	}
	/**
	 * usar la pocion del inventario en el jugador, luego que sepa el tipo de pocion,
	 * aplicar la pocion, y eliminarla del inventario
	 *
	 * @param indice = numero de la pocion en el inventario
	 * @return true = si se usó, false = si no se pudo usar
	 */
	public boolean usarObjeto(int indice) {
		//al igual que en la tienda, como empezaba en 1 para el usuario, ahora la pasamos a 0
		int indiceReal = indice -1;
		
		//comprobar si es valido el indice
		if (indiceReal < 0 || indiceReal >= inventarioObjetos.size()) {
			System.out.println("opcion no valida, elija un objeto del inventario");
		return false;
		}
		
		//obtenemos la pocion que se quiere usar 
		Pociones pocion = inventarioObjetos.get(indiceReal);
		
		//instanceof para saber que tipo de pocion es
		if (pocion instanceof PocionVida) {
			//si no se pone esta linea da error
			//con esto pasamos Pociones a PocionVida para utilizar usarPocionVida()
			PocionVida pocionVida = (PocionVida) pocion;
			//usamos la pocion sobre el jugador
			pocionVida.usarPocionVida(personajeElegido);
			
		} else if (pocion instanceof PocionDaño) {
			//si no se pone esta linea da error
			//con esto pasamos Pociones a PocionVida para utilizar usarPocionVida()
			PocionDaño pocionDaño = (PocionDaño) pocion;
			//usamos la pocion sobre el jugador
			pocionDaño.usarPocionDaño(personajeElegido);
		} else if (pocion instanceof PocionDefensa) {
			//si no se pone esta linea da error
			//con esto pasamos Pociones a PocionVida para utilizar usarPocionVida()
			PocionDefensa pocionDefensa = (PocionDefensa) pocion;
			//usamos la pocion sobre el jugador
			pocionDefensa.usarPocionDefensa(personajeElegido);
		} else {
			System.out.println("elige una de esas opciones");
			//false porque no se pudo comprar
			return false;
		}
		
		//cuando se use la pocion, hay que eliminarla
		inventarioObjetos.remove(indiceReal);
		System.out.println("ya no tienes esta pocion");
		//true porque se ha podido usar la pocion y ha salido todo bien
		return true;

	}
	
	
	
}
