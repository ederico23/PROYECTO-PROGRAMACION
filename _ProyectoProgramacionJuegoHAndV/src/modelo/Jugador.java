package modelo;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import utilidades.Leer;
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
	// PRUEBA
	private Map<ArrayList<Pociones>, Integer> inventarioObjetos2;
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
		this.inventarioObjetos2 = new TreeMap<>();
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
	public Map<ArrayList<Pociones>, Integer> getInventarioObjetos2() {
		return inventarioObjetos2;
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
		if (this.getMonedas()< objetoAcomprar.getPrecio()) {
			System.out.println("no tienes suficientes monedas, tienes " + this.getMonedas() +
					" monedas, y necesitas " + objetoAcomprar.getPrecio()); // METER EXCEPCION
			//false porque no tiene monedas suficiente y no se puede comprar
			return false;
		}
		
		//vale, deberá tener monedas si llegamos aqui, entonces descontamos monedas
		this.setMonedas(this.getMonedas() - objetoAcomprar.getPrecio());
		
		//hay que añadir el objeto al jugador
		this.getInventarioObjetos().add(objetoAcomprar);
		
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
		System.out.println("Pocion usada");
		//true porque se ha podido usar la pocion y ha salido todo bien
		return true;

	}
	// CREO QUE ESTE METODO NO HACE FALTA
	/**
	 * abrir invnetario para usar pociones dentro de la batalla
	 * si estuviese vacio no se abrirá
	 * 
	 * @param jugador = jugador que quiere usarlo
	 * @return true = si se usa un objeto,  false = no se usó nada o no se abrió
	 */
	public boolean abrirInventarioBatalla() {
		
		//comprobar si el inventario esta vacio antes de nada
		if (this.getInventarioObjetos().isEmpty()) {
			System.out.println("--INVENTARIO VACIO--");
			return false;
		}
		
		//mostrar el inventairo
		this.mostrarInventario();
		
		//pedir que pocion quiere usar, y si se arrepiente o se confunde, puede salir dando al 0 
		int opcion = Leer.leerEntero("¿que pocion quieres usar? pulsa 0 para cancelar");
		
		//si elije 0, adios
		if (opcion == 0) {
			System.out.println("CANCELADO");
		}
		
		//usar objeto 
		//el metodo ya devuelve true si va todo bien, y si no un false
		return this.usarObjeto(opcion);
	}
	
	
}
