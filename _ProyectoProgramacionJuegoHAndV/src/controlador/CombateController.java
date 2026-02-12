package controlador;

import modelo.Jugador;
import modelo.Personaje;

public class CombateController {
	private Jugador jugador1;
	private Jugador jugador2;
	
	
	public CombateController(Jugador jugador1, Jugador jugador2) {
		
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}


	public void atacar (Jugador atacante, Jugador defensor) {
		Personaje pAtacante = atacante.getPersonajeElegido();
		Personaje pDefensor = defensor.getPersonajeElegido();
		
		double daño = pAtacante.ataqueFisico(pDefensor);
		pDefensor.setVida(pDefensor.getVida() - daño);
		
	}
}
