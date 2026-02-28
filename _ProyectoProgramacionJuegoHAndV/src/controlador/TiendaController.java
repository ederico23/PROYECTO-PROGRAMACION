package controlador;

import excepciones.MonedasInsuficientesExcepcion;
import excepciones.ValorFueraRangoExcepcion;
import modelo.Jugador;
import modelo.Tienda;
import utilidades.Leer;
import vista.JuegoVista;

/**
 * controlador d ela tienda
 * muestra menu de opciones, guarda la oppcion elegida, llama a los metodos, etc...
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class TiendaController {
	private JuegoVista vista;
	/**
	 * atributo de tienda para poder usarla 
	 */
	private Tienda tienda;
	/**
	 * contructor
	 * @param tienda
	 */
	public TiendaController(JuegoVista vista) {
		this.vista = vista;
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
		System.out.println(jugador.getNombre() + " tienes " + jugador.getMonedas() + " monedas");
		
		//guardar opcion
		int opcion;
		
		//bucle que se repite hasta q pulse el 0
		do {
			//mostramos la tienda 
			tienda.mostrarCatalogo();
			
			//pedimos al jugador que elija una opcion con la clase Leer
			opcion = Leer.leerEntero("¿que pocion quieres comprar? ");
			
			if (opcion == 0) {
				break;
			}
			
			try {
				//llamamos al metood comprar que se ocupa de saber si tiene monedas y si el 
				//indice es valido (es decir, que ha introducido una opcioon valida)
				//le psamos jugador y opcion
				jugador.comprar(tienda, opcion);
				vista.mostrarInventario(jugador);
			} catch (ValorFueraRangoExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
			} catch (MonedasInsuficientesExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
				vista.mostrarMensaje("\nTe quedan " + jugador.getMonedas() + " monedas\n");
			}
			
		} while (jugador.getMonedas() > 0);
		
		//mensaje de adios, actualizando las monedas
		vista.mostrarMensaje("HAS SALIDO DE LA TIENDA" + 
				"\nte quedan " + jugador.getMonedas() + " monedas\n");
		//esto no va dentro del syso porque el metodo ya imprime por su propia cuenta
		vista.mostrarInventario(jugador);
	}
	
//	/**
//	 * abrir invnetario para usar pociones dentro de la batalla
//	 * si estuviese vacio no se abrirá
//	 * 
//	 * @param jugador = jugador que quiere usarlo
//	 * @return true = si se usa un objeto,  false = no se usó nada o no se abrió
//	 */
//	public boolean abrirInventarioBatalla(Jugador jugador) {
//		
//		//comprobar si el inventario esta vacio antes de nada
//		if (jugador.getInventarioObjetos().isEmpty()) {
//			System.out.println("--INVENTARIO VACIO--");
//			return false;
//		}
//		
//		//mostrar el inventairo
//		vista.mostrarInventario(jugador);
//		
//		//pedir que pocion quiere usar, y si se arrepiente o se confunde, puede salir dando al 0 
//		int opcion = Leer.leerEntero("¿que pocion quieres usar? pulsa 0 para cancelar");
//		
//		//si elije 0, adios
//		if (opcion == 0) {
//			System.out.println("CANCELADO");
//		}
//		
//		//usar objeto 
//		//el metodo ya devuelve true si va todo bien, y si no un false
//		return jugador.usarObjeto(opcion);
//	}
	
}