package aplicacion;

import controlador.CombateController;
import modelo.Jugador;
import modelo.PersonajeFuerza;
import modelo.Personaje;
import modelo.PersonajeInteligencia;
import modelo.PersonajeResistencia;
import modelo.PersonajeVelocidad;
import vista.JuegoVistaConsola;

public class MainPrueba {

	public static void main(String[] args) {
		// prueba git
		// Creamos Jugadores con sus personajes 
		Jugador jugador1 = new Jugador("Mariano", new PersonajeFuerza(), 33);
		Jugador jugador2 = new Jugador("Eder", new PersonajeInteligencia(), 22);
		/*System.out.println(jugador1+"\n"
				+"=====================\n"
				+jugador2);*/
		// Crear vista
		JuegoVistaConsola vista = new JuegoVistaConsola();
		// Creamos el controller
		CombateController juegoControlador = new CombateController(jugador1, jugador2,
				vista);
		
		// Iniciamos juego
		System.out.println("********** INCIO DEL JUEGO *********");
		juegoControlador.iniciarCombate();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println("Inicio juego ==============================");
//		// Probamos el sistema de ataque
//		// Menu de prueba
//		int opcion;
//		String[] menu= {"Salir","Mostrar estadisticas de "+jugador1.getNombre(), 
//				"Mostrar estadisticas de "+jugador2.getNombre(), "Atacar jugador2", "Atacar jugador1"};
//		do {
//			opcion=CrearMenuPrueba.mostrarMenu(menu);
//			switch(opcion) {
//			case 1: // Mostrar info jugador1
//				System.out.println(jugador1+"\n"
//						+"================\n");
//				break;
//			case 2: // Mostrar info jugador2
//				System.out.println(jugador2+"\n"
//						+"================\n");
//				break;
//			case 3: // Atacar a jugador2
//				juegoControlador.atacar(jugador1, jugador2);
//				System.out.println("Vida restante jugador 2 = "+jugador2.getPersonajeElegido().getVida());
//				break;
//			case 4: // Atacar a jugador1
//				juegoControlador.atacar(jugador2, jugador1);
//				System.out.println("Vida restante jugador 1 = "+jugador1.getPersonajeElegido().getVida());
//				break;
//			}//fin-switch
//			
//		}while (opcion!=0);
//		System.out.println("FIN PROGRAMA");
		
	}
}
