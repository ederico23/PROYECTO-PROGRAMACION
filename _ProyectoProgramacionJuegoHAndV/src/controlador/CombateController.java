package controlador;

import excepciones.JugadorNuloExcepcion;
import excepciones.ObjetoInventarioInvalidoExcepcion;
import excepciones.ValorFueraRangoExcepcion;
import modelo.Jugador;
import modelo.Personaje;
import utilidades.Leer;
import vista.JuegoVistaConsola;

/**
 * Clase que controla la logica de la batalla
 */
public class CombateController {
	private Jugador jugador1;
	private Jugador jugador2;
	private JuegoVistaConsola vista;
	
	/**
	 * Constructor de clase
	 * @param jugador1
	 * @param jugador2
	 * @param vista
	 */
	public CombateController(Jugador jugador1, Jugador jugador2, JuegoVistaConsola vista) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.vista = vista;
	}
	
	/**
	 * Metodo para iniciar un combate
	 * @throws JugadorNuloExcepcion 
	 */
	public void iniciarCombate() throws JugadorNuloExcepcion {
		
		if (jugador1 == null || jugador2 == null) {
			throw new JugadorNuloExcepcion("No se puede iniciar combate sin jugadores");
		}
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
		String[] menu = {
				"Salir",
				"Mostrar estadisticas de "+jugador1.getNombre(), 
				"Mostrar estadisticas de "+jugador2.getNombre(), 
				"Ataque", 
				"Usar objeto"};
		
		do {
			// Asignamos los personajes de los jugadores
			Personaje atacante = jugadorAtacante.getPersonajeElegido();
			Personaje defensor = jugadorDefensor.getPersonajeElegido();
			
			// Variable para cambiar el turno
			boolean cambiarTurno = false;
			
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
				
				cambiarTurno = ejecutarAtaque(atacante, defensor, jugadorAtacante.getNombre());
				break;
			
			case 4: // Usar objeto
				vista.mostrarInventario(jugadorAtacante);
				
				int subOpcionObjetos = Leer.leerEntero("Elige la pocion que quieras usar.\n"
						+ "Para volver escriba 0");
				if (subOpcionObjetos == 0) {
					cambiarTurno = false;
					break;
				}
				try {
					if (jugadorAtacante.usarObjeto(subOpcionObjetos)){
						cambiarTurno = true;
					}
				} catch (ObjetoInventarioInvalidoExcepcion e) {
					vista.mostrarMensaje(e.getMessage());
					cambiarTurno = false;
				}
				break;
			}
			
			if (cambiarTurno) {
				// Intercambiar turnos
				Jugador temp = jugadorAtacante;
				jugadorAtacante = jugadorDefensor;
				jugadorDefensor = temp;
			}
			
		} while ((p1.estaVivo() && p2.estaVivo()) && opcion != 0);
		
		if (opcion == 0) {
			System.out.println("Has salido de la partida");
		}
		if (!p1.estaVivo()) {
			System.out.println(jugador2.getNombre()+" gana");
		} else if (!p2.estaVivo()){
			System.out.println(jugador1.getNombre()+" gana");
		}
	}
	/**
	 * Ejecutar el ataque
	 * 
	 * @param atacante
	 * @param defensor
	 * @param nombreJugador
	 * @return
	 * @throws ValorFueraRangoExcepcion 
	 */
	private boolean ejecutarAtaque(Personaje atacante, Personaje defensor, String nombreJugador) {

	    String[] subMenuAtaques = {
	        "Volver",
	        "Ataque fisico",
	        "Ataque magico",
	        "Movimiento especial"
	    };

	    int opcion = vista.mostrarMenu(subMenuAtaques, nombreJugador);
	    
	    switch (opcion) {

	        case 1:
	            double danyoFisico = atacante.ataqueFisico(defensor);
	            defensor.recibirDanyo(danyoFisico);
	            vista.mostrarMensaje("Ataque físico: " + danyoFisico + " de daño");
	            return true;

	        case 2:
	            double danyoMagico = atacante.ataqueMagico(defensor);
	            defensor.recibirDanyo(danyoMagico);
	            vista.mostrarMensaje("Ataque mágico: " + danyoMagico + " de daño");
	            return true;

	        case 3:
	            vista.mostrarMensaje("Movimiento especial aún no implementado");
	            return false;

	        default:
	            return false;
	    }
	}
	
}
