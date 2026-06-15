package main.dosw.semana3.Taller4.Ejercicio2;

import java.util.*;
public class Pedido {
    private String id, estado;
    private List<ObservadorNotificacion> observadores = new ArrayList<>();
    public Pedido(String id) { this.id=id; this.estado="PENDIENTE"; }
    public void agregarObservador(ObservadorNotificacion o) { observadores.add(o); }
    public void cambiarEstado(String nuevoEstado) {
        this.estado=nuevoEstado;
        System.out.println("\n-- Pedido "+id+" -> "+estado+" --");
        EventoPedido ev = new EventoPedido(id, estado);
        for (ObservadorNotificacion o : observadores) o.actualizar(ev);
    }
}
