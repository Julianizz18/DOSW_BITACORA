package main.dosw.semana3.Taller4.Ejercicio1;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plataforma de Pagos Inteligentes");
        System.out.print("Ingrese su pais (colombia / usa): ");
        String pais = sc.nextLine().trim();
        FabricaPagos fabrica;
        try { fabrica = SelectorFabrica.obtener(pais); }
        catch (IllegalArgumentException e) { System.out.println("Error: "+e.getMessage()); sc.close(); return; }
        System.out.println(pais.equalsIgnoreCase("colombia") ? "Metodos: pse, nequi, tarjeta" : "Metodos: paypal, stripe");
        System.out.print("Elija metodo de pago: ");
        String metodo = sc.nextLine().trim();
        System.out.print("Monto a pagar: $");
        double monto = Double.parseDouble(sc.nextLine().trim());
        try { new ProcesadorCompra(fabrica.crear(metodo)).finalizarCompra(monto); }
        catch (IllegalArgumentException e) { System.out.println("Error: "+e.getMessage()); }
        sc.close();
    }
}
