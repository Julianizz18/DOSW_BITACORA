package main.dosw.semana3.Taller4.Ejercicio2;

public class ConstructorPush implements ConstructorMensaje {
    public String construir(EventoPedido e) {
        return "{\"pedido\":\""+e.getIdPedido()+"\",\"estado\":\""+e.getEstado()+"\"}";
    }
}
