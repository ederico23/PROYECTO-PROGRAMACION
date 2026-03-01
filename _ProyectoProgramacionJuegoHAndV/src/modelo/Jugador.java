package modelo;

/**
 * Clase de Jugador
 * 
 * @author Mariano, Eder
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import excepciones.MonedasInsuficientesExcepcion;
import excepciones.ObjetoInventarioInvalidoExcepcion;
import excepciones.ValorFueraRangoExcepcion;

public class Jugador {
	/**
	 * Nombre del jugador
	 */
	private String nombre;
	/**
	 * Contador de batallas ganadas para el jugador
	 */
	private int contadorBatallasGanadas;
	/**
	 * Contador de batallas perdidas para el jugador
	 */
	private int contadorBatallasPerdidas;
	/**
	 * Personaje asignado al jugador 
	 */
	private Personaje personajeElegido;
	/**
	 * Divisa para comprar objetos
	 */
	private Integer monedas;
	/**
	 * Inventario de objetos del jugador
	 */
	private Map<Pociones, Integer> inventarioObjetos;
	
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
		this.inventarioObjetos = new HashMap<Pociones, Integer>();
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
	 * @return  el inventario de objetos del jugador
	 */
	public Map<Pociones, Integer> getInventarioObjetos() {
		return inventarioObjetos;
	}
	
	@Override
	public String toString() {
		return "Jugador: \n"
				+ "Nombre = "+nombre+"\n"
				+ personajeElegido+"\n"
				+ "Monedas = "+monedas+"\n"
				+ "Inventario = " + inventarioObjetos.size();
	}
	
	/**
	 * Gestiona la compra de un objeto, y comprueba si hay suficientes monedas,
	 * que compre el objeto y le reste lo que cuesta.
	 * 
	 * @param jugador = jugador que quiere comprarlo
	 * @param indice = indice del objeto 
	 * @return true = compra hecha, false = no se compró
	 * @throws ValorFueraRangoExcepcion 
	 * @throws MonedasInsuficientesExcepcion 
	 */
	public boolean comprar(Tienda tienda, int indice) throws ValorFueraRangoExcepcion, MonedasInsuficientesExcepcion {
		
		int indiceReal = indice - 1;

		//comprobamos que el indice exista (negativo o mayor al numero de objetos) sino salta una excepcion
		if (indiceReal < 0 || indiceReal >= tienda.getCatalogo().size()) {
			throw new ValorFueraRangoExcepcion("La opcion elegida no existe");
		}
		
		//Obtenemos el objeto a comprar
		Pociones objetoAcomprar = tienda.getCatalogo().get(indiceReal);

		//Comprobar que el usuario tiene monedas suficientes, sino salta una excepcion
		if (this.getMonedas() < objetoAcomprar.getPrecio()) {
			throw new MonedasInsuficientesExcepcion("No tienes suficientes monedas");
		}
		
		//El jugador tiene monedas para comprar, se le resta lo que vale el objeto
		this.setMonedas(this.getMonedas() - objetoAcomprar.getPrecio());

		// Añadimos el objeto y si no contiene nada pues lo crea con 1, ya que el default es 0 y luego le suma 1
		// Si tiene pues simplemente suma
		inventarioObjetos.put(
				objetoAcomprar,
				inventarioObjetos.getOrDefault(objetoAcomprar, 0) + 1
				);

		//mandamos un mensaje
		System.out.println("\nLa compra ha sido exitosa, \nTe quedan " + this.getMonedas() + 
				" monedas.");
		return true;

	}
	
	/**
	 * Usar la pocion del inventario en el jugador, luego que sepa el tipo de pocion,
	 * aplicar la pocion, y eliminarla del inventario
	 *
	 * @param indice = numero de la pocion en el inventario
	 * @return true = si se usó, false = si no se pudo usar
	 * @throws ObjetoInventarioInvalidoExcepcion 
	 */
	public boolean usarObjeto(Integer indice) throws ObjetoInventarioInvalidoExcepcion {
		// Si no hay objetos el metodo no se ejecuta
		if (inventarioObjetos.isEmpty()) {
			System.out.println("No tienes pociones");
			return false;
		}
		
		// Creamos un Arraylist con las claves del inventario
		List<Pociones> listaPociones = new ArrayList<>(inventarioObjetos.keySet());

		//Empezaba en 1 para el usuario, ahora la pasamos a 0
		Integer indiceReal = indice -1;

		//Comprobar si es valido el indice, sino salta excepcion
		if (indiceReal < 0 || indiceReal >= inventarioObjetos.size()) {
			throw new ObjetoInventarioInvalidoExcepcion("Objeto inexistente");
		}

		//Obtenemos la pocion que se quiere usar 
		Pociones pocion = listaPociones.get(indiceReal);

		// Usar pocion, la pocion ya sabe cual es y como tiene que usarse
		pocion.usar(personajeElegido);

		// Reducir cantidad
		int cantidad = inventarioObjetos.get(pocion);

		if (cantidad > 1) {
			inventarioObjetos.put(pocion, cantidad - 1);
		} else {
			inventarioObjetos.remove(pocion);
			System.out.println("ya no tienes esta pocion");
		}

		//Devuelve true porque se ha podido usar la pocion y ha salido todo bien
		return true;

	}
	
	/**
	 * Metodo que suma uno al contador de batallas ganadas y da una recompensa en monedas
	 * @param recompensaMonedas monedas a recibir como recompensa por ganar
	 */
	public void registrarVictoria(int recompensaMonedas) {
	    contadorBatallasGanadas++;
	    monedas += recompensaMonedas;
	}

	public void registrarDerrota() {
	    contadorBatallasPerdidas++;
	}


}
