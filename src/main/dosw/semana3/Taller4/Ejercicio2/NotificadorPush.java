package main.dosw.semana3.Taller4.Ejercicio2;

public class NotificadorPush implements ObservadorNotificacion {
    private ConstructorMensaje c = new ConstructorPush();
    public void actualizar(EventoPedido e) { System.out.println("[PUSH]  "+c.construir(e)); }
}
