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
	}
	
	/**
	 * gestiona la compra de un objeto, y comprueba si hay suficientes monedas,
	 * que compre el objeto y le reste lo que cuesta.
	 * @param jugador = jugador que quiere comprarlo
	 * @param indice = indice del objeto 
 	 * @return true = compra hecha, false = no se compró
	 */
	public boolean comprar(Jugador jugador, int indice) {
		//lo convertimos en el indice del ArrayList
		int indiceReal = indice-1;
		
		//comprobamos que el indice exista (negativo o mayor al numero de objetos)
		if (indiceReal < 0 || indiceReal >= catalogo.size()) {
			System.out.println("opcion no valida"); // METER EXCEPCION
			//devolvemos false porque no se puede comprar
			return false;
		}
		
		//tenemos que obetner el objeto que quiere comprar usando el indice real
		Pociones objetoAcomprar = catalogo.get(indiceReal);
		
		//comprobar que el usuario tiene monedas suficientes
		if (jugador.getMonedas()< objetoAcomprar.getPrecio()) {
			System.out.println("no tienes suficientes monedas, tienes " + jugador.getMonedas() +
					" monedas, y necesitas " + objetoAcomprar.getPrecio()); // METER EXCEPCION
			//false porque no tiene monedas suficiente y no se puede comprar
			return false;
		}
		
		//vale, deberá tener monedas si llegamos aqui, entonces descontamos monedas
		jugador.setMonedas(jugador.getMonedas() - objetoAcomprar.getPrecio());
		
		//hay que añadir el objeto al jugador
		jugador.getInventarioObjetos().add(objetoAcomprar);
		
		//mandamos un mensaje
		System.out.println("la compra ha sido exitosa, \nte quedan " + jugador.getMonedas() + 
				" monedas.");
		return true;

	}

	/**
	 * devuelve el catalogo de objetos que quedan
	 * @return the catalogo = ArrayList con los objetos
	 */
	public ArrayList<Pociones> getCatalogo() {
		return catalogo;
	} 
}//fin Tienda