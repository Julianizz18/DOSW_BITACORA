package main.dosw.semana3.Taller4.Ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Reportes Empresariales");
        System.out.println("Formatos disponibles: PDF, EXCEL, CSV");

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nFormato del reporte (o 'salir'): ");
            String formato = sc.nextLine().trim();
            if (formato.equalsIgnoreCase("salir")) { continuar = false; continue; }

            System.out.print("Nombre del archivo de salida: ");
            String archivo = sc.nextLine().trim();

            try {
                System.out.println("Configurando reporte " + formato.toUpperCase() + ":");
                PlantillaReporte reporte = CreadorReporte.crear(formato, archivo, sc);
                System.out.println("Ejecutando pipeline:");
                reporte.ejecutar();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
