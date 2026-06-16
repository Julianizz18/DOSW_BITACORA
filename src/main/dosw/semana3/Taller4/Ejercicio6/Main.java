package main.dosw.semana3.Taller4.Ejercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Motor de Monitoreo de Servidores ");
        PanelMonitoreo panel = new PanelMonitoreo();
        System.out.print("Email del administrador para alertas:");
        String email = sc.nextLine().trim();
        System.out.print("Nombre del archivo de log: ");
        String logFile = sc.nextLine().trim();
        panel.agregarObservador(new MonitorConsola());
        panel.agregarObservador(new MonitorEmail(email));
        panel.agregarObservador(new MonitorLog(logFile));
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n Menu");
            System.out.println("1. Ingresar metricas del servidor");
            System.out.println("2. Cambiar algoritmo de deteccion");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            String op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    System.out.print("Nombre del servidor: ");
                    String srv = sc.nextLine().trim();
                    System.out.print("CPU% (ej: 75.5): ");
                    double cpu = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("Memoria% (ej: 60.0): ");
                    double mem = Double.parseDouble(sc.nextLine().trim());
                    System.out.print("Disco% (ej: 45.0): ");
                    double disco = Double.parseDouble(sc.nextLine().trim());
                    panel.recibirMetrica(new MetricaServidor(srv, cpu, mem, disco));
                    break;

                case "2":
                    System.out.println("Algoritmos: umbral, promedio, combinado");
                    System.out.print("Algoritmo: ");
                    String alg = sc.nextLine().trim().toLowerCase();
                    switch (alg) {
                        case "umbral":
                            System.out.print("Umbral CPU%: ");    double uc = Double.parseDouble(sc.nextLine().trim());
                            System.out.print("Umbral Mem%: ");    double um = Double.parseDouble(sc.nextLine().trim());
                            System.out.print("Umbral Disco%: "); double ud = Double.parseDouble(sc.nextLine().trim());
                            panel.cambiarAlgoritmo(new DeteccionUmbral(uc, um, ud));
                            break;
                        case "promedio":
                            System.out.print("  Umbral promedio%: "); double up = Double.parseDouble(sc.nextLine().trim());
                            panel.cambiarAlgoritmo(new DeteccionPromedio(up));
                            break;
                        case "combinado":
                            System.out.print("  Umbral individual%: "); double ui = Double.parseDouble(sc.nextLine().trim());
                            System.out.print("  Umbral promedio%: ");   double up2= Double.parseDouble(sc.nextLine().trim());
                            panel.cambiarAlgoritmo(new DeteccionCombinada(ui, up2));
                            break;
                        default: System.out.println("Algoritmo no reconocido.");
                    }
                    break;

                case "3":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}
