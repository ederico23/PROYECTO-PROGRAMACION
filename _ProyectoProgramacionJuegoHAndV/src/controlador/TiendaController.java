package controlador;

import excepciones.MonedasInsuficientesExcepcion;
import excepciones.ValorFueraRangoExcepcion;
import modelo.Jugador;
import modelo.Tienda;
import utilidades.Leer;
import vista.JuegoVista;

/**
 * Controlador de la tienda
 * -Muestra menu de opciones
 * -Guarda la opcion elegida
 * -Llama a los metodos
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
	 * Muestra la tienda para un jugador
	 * -Muestra el catalogo
	 * -Guarda las opciones
	 * -Ejecuta la compra
	 * 
	 * @param jugador  = el jugador que va a comprar en la tienda
	 */
	public void abrirTienda(Jugador jugador) {
		System.out.println("\n**********  TIENDA  **********");
		System.out.println(jugador.getNombre() + " tienes " + jugador.getMonedas() + " monedas");

		int opcion;
		
		do {
			tienda.mostrarCatalogo();
			
			opcion = Leer.leerEntero("\n¿Que pocion quieres comprar? ");
			
			if (opcion == 0) {
				break;
			}
			
			try {
				//Llamamos al metodo comprar que se ocupa de saber si tiene monedas y si el 
				//Indice es valido (es decir, que ha introducido una opcioon valida)
				//Le pasamos jugador y opcion de compra
				jugador.comprar(tienda, opcion);
				vista.mostrarInventario(jugador);
			} catch (ValorFueraRangoExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
			} catch (MonedasInsuficientesExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
				vista.mostrarMensaje("\nTe quedan " + jugador.getMonedas() + " monedas\n");
			}
			
		} while (jugador.getMonedas() > 0);
		
		//Mensaje de adios, actualizando las monedas
		vista.mostrarMensaje("\nHAS SALIDO DE LA TIENDA" + 
				"\nTe quedan " + jugador.getMonedas() + " monedas\n");
		
		vista.mostrarInventario(jugador);
	}
	
}