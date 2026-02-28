//package aplicacion;
//
//import controlador.CombateController;
//import controlador.TiendaController;
//import modelo.Jugador;
//import modelo.PersonajeFuerza;
//import vista.JuegoVistaConsola;
//
///**
// * clase main de prueba para comprobar si funcionan las pociones
// * crea jugadores, controlador de combate y de la tienda
// * muestra menu para atacar , stats, tienda y usar pociones
// * 
// * @author Mariano, EDer
// * @version 1.0
// */
//public class MainPruebaPociones {
//
//	public static void main(String[] args) {
//
//		//crear jugadores (nombre, personaje y monedas)
//		Jugador jugador1 = new Jugador("Mariano", new PersonajeFuerza(), 100);
//		Jugador jugador2 = new Jugador("Eder", new PersonajeFuerza(), 100);
//		JuegoVistaConsola vista = new JuegoVistaConsola();
//		//crear los controladores
//		//crear controlador d ecombate
//		CombateController combateControlador = new CombateController(jugador1, jugador2, vista);
//
//		//crear el controlador de la tienda
//		TiendaController tiendaControlador = new TiendaController();
//
//		//inciaimos juego
//		System.out.println("********** INCIO DEL JUEGO *********");
//
//		// ── Menú principal ─────────────────────────────────────────────────
//		int opcion;
//
//		// Array de opciones del menú (posición 0 = opción de salir)
//		String[] menu = {
//				"salir",                                        // 0
//				"ver estadísticas de " + jugador1.getNombre(), // 1
//				"ver estadísticas de " + jugador2.getNombre(), // 2
//				"atacar a " + jugador2.getNombre(),             // 3
//				"atacar a " + jugador1.getNombre(),             // 4
//				"tienda - " + jugador1.getNombre(),             // 5
//				"tienda - " + jugador2.getNombre(),             // 6
//				"isar poción - " + jugador1.getNombre(),        // 7
//				"usar poción - " + jugador2.getNombre()         // 8
//		};
//
//		//el bucle mantiene el menú activo hasta que el jugador elija 0 para slair
////		do {
////			// mostrarMenu() imprime las opciones y devuelve la opcion elegida
////			opcion = JuegoVistaConsola.mostrarMenuMetodoEstatico(menu, jugador1.getNombre());
////
////			// switch comprueba opción
////			switch (opcion) {
////
////			case 1: // Ver estadísticas jugador 1
////				System.out.println(jugador1);
////				break;
////
////			case 2: // Ver estadísticas jugador 2
////				System.out.println(jugador2);
////				break;
////
////			case 3: //jugador1 ataca a Jugador2
////				jugador1.getPersonajeElegido().ataqueFisico(jugador2.getPersonajeElegido());
////				//moostramos la vida restante del defensor tras el ataque
////				System.out.println("Vida restante de " + jugador2.getNombre()
////				+ " = " + jugador2.getPersonajeElegido().getVida());
////				break;
////
////			case 4: //jugador2 ataca a kugador1
////				jugador1.getPersonajeElegido().ataqueFisico(jugador2.getPersonajeElegido());
////				System.out.println("Vida restante de " + jugador1.getNombre()
////				+ " = " + jugador1.getPersonajeElegido().getVida());
////				break;
////
////			case 5: //abrir tienda para jugador1
////				// abrirTienda() muestra el catalogo y gestiona la compra
////				tiendaControlador.abrirTienda(jugador1);
////				break;
////
////			case 6: //abrir tienda para jugador2
////				tiendaControlador.abrirTienda(jugador2);
////				break;
////
////			case 7: //jugador1 usa una poción de su inventario
////				// abrirInventarioEnBatalla() muestra el inventario y aplica la poción elegida
////				//tiendaControlador.abrirInventarioBatalla(jugador1);
////				break;
////
////			case 8: //jugador2 usa una poción de su inventario
////				//tiendaControlador.abrirInventarioBatalla(jugador2);
////				break;
////
////			} // fin switch
////
////		} while (opcion != 0); // El bucle para cuando se elige "salir"
////
////		System.out.println("*********** FIN DEL PROGRAMA ************");
//	}
//
//}