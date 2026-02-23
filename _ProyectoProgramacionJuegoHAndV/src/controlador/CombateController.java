package controlador;

import modelo.Jugador;
import modelo.Personaje;
/**
 * Clase que controla la logica de la batalla
 */
public class CombateController {
	private Jugador jugador1;
	private Jugador jugador2;
	
	
	public CombateController(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}

	public void iniciarCombate() {
		
		Personaje p1 = jugador1.getPersonajeElegido();
		Personaje p2 = jugador2.getPersonajeElegido();
		
		Personaje atacante;
		Personaje defensor;
		
		if (p1.getStatVelocidad() >= p2.getStatVelocidad()) {
			atacante = p1;
			defensor = p2;
		} else {
			atacante = p2;
			defensor = p1;
		}
		
		while (p1.estaVivo() && p2.estaVivo()) {
			
			double danyo = atacante.ataqueFisico(defensor);
			defensor.recibirDanyo(danyo);
			
			// Intercambiar turnos
			Personaje temp = atacante;
			atacante = defensor;
			defensor = temp;
			
			if (!p2.estaVivo()) {
				System.out.println(jugador1.getNombre()+" gana");
			} else {
				System.out.println(jugador2.getNombre()+" gana");
			}
		}
	}
	
}
