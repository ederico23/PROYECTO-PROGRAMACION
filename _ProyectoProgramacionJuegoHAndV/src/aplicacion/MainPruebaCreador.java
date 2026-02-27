package aplicacion;

import controlador.CombateController;
import controlador.CreadorPersonajesController;
import controlador.TiendaController;
import modelo.Jugador;
import vista.JuegoVistaConsola;
import controlador.CreadorPersonajesController;

public class MainPruebaCreador {

	public static void main(String[] args) {
		
		JuegoVistaConsola vista = new JuegoVistaConsola();
		TiendaController tiendaControlador = new TiendaController();
		
		//creamos ell objeto que gestiona la creacion de jugadores
		CreadorPersonajesController creador = new CreadorPersonajesController(vista);
		
		vista.mostrarMensaje("---------JUGADOR 1----------");
		Jugador jugador1 = creador.crearJugador();
		
		System.out.println("---------JUGADOR 2----------");
		Jugador jugador2 = creador.crearJugador();
		
		//creamos vista y controladores
		CombateController combateControlador = new CombateController(jugador1, jugador2, vista);
		
		//pruea
		// Colocar condicion de que tenga que existir jugador
		if (jugador1 != null && jugador2 != null) {
			tiendaControlador.abrirTienda(jugador1);
			tiendaControlador.abrirTienda(jugador2);
			System.out.println("-----INICIO COMBATE------");
			combateControlador.iniciarCombate();
		}
		
	}

}
