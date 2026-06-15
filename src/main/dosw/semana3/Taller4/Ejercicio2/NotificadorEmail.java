package main.dosw.semana3.Taller4.Ejercicio2;

public class NotificadorEmail implements ObservadorNotificacion {
    private ConstructorMensaje c = new ConstructorEmail();
    public void actualizar(EventoPedido e) { System.out.println("[EMAIL] "+c.construir(e)); }
}
