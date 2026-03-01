package modelo;
/**
 * Clase que representa la tienda del juego
 *  - Muestra un catalogo para comprar
 *  - Gestiona las compras
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
import java.util.ArrayList;

public class Tienda {
	
	/**
	 * Lista de pociones disponibles para comprar
	 */
	private ArrayList<Pociones> catalogo;

	/**
	 * Constructor de Tienda
	 *  
	 */
	public Tienda() {
		this.catalogo = new ArrayList<Pociones>();
		inicializarCatalogo();
	}

	/**
	 * Rellena el catalogo de la tienda
	 */
	private void inicializarCatalogo() {
		//(Monedas, vida añadida)
		catalogo.add(new PocionVida(20, 30.0));
		//(Monedas, turnos, daño añadido)
		catalogo.add(new PocionDaño(30, 2, 0.3));
		//(Monedas, turnos,  % daño reducido)
		catalogo.add(new PocionDefensa(25, 2,  0.3));
	}
	
	/**
	 * Metodo para mostrar el catalogo de la tienda
	 */
	public void mostrarCatalogo() {
		System.out.println("\n-----TIENDA----");
		
		//Recorrer el ArrayList
		for (int i = 0; i < catalogo.size(); i++) {
			System.out.println((i+1) + ". " +catalogo.get(i)); //el i +1 es para que empiece en 1 en vez de 0
		}
		
		System.out.println("0. Salir tienda");
	}

	/**
	 * Devuelve el catalogo de objetos que quedan
	 * 
	 * @return the catalogo = ArrayList con los objetos
	 */
	public ArrayList<Pociones> getCatalogo() {
		return catalogo;
	} 
}