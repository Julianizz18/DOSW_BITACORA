package main.dosw.semana3.Taller4.Ejercicio8;

import java.util.*;
public class ConstructorPedido {
    String tamano="NORMAL",proteina="Res",direccion="Recoger"; double valorTotal=12000;
    List<String> extras=new ArrayList<>(),acompanantes=new ArrayList<>();
    public ConstructorPedido conTamano(String t){tamano=t;return this;}
    public ConstructorPedido conProteina(String p){proteina=p;return this;}
    public ConstructorPedido conDireccion(String d){direccion=d;return this;}
    public ConstructorPedido conValor(double v){valorTotal=v;return this;}
    public ConstructorPedido agregarExtra(String e){extras.add(e);return this;}
    public ConstructorPedido agregarAcompanante(String a){acompanantes.add(a);return this;}
    public Pedido construir(){ return new Pedido(this); }
}
