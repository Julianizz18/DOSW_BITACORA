package main.dosw.semana3.Taller4.Ejercicio2;

public class EventoPedido {
    private String idPedido, estado;
    public EventoPedido(String id, String e) { idPedido=id; estado=e; }
    public String getIdPedido() { return idPedido; }
    public String getEstado()   { return estado; }
}
