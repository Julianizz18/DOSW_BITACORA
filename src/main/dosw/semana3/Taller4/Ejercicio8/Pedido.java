package main.dosw.semana3.Taller4.Ejercicio8;

import java.util.*;
public class Pedido {
    private final String tamano,proteina,direccion;
    private final double valorTotal;
    private final List<String> extras,acompanantes;
    private List<ObservadorPedido> obs=new ArrayList<>();
    Pedido(ConstructorPedido b){
        tamano=b.tamano;
        proteina=b.proteina;
        extras=new ArrayList<>(b.extras);
        acompanantes=new ArrayList<>(b.acompanantes);
        direccion=b.direccion;
        valorTotal=b.valorTotal;
    }
    public void agregarObservador(ObservadorPedido o){
        obs.add(o);
    }
    public void confirmar(){
        System.out.println("\nConfirmando pedido...");
        for(ObservadorPedido o:obs) o.alConfirmar(this);
        System.out.println("Pedido confirmado.");
    }
    public String resumen(){
        return tamano+"/"+proteina+"/extras:"+extras+"/acomp:"+acompanantes;
    }
    public double getValorTotal(){
        return valorTotal;
    }
    public String getDireccion(){
        return direccion;
    }
}
