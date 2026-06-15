package main.dosw.semana3.Taller4.Ejercicio2;

public class ConstructorSms implements ConstructorMensaje {
    public String construir(EventoPedido e) { String m="Pedido "+e.getIdPedido()+": "+e.getEstado(); return m.length()>160?m.substring(0,160):m; }
}
