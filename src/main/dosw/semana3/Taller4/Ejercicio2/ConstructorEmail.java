package main.dosw.semana3.Taller4.Ejercicio2;

public class ConstructorEmail implements ConstructorMensaje {
    public String construir(EventoPedido e) {
        return "<html><p>Pedido <b>"+e.getIdPedido()+"</b> -> <b>"+e.getEstado()+"</b></p></html>";
    }
}
