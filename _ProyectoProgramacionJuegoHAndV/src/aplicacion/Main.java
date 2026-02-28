package aplicacion;
/**
 * Clase main del programa donde se llaman a los metodos necesarios para que funcione el programa
 */

import controlador.CombateController;
import controlador.CreadorPersonajesController;
import controlador.TiendaController;
import excepciones.JugadorNuloExcepcion;
import modelo.Jugador;
import vista.JuegoVistaConsola;
import controlador.CreadorPersonajesController;

public class Main {

	public static void main(String[] args) {
		
		JuegoVistaConsola vista = new JuegoVistaConsola();
		
		TiendaController tiendaControlador = new TiendaController(vista);
		
		//Creamos el objeto que gestiona la creacion de jugadores
		CreadorPersonajesController creador = new CreadorPersonajesController(vista);
		
		Jugador jugador1 = null;
		Jugador jugador2 = null;
		
		try {
			vista.mostrarMensaje("---------JUGADOR 1----------");
			jugador1 = creador.crearJugador();
			vista.mostrarMensaje("---------JUGADOR 2----------");
			jugador2 = creador.crearJugador();

		} catch (JugadorNuloExcepcion e) {
			vista.mostrarMensaje(e.getMessage());
		}
		
		// Colocar condicion de que tenga que existir jugador
		if (jugador1 != null && jugador2 != null) {
			//Creamos controlador de combate
			CombateController combateControlador = new CombateController(jugador1, jugador2, vista);
			
			tiendaControlador.abrirTienda(jugador1);
			tiendaControlador.abrirTienda(jugador2);
			
			try {
			    System.out.println("-----INICIO COMBATE------");
			    combateControlador.iniciarCombate();
			} catch (JugadorNuloExcepcion e) {
			    vista.mostrarMensaje(e.getMessage());
			}
		}
		
	}

}
