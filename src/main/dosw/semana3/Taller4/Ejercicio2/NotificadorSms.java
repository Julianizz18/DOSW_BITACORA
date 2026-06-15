package main.dosw.semana3.Taller4.Ejercicio2;

public class NotificadorSms implements ObservadorNotificacion {
    private ConstructorMensaje c = new ConstructorSms();
    public void actualizar(EventoPedido e) { System.out.println("[SMS]   "+c.construir(e)); }
}
