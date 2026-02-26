package modelo;
/**
 * clase que representa la tienda del juego
 * catalogo para comprar y gestiona las compras
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
import java.util.ArrayList;

public class Tienda {
	/**
	 * lista de pociones disponibles para comprar
	 * hacemos un ArrayList
	 */
	private ArrayList<Pociones> catalogo;

	/**
	 * constructor de Tienda
	 * se rellena automaticamente con el catalogo
	 * @param catalogo
	 */
	public Tienda() {
		//ArrayList vacio
		this.catalogo = new ArrayList<Pociones>();
		//metodo que rellena el catalogo
		inicializarCatalogo();
	}

	/**
	 * rellena el catalogo de la tienda
	 */
	private void inicializarCatalogo() {
		//añadimos pociones de vida (monedas, vida añadida)
		catalogo.add(new PocionVida(20, 30.0));
		//añadimos pociones de daño (monedas, turnos, daño añadido)
		catalogo.add(new PocionDaño(30, 2, 0.3));
		//añadimos pociones de defensa (monedas, % daño reducido, turnos
		catalogo.add(new PocionDefensa(25, 0.3, 2));

	}
	
	/**
	 * metodo para mostrar el catalogo de la tienda
	 */
	public void mostrarCatalogo() {
		System.out.println("-----TIENDA----");
		//hacemos un for para recorrer el ArrayList
		for (int i = 0; i < catalogo.size(); i++) {
			//el i +1 es para que empiece en 1 en vez de 0
			System.out.println((i+1) + ". " +catalogo.get(i));
		}
		System.out.println("0. Salir tienda");
	}

	/**
	 * devuelve el catalogo de objetos que quedan
	 * @return the catalogo = ArrayList con los objetos
	 */
	public ArrayList<Pociones> getCatalogo() {
		return catalogo;
	} 
}//fin Tienda