package main.dosw.semana3.Taller4.Ejercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Integracion con Sistema de Impresion Legado");

        System.out.print("Modelo de impresora (ej: Epson LX-300): ");
        String modelo = sc.nextLine().trim();

        System.out.println("\nInicializando driver de impresion...");
        FachadaImpresion fachada = new FachadaImpresion(modelo);
        fachada.verEstado();

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nTexto a imprimir (o 'salir'): ");
            String texto = sc.nextLine().trim();
            if (texto.equalsIgnoreCase("salir")) { continuar = false; continue; }

            System.out.print("Numero de copias: ");
            int copias = Integer.parseInt(sc.nextLine().trim());

            fachada.enviarDocumento(texto, copias);
            System.out.println();
            fachada.verEstado();
        }
        sc.close();
    }
}
