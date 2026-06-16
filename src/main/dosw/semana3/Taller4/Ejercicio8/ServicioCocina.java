package main.dosw.semana3.Taller4.Ejercicio8;

public class ServicioCocina implements ObservadorPedido { public void alConfirmar(Pedido p){ System.out.println("  [Cocina]   Orden: "+p.resumen()); } }
