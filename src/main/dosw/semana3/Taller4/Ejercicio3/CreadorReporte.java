package main.dosw.semana3.Taller4.Ejercicio3;

import java.util.Scanner;


public class CreadorReporte {

    public static PlantillaReporte crear(String formato, String archivo, Scanner sc) {
        switch (formato.toUpperCase()) {
            case "PDF": {
                System.out.print("Incluir portada? (s/n):");
                boolean portada = sc.nextLine().trim().equalsIgnoreCase("s");
                System.out.print(" Margen en mm (ej: 25):");
                int margen = Integer.parseInt(sc.nextLine().trim());
                return new ReportePDF(archivo, portada, margen);
            }
            case "EXCEL": {
                System.out.print("Numero de hojas (1-5):");
                int hojas = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Incluir graficos? (s/n):");
                boolean graficos = sc.nextLine().trim().equalsIgnoreCase("s");
                return new ReporteExcel(archivo, hojas, graficos);
            }
            case "CSV": {
                System.out.print("Separador (, o ;):");
                char sep = sc.nextLine().trim().charAt(0);
                System.out.print("Incluir fila de cabecera? (s/n):");
                boolean cabecera = sc.nextLine().trim().equalsIgnoreCase("s");
                return new ReporteCSV(archivo, sep, cabecera);
            }
            default:
                throw new IllegalArgumentException("Formato no soportado: " + formato);
        }
    }
}
