package vista;
/**
 * Clase para imprimir mensajes, mostrar menu y mostrar el inventario
 */
import modelo.Jugador;

public interface JuegoVista {
	public void mostrarMensaje(String mensaje);
	public int mostrarMenu (String[] menu, String jugadorAjugar);
	public void mostrarInventario(Jugador jugador);
}
