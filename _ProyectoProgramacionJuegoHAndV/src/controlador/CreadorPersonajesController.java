package controlador;
import excepciones.JugadorNuloExcepcion;
import excepciones.ValorFueraRangoExcepcion;
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
 * Clase que controla la geston de crear jugadores al iniciar el juego
 * -Pide el nombre que se quiere poner el usuario
 * -Eleccion entre personaje con stats predeterminads o personalizar stats con los repartos de puntos a cada stats
 * 
 * @author Mariano, Eder
 * @version 1.0
 */
public class CreadorPersonajesController {
	
	private JuegoVista vista;

	/**
	 * Puntos a repartir entre las stats de personalizacion
	 */
	private static final int REPARTIR_PUNTOS = 50;

	/**
	 * Puntos minimos que puede tener una stt
	 */
	private static final int MIN_PTS_STAT = 1;

	/**
	 * Vida que va a tener todos los personajes personalizados
	 */
	private static final double VIDA_CUSTOM = 100.0;
	/**
	 * Monedas iniciales que tendrá el jugador creado
	 */
	private static final int MONEDAS_INICIALES = 100;
	

	/**
	 * Constructor
	 * 
	 * @param vista
	 */
	public CreadorPersonajesController(JuegoVista vista) {
		this.vista = vista;
	}
	
	/**
	 * Metodo para crear el jugador, pide:
	 * -Nombre
	 * -Muestra opciones
	 * -Crea el jugador
	 * -Devuelve el jugador creado al completo
	 */
	public Jugador crearJugador() throws JugadorNuloExcepcion {

		//mensaje de bienvenida + pedir nombre
		String nombre = Leer.leerFrase("----BIENVENIDO A H & V---- \n"
				+ "\n¿Como quieres que se"
				+ " llame tu personaje del juego?");

		vista.mostrarMensaje("\nHola " + nombre + ", ahora elige tu tipo de personaje");

		//Elegir el tipo de personaje
		//Array de Strings para poner el tipo de personaje
		String[] menuTipo = {
				"Salir", //0
				"Personaje predeterminado", //1
				"Crear personaje" //2
		};

		int opcionTipo = 0;
		
		boolean valorCorrecto = false;
		
		while (!valorCorrecto) {
			
			vista.mostrarMensaje("\n¿Que tipo de personaje quieres?");
			//recorremos el array
			
			for (int i = 0; i < menuTipo.length; i++) {
				vista.mostrarMensaje(i + ". " + menuTipo[i]);
			}
			try {
				opcionTipo = Leer.leerEntero("\nElige una opcion: ");
				if (opcionTipo > menuTipo.length - 1 || opcionTipo < 0) {
					throw new ValorFueraRangoExcepcion("\nLa opcion tiene que estar entre "
							+(menuTipo.length - 1)+" y 0");
				}
				valorCorrecto = true;
			} catch (ValorFueraRangoExcepcion e) {
				vista.mostrarMensaje(e.getMessage());
			}
			
		} 

		Personaje personaje;

		if (opcionTipo == 1) {
			// personaje predeterminado
			personaje = elegirPersonajePredefinido();
			Jugador jugador = new Jugador(nombre, personaje, MONEDAS_INICIALES);
			vista.mostrarMensaje("\n--PERSONAJE CREADO--");
			
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
			vista.mostrarMensaje("\n--PERSONAJE CREADO--");
			
			return jugador;	
		} else {
			vista.mostrarMensaje("\nHas salido del juego");
			throw new JugadorNuloExcepcion("\nEl jugador ha cancelado la creacion");
		} 
	}
	
	/**
	 * Metodo personaje predefinido 
	 * @return Personaje personaje elegido
	 */
	private Personaje elegirPersonajePredefinido() {
		vista.mostrarMensaje("\nPERSONAJES PREDEFINIDOS");

		vista.mostrarMensaje("1. Tipo fuerza");
		vista.mostrarMensaje("2. Tipo inteligencia");
		vista.mostrarMensaje("3. Tipo resistencia");
		vista.mostrarMensaje("4. Tipo velocidad");

		int opcion;

		do {
			
			opcion = Leer.leerEntero("\nElige tu personaje (1-4):");

		} while (opcion < 1 || opcion > 4);

		switch(opcion) {
		case 1: 
			//eleccion personaje fuerza
			vista.mostrarMensaje("\nHas elegido de tipo fuerza");
			return new PersonajeFuerza();

		case 2:
			//eleccion personaje inteligencia
			vista.mostrarMensaje("\nHas elegido tipo inteligencia");
			return new PersonajeInteligencia();

		case 3:
			//eleccion personaje resistencia
			vista.mostrarMensaje("\nHas elegido tipo resistencia");
			return new PersonajeResistencia();

		case 4: 
			//eleccion velocidad
			vista.mostrarMensaje("\nHas elegido tipo velocidad");
			return new PersonajeVelocidad();

		default:
			vista.mostrarMensaje("\nOpcion no valida, asignando fuerza por defecto");
			return new PersonajeFuerza();
		}
	}

	/**
	 * Permite crear un personaje con caracterisiticas custom
	 * @throws ValorFueraRangoExcepcion 
	 * @return Personaje el personaje creado
	 */
	private Personaje elegirPersonajeCustom() throws ValorFueraRangoExcepcion {
		vista.mostrarMensaje("\n--CREA TU PERSONAJE--");


		vista.mostrarMensaje("\nTienes " + REPARTIR_PUNTOS + " puntos a repartir entre tus stats");
		vista.mostrarMensaje("Cada stat tiene que tener minimo " + MIN_PTS_STAT + " punto");
		vista.mostrarMensaje("Al crearlo personalizado tienes " + VIDA_CUSTOM + " HP");

		// variable que cuenta los puntos que le quedan al usuario
		int puntosRestantes = REPARTIR_PUNTOS;

		// variables para cada stat
		double statAtaque = 0;
		double statDefensa = 0;
		double statInteligencia = 0;
		double statFuerza = 0;
		double statVelocidad = 0;
		double statResistencia = 0;

		//Array con los nombres de las stats
		String[] nombresStats = {
				"Ataque",       // 0
				"Defensa",      // 1
				"Inteligencia", // 2
				"Fuerza",       // 3
				"Velocidad",    // 4
				"Resistencia"   // 5
		};

		// Array para guardar los valores que elija el usuario
		double[] valoresStats = new double[6];

		// Recorremos las 6 stats
		for (int i = 0; i < nombresStats.length; i++) {

			// numero de stats que quedan DESPUES de esta (no contando la actual)
			int statsRestantes = nombresStats.length - 1 - i;

			int maxAsignar = puntosRestantes - (statsRestantes * MIN_PTS_STAT);

			// Guarda los pts que asigna a una stat
			int puntosAsignados = 0;
			
			boolean valorCorrecto = false;

			while (!valorCorrecto) {
				vista.mostrarMensaje("\nPuntos restantes: " + puntosRestantes +"\n");
				
				try {
					// Pedir los puntos para esta stat
					puntosAsignados = Leer.leerEntero("\nPuntos para " + nombresStats[i]
							+ " (min: " + MIN_PTS_STAT + ", max: " + maxAsignar + "):");
	
					// Si el valor no es valido se repite el bucle
					if (puntosAsignados < MIN_PTS_STAT || puntosAsignados > maxAsignar) {
						throw new ValorFueraRangoExcepcion(
						        "\nLos puntos deben estar entre " + MIN_PTS_STAT + " y " + maxAsignar
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
			vista.mostrarMensaje("Stats actuales: \n" 
					+ nombresStats[0] + " -> " + valoresStats[0] + " puntos\n"
					+ nombresStats[1] + " -> " + valoresStats[1] + " puntos\n"
					+ nombresStats[2] + " -> " + valoresStats[2] + " puntos\n"
					+ nombresStats[3] + " -> " + valoresStats[3] + " puntos\n"
					+ nombresStats[4] + " -> " + valoresStats[4] + " puntos\n"
					+ nombresStats[5] + " -> " + valoresStats[5] + " puntos\n");

			// Restamos los puntos usados del disponible
			puntosRestantes -= puntosAsignados;
		}

		// Asignar variables desde el array
		statAtaque       = valoresStats[0];
		statDefensa      = valoresStats[1];
		statInteligencia = valoresStats[2];
		statFuerza       = valoresStats[3];
		statVelocidad    = valoresStats[4];
		statResistencia  = valoresStats[5];

		// Resumen de las stats
		vista.mostrarMensaje("\n----RESUMEN DE TU PERSONAJE----");
		vista.mostrarMensaje("\nVida : " + VIDA_CUSTOM);

		for (int i = 0; i < nombresStats.length; i++) {
			vista.mostrarMensaje(nombresStats[i] + ": " + valoresStats[i]);
		}

		// Creamos y devolvemos el personaje custom
		return new PersonajePersonalizado(
				VIDA_CUSTOM,
				statAtaque,
				statDefensa,
				statInteligencia,
				statFuerza,
				statVelocidad,
				statResistencia
				);
	}
}
