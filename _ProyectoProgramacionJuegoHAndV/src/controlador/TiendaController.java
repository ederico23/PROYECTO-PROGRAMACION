package controlador;

import modelo.Jugador;
import modelo.Tienda;
import utilidades.Leer;

/**
 * controlador d ela tienda
 * muestra menu de opciones, guarda la oppcion elegida, llama a los metodos, etc...
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class TiendaController {

	/**
	 * atributo de tienda para poder usarla 
	 */
	private Tienda tienda;
	
	/**
	 * contructor
	 * @param tienda
	 */
	public TiendaController() {
		this.tienda = new Tienda();
	}

	/**
	 * muestra la tienda para un jugador
	 * muestra el catalogo, guarda las opciones y ejecura la cmpra
	 * bucle para que compre los objetos que quieras
	 * 
	 * @param jugador  = el jugador que va a comprar en la tienda
	 */
	public void abrirTienda(Jugador jugador) {
		System.out.println("**********  TIENDA  **********");
		System.out.println(jugador.getNombre()+" tienes " + jugador.getMonedas() + " monedas");
		
		//guardar opcion
		int opcion;
		
		//bucle que se repite hasta q pulse el 0
		do {
			//mostramos la tienda 
			tienda.mostrarCatalogo();
			
			//pedimos al jugador que elija una opcion con la clase Leer
			opcion = Leer.leerEntero("¿que pocion quieres comprar? ");
			
			//si no poone 0, seguimos con la compra
			if (opcion != 0) {
				//llamamos al metood comprar que se ocupa de saber si tiene monedas y si el 
				//indice es valido (es decir, que ha introducido una opcioon valida)
				//le psamos tienda y opcion
				jugador.comprar(tienda, opcion);
				jugador.mostrarInventario();
			}	
		} while (opcion != 0);
		
		//mensaje de adios, actualizando las monedas
		System.out.println("HAS SALIDO DE LA TIENDA" + 
				"\nte quedan " + jugador.getMonedas() + " monedas" + 
				"\ny este es tu inventario actualizado ");
		//esto no va dentro del syso porque el metodo ya imprime por su propia cuenta
		jugador.mostrarInventario();
	}
}