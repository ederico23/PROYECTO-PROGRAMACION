package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	 * gestiona la compra de un objeto, y comprueba si hay suficientes monedas,
	 * que compre el objeto y le reste lo que cuesta.
	 * @param jugador = jugador que quiere comprarlo
	 * @param indice = indice del objeto 
 	 * @return true = compra hecha, false = no se compró
	 */
	public boolean comprar(Tienda tienda, int indice) {
		//lo convertimos en el indice del ArrayList
		int indiceReal = indice-1;
		
		//comprobamos que el indice exista (negativo o mayor al numero de objetos)
		if (indiceReal < 0 || indiceReal >= tienda.getCatalogo().size()) {
			System.out.println("opcion no valida"); // METER EXCEPCION
			//devolvemos false porque no se puede comprar
			return false;
		}
		
		//tenemos que obetner el objeto que quiere comprar usando el indice real
		Pociones objetoAcomprar = tienda.getCatalogo().get(indiceReal);
		
		//comprobar que el usuario tiene monedas suficientes
		if (this.getMonedas() < objetoAcomprar.getPrecio()) {
			System.out.println("no tienes suficientes monedas, tienes " + this.getMonedas() +
					" monedas, y necesitas " + objetoAcomprar.getPrecio()); // METER EXCEPCION
			//false porque no tiene monedas suficiente y no se puede comprar
			return false;
		}
		
		//vale, deberá tener monedas si llegamos aqui, entonces descontamos monedas
		this.setMonedas(this.getMonedas() - objetoAcomprar.getPrecio());
		
		// Añadimos el objeto y si no contiene nada pues lo crea con 1, ya que el default es 0 y luego le suma 1
		// Si tiene pues simplemente suma
		inventarioObjetos.put(
			    objetoAcomprar,
			    inventarioObjetos.getOrDefault(objetoAcomprar, 0) + 1
			);
		
		//mandamos un mensaje
		System.out.println("la compra ha sido exitosa, \nte quedan " + this.getMonedas() + 
				" monedas.");
		return true;

	}
	/**
	 * usar la pocion del inventario en el jugador, luego que sepa el tipo de pocion,
	 * aplicar la pocion, y eliminarla del inventario
	 *
	 * @param indice = numero de la pocion en el inventario
	 * @return true = si se usó, false = si no se pudo usar
	 */
	public boolean usarObjeto(Integer indice) {
		// Si no hay objetos el metodo no se ejecuta
		if (inventarioObjetos.isEmpty()) {
	        System.out.println("No tienes pociones");
	        return false;
	    }
		// Creamos un arraylist con las claves del inventario
	    List<Pociones> listaPociones = new ArrayList<>(inventarioObjetos.keySet());
	    
		//al igual que en la tienda, como empezaba en 1 para el usuario, ahora la pasamos a 0
		Integer indiceReal = indice -1;
		
		//comprobar si es valido el indice
		if (indiceReal < 0 || indiceReal >= inventarioObjetos.size()) {
			System.out.println("opcion no valida, elija un objeto del inventario"); // EXCEPCION
			return false;
		}
		
		//obtenemos la pocion que se quiere usar 
		Pociones pocion = listaPociones.get(indiceReal);
		
		// Usar pocion, la pocion ya sabe cual es y como tiene que usarse
		pocion.usar(personajeElegido);
		
		// Reducir cantidad
		int cantidad = inventarioObjetos.get(pocion);

		if (cantidad > 1) {
		    inventarioObjetos.put(pocion, cantidad - 1);
		} else {
		    inventarioObjetos.remove(pocion);
		}
		
		System.out.println("ya no tienes esta pocion");
		
		//true porque se ha podido usar la pocion y ha salido todo bien
		return true;

	}
	
	
	
}
