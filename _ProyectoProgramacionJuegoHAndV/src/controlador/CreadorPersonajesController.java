package controlador;
import excepciones.JugadorNuloExcepcion;
import excepciones.ValorFueraRangoExcepcion;
//crear jugadores hecho pero hay fallo en la tienda)
import modelo.Jugador;
import modelo.Personaje;
import modelo.PersonajeFuerza;
import modelo.PersonajeInteligencia;
import modelo.PersonajePersonalizado;
import modelo.PersonajeResistencia;
import modelo.PersonajeVelocidad;
import utilidades.Leer;
import vista.JuegoVista;

/**
 * clase que controla la geston de crear jugadores al iniciar el juego
 * 
 * pide el nombre que se quiere poner el usuario
 * eleccion entre personaje con stats predeterminads o personalizar stats con los repartos
 * de puntos a cada stats
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class CreadorPersonajesController {
	
	private JuegoVista vista;

	/**
	 * puntos a repartir entre las stats de personalizacion
	 */
	private static final int REPARTIR_PUNTOS = 50;

	/**
	 * puntos minimos que puede tener una stt
	 */
	private static final int MIN_PTS_STAT = 1;

	/**
	 * vida que va a tener todos los personajes personalizados
	 * 2 opciones, o añadimos mas puntos en REPARTIR_PUNTOS 
	 * o menos puntos a repartir y dejamos la vida fija
	 */
	private static final double VIDA_CUSTOM = 100.0;

	private static final int MONEDAS_INICIALES = 100;
	/**
	 * metodo para crear el jugador, pide:
	 * nombre
	 * muestra opciones
	 * crea el jugador
	 * devuelve el jugador creado al completo
	 * 
	 * 
	 */
	public CreadorPersonajesController(JuegoVista vista) {
		this.vista = vista;
	}
	public Jugador crearJugador() throws JugadorNuloExcepcion {

		//mensaje de bienvenida + pedir nombre
		String nombre = Leer.leerFrase("----BIENVENIDOS A H & V---- \n"
				+ "¿como quieres que se"
				+ " llame tu personaje del juego?");

		vista.mostrarMensaje("hola " + nombre + ", ahora elige tu tipo de personaje");

		//elegir el tipo de personaje
		//creamos un array de Strings para poner el tipo de personaje
		String[] menuTipo = {
				"salir", //0
				"personaje predeterminado", //1
				"crear personaje" //2
		};

		int opcionTipo = 0;
		
		boolean valorCorrecto = false;
		
		//bucle
		while (!valorCorrecto) {
			vista.mostrarMensaje("¿que tipo de personaje quieres?");
			//recorremos el array
			for (int i = 0; i < menuTipo.length; i++) {
				vista.mostrarMensaje(i + ". " + menuTipo[i]);
			}
			try {
				opcionTipo = Leer.leerEntero("elige una opcion: ");
				if (opcionTipo > menuTipo.length - 1 || opcionTipo < 0) {
					throw new ValorFueraRangoExcepcion("La opcion tiene que estar entre "
							+(menuTipo.length - 1)+" y 0");
				}
				valorCorrecto = true;
			} catch (ValorFueraRangoExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
			}
			
		} 

		//crear personaje 
		Personaje personaje;

		//que opcion quiere el jugador
		if (opcionTipo == 1) {
			// personaje predeterminado
			personaje = elegirPersonajePredefinido();
			Jugador jugador = new Jugador(nombre, personaje, MONEDAS_INICIALES);

			//crear el personaje y devolver el jugador
			//nombre y personaje creados
			//(crear jugadores hecho pero hay fallo en la tienda)

			vista.mostrarMensaje("--PERSONAJE CREADO--");
			return jugador;	


		} else if (opcionTipo == 2){
			
			try {
				//personaje custom
				personaje = elegirPersonajeCustom();
			} catch (ValorFueraRangoExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
				return null;
			}

			Jugador jugador = new Jugador(nombre, personaje, MONEDAS_INICIALES);

			//crear el personaje y devolver el jugador
			//nombre y personaje creados
			//(crear jugadores hecho pero hay fallo en la tienda)

			vista.mostrarMensaje("--PERSONAJE CREADO--");
			return jugador;	
			
		} else {
			vista.mostrarMensaje("Has salido del juego");
			throw new JugadorNuloExcepcion("El jugador ha cancelado la creacion");
		} 
	}
	/**
	 * metodo personaje predefinido 
	 */
	private Personaje elegirPersonajePredefinido() {
		vista.mostrarMensaje("PERSONAJES PREDEFINIDOS");

		vista.mostrarMensaje("1. tipo fuerza");
		vista.mostrarMensaje("2. tipo inteligencia");
		vista.mostrarMensaje("3. tipo resistencia");
		vista.mostrarMensaje("4. tipo velocidad");

		int opcion;

		//bucle hasta que elija uno de los 4
		do {
			
			opcion = Leer.leerEntero("elige tu personaje (1-4):");

		} while (opcion < 1 || opcion > 4);

		switch(opcion) {
		case 1: 
			//eleccion personaje fuerza
			vista.mostrarMensaje("has elegido de tipo fuerza");
			return new PersonajeFuerza();

		case 2:
			//eleccion personaje inteligencia
			vista.mostrarMensaje("has elegido tipo inteligencia");
			return new PersonajeInteligencia();

		case 3:
			//eleccion personaje resistencia
			vista.mostrarMensaje("has elegido tipo resistencia");
			return new PersonajeResistencia();

		case 4: 
			//eleccion velocidad
			vista.mostrarMensaje("has elegido tipo velocidad");
			return new PersonajeVelocidad();

		default:
			vista.mostrarMensaje("opcion no valida, asignando fuerza por defecto");
			return new PersonajeFuerza();
		}
	}

	/**
	 * permite crear un personaje con caracterisiticas custom
	 * @throws ValorFueraRangoExcepcion 
	 * 
	 */
	private Personaje elegirPersonajeCustom() throws ValorFueraRangoExcepcion {
		vista.mostrarMensaje("--CREA TU PERSONAJE--");


		vista.mostrarMensaje("tienes " + REPARTIR_PUNTOS + " puntos a repartir entre tus stats");
		vista.mostrarMensaje("cada stat tiene que tener minimo " + MIN_PTS_STAT + " punto");
		vista.mostrarMensaje("al crearlo personalizado tienes " + VIDA_CUSTOM + " HP");

		// variable que cuenta los puntos que le quedan al usuario
		int puntosRestantes = REPARTIR_PUNTOS;

		// variables para cada stat
		double statAtaque = 0;
		double statDefensa = 0;
		double statInteligencia = 0;
		double statFuerza = 0;
		double statVelocidad = 0;
		double statResistencia = 0;

		// array con los nombres de las stats
		String[] nombresStats = {
				"ataque",       // 0
				"defensa",      // 1
				"inteligencia", // 2
				"fuerza",       // 3
				"velocidad",    // 4
				"resistencia"   // 5
		};

		// array para guardar los valores que elija el usuario
		double[] valoresStats = new double[6];

		// recorremos las 6 stats
		for (int i = 0; i < nombresStats.length; i++) {

			// numero de stats que quedan DESPUES de esta (no contando la actual)
			int statsRestantes = nombresStats.length - 1 - i;

			int maxAsignar = puntosRestantes - (statsRestantes * MIN_PTS_STAT);

			// guarda los pts que asigna a una stat
			int puntosAsignados = 0;
			
			boolean valorCorrecto = false;

			while (!valorCorrecto) {
				// muestra cuantos pts quedan
				vista.mostrarMensaje("puntos restantes: " + puntosRestantes +"\n");
				
				try {
					// pedir los puntos para esta stat
					puntosAsignados = Leer.leerEntero("puntos para " + nombresStats[i]
							+ " (min: " + MIN_PTS_STAT + ", max: " + maxAsignar + "):");
	
					// si el valor no es valido se repite el bucle
					if (puntosAsignados < MIN_PTS_STAT || puntosAsignados > maxAsignar) {
						throw new ValorFueraRangoExcepcion(
						        "Los puntos deben estar entre " + MIN_PTS_STAT + " y " + maxAsignar
						    );
					}
					valorCorrecto = true;
				} catch (ValorFueraRangoExcepcion e) {
					vista.mostrarMensaje(e.getMessage());
				}
					
			} 

			// guardamos el valor en el array en la posicion i, casteado a double
			valoresStats[i] = (double) puntosAsignados;
			
			// Imprimir valores asignados al array correspondientes con su estadistica
			vista.mostrarMensaje("stats actuales: \n" 
					+ nombresStats[0] + " -> " + valoresStats[0] + " puntos\n"
					+ nombresStats[1] + " -> " + valoresStats[1] + " puntos\n"
					+ nombresStats[2] + " -> " + valoresStats[2] + " puntos\n"
					+ nombresStats[3] + " -> " + valoresStats[3] + " puntos\n"
					+ nombresStats[4] + " -> " + valoresStats[4] + " puntos\n"
					+ nombresStats[5] + " -> " + valoresStats[5] + " puntos\n");

			// restamos los puntos usados del disponible
			puntosRestantes -= puntosAsignados;

			// confirmacion
			// vista.mostrarMensaje(nombresStats[i] + " -> " + puntosAsignados + " puntos");
		}

		// asignar variables desde el array
		statAtaque       = valoresStats[0];
		statDefensa      = valoresStats[1];
		statInteligencia = valoresStats[2];
		statFuerza       = valoresStats[3];
		statVelocidad    = valoresStats[4];
		statResistencia  = valoresStats[5];

		// resumen de las stats
		vista.mostrarMensaje("----RESUMEN DE TU PERSONAJE----");
		vista.mostrarMensaje("vida : " + VIDA_CUSTOM);

		for (int i = 0; i < nombresStats.length; i++) {
			vista.mostrarMensaje(nombresStats[i] + ": " + valoresStats[i]);
		}

		// creamos y devolvemos el personaje custom
		return new PersonajePersonalizado(
				VIDA_CUSTOM,
				statAtaque,
				statDefensa,
				statInteligencia,
				statFuerza,
				statVelocidad,
				statResistencia
				);

		
		//(crear jugadores hecho pero hay fallo en la tienda)
	}


}
