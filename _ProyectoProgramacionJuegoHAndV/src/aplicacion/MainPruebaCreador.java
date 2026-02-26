package aplicacion;

import controlador.CombateController;
import controlador.CreadorPersonajesController;
import controlador.TiendaController;
import modelo.Jugador;
import vista.CrearMenuPrueba;
import controlador.CreadorPersonajesController;

public class MainPruebaCreador {

	public static void main(String[] args) {
		
		//creamos ell objeto que gestiona la creacion de jugadores
		CreadorPersonajesController creador = new CreadorPersonajesController();
		
		System.out.println("---------JUGADOR 1---------");
		Jugador jugador1 = creador.crearJugador();
		
		System.out.println("---------JUGADOR 2----------");
		Jugador jugador2 = creador.crearJugador();
		
		//creamos vista y controladores
		CrearMenuPrueba vista = new CrearMenuPrueba();
		TiendaController tiendaControlador = new TiendaController();
		CombateController combateControlador = new CombateController(jugador1, jugador2, vista);
		
		//pruea
		
		tiendaControlador.abrirTienda(jugador1);
		tiendaControlador.abrirTienda(jugador2);
		
		
		System.out.println("-----INICIO COMBATE------");
		combateControlador.iniciarCombate();
		
		
	}

}
