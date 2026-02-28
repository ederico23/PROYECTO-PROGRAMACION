package vista;

/**
 * Clase para hacer vista de menu de prueba
 */

import java.util.Map;
import modelo.Jugador;
import modelo.Pociones;
import utilidades.Leer;

public class JuegoVistaConsola implements JuegoVista{
	
	@Override
	/**
	 * Metodo para mostrar mensaje
	 *
	 * @param mensaje
	 */
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
	@Override
	/**
	 * Metodo para mostrar un menu
	 * 
	 * @param menu
	 * @return
	 */
	public int mostrarMenu(String[] menu, String jugadorAJugar) {

		int opcion;
		
		do {
			
			System.out.println("MENÚ / Turno de " + jugadorAJugar);
			
			// Bucle con opciones menu
			for (int i = 1; i < menu.length; i++){	
				System.out.println(i +". "+menu[i]);
			}
			
			// Mostrar siempre al final la opcion 0
			System.out.println(0+". "+menu[0]);
			
			opcion = Leer.leerEntero("");
			
		} while (opcion < 0 || opcion >= menu.length);
		
		return opcion;
	}
	
	/**
	 * Muestra los objetos que tiene el jugador
	 */
	public void mostrarInventario(Jugador jugador) {
		System.out.println("---- INVENTARIO DE " + jugador.getNombre() + " ----");
	
		//Comprobar si el inventario está vacio
		if (jugador.getInventarioObjetos().isEmpty()) {
			System.out.println("no tienes pociones en el inventario");
		} else {
			int i = 1;
			for (Map.Entry<Pociones, Integer> entry : jugador.getInventarioObjetos().entrySet()) {
				//Lo mismo que en la tienda, (i+1) para que empiece en 1
				System.out.println(i + ". " + entry.getKey() + " x" + entry.getValue());
				i++;
			}
		}
	}
}

