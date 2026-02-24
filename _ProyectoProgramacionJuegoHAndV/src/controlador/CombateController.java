package controlador;

import modelo.Jugador;
import modelo.Personaje;
import vista.CrearMenuPrueba;
/**
 * Clase que controla la logica de la batalla
 */
public class CombateController {
	private Jugador jugador1;
	private Jugador jugador2;
	private CrearMenuPrueba vista;
	
	/**
	 * Constructor de clase
	 * @param jugador1
	 * @param jugador2
	 * @param vista
	 */
	public CombateController(Jugador jugador1, Jugador jugador2, CrearMenuPrueba vista) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.vista = vista;
	}
	/**
	 * Metodo para iniciar un combate
	 */
	public void iniciarCombate() {
		
		Personaje p1 = jugador1.getPersonajeElegido();
		Personaje p2 = jugador2.getPersonajeElegido();
		
		Jugador jugadorAtacante;
		Jugador jugadorDefensor;
		
		if (p1.getStatVelocidad() >= p2.getStatVelocidad()) { // Condicion de orden de inicio
			jugadorAtacante = jugador1;
			jugadorDefensor = jugador2;
		} else {
			jugadorAtacante = jugador2;
			jugadorDefensor = jugador1;
		}
		// Variable para eleccion
		int opcion;
		// Cadenas de texto a imprimir 
		String[] menu = {"Salir","Mostrar estadisticas de "+jugador1.getNombre(), 
				"Mostrar estadisticas de "+jugador2.getNombre(), "Ataque", "Usar objeto"};
		String[] subMenuAtaques = {"Volver","Ataque fisico", "Ataque magico", "Movimiento especial"};
		String[] subMenuObjetos = {"No implementado"};
		
		do {
			// Asignamos los personajes de los jugadores
			Personaje atacante = jugadorAtacante.getPersonajeElegido();
			Personaje defensor = jugadorDefensor.getPersonajeElegido();
			// Variable para cambiar el turno
			boolean cambiarTurno = true;
			// Variable de seleccion, mostrando el menu
			opcion = vista.mostrarMenu(menu, jugadorAtacante.getNombre());
			
			switch (opcion) {
			case 1: // Mostrar estadisticas de personaje de jugador 1
				System.out.println(jugador1+"\n"
						+"================\n");
				cambiarTurno = false;
				break;
			case 2: // Mostrar estadisticas de personaje de jugador 2
				System.out.println(jugador2+"\n"
						+"================\n");
				cambiarTurno = false;
				break;
			case 3: // Ataque
				// Variable de selecion de tipo de ataque
				int subOpcionAtaque = vista.mostrarMenu(subMenuAtaques, jugadorAtacante.getNombre());
				switch (subOpcionAtaque) {
				case 0: // Volver
					cambiarTurno = false;
					break;
				case 1: // Ataque fisico
					double danyoFisico = atacante.ataqueFisico(defensor); 
					defensor.recibirDanyo(danyoFisico);
					System.out.println("Tu ataque fisico ha hecho "+danyoFisico+ " de daño a tu enemigo");
					break;
				case 2: // Ataque mágico
					double danyoMagico = atacante.ataqueMagico(defensor);
					defensor.recibirDanyo(danyoMagico);
					System.out.println("Tu ataque magico ha hecho "+danyoMagico+ " de daño a tu enemigo");
					break;
				case 3: // Movimiento especial
					System.out.println("Aun no implementado");
					break;
				}
				break;
			case 4: // Usar objeto
				int subOpcionObjetos = vista.mostrarMenu(subMenuObjetos, jugadorAtacante.getNombre());
				break;
			}
			if (cambiarTurno == true) {
				// Intercambiar turnos
				Jugador temp = jugadorAtacante;
				jugadorAtacante = jugadorDefensor;
				jugadorDefensor = temp;
			}
			
		} while ((p1.estaVivo() && p2.estaVivo()) && opcion != 0);
		if (opcion == 0) {
			System.out.println("Has salido de la partida");
		}
		if (!p2.estaVivo()) {
			System.out.println(jugador1.getNombre()+" gana");
		} else {
			System.out.println(jugador2.getNombre()+" gana");
		}
	}
	
}
