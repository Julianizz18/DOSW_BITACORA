package main.dosw.semana3.Taller4.Ejercicio9;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de Aprobacion de Creditos");
        System.out.println("Algoritmos de scoring: conservador, estandar, flexible");
        System.out.print("Seleccione algoritmo: ");
        AlgoritmoScoring scoring;
        switch (sc.nextLine().trim().toLowerCase()) {
            case "conservador": scoring = new ScoringConservador();
            break;
            case "flexible":scoring = new ScoringFlexible();
            break;
            default: scoring = new ScoringEstandar();
        }
        System.out.print("Score minimo requerido (ej: 600): ");
        int scoreMin = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Edad minima / maxima (ej: 18 70): ");
        String[] edades = sc.nextLine().trim().split(" ");
        int edadMin = Integer.parseInt(edades[0]);
        int edadMax = Integer.parseInt(edades[1]);
        System.out.print("Ratio maximo cuota/ingreso % (ej: 35): ");
        double ratio = Double.parseDouble(sc.nextLine().trim()) / 100.0;
        System.out.print("Deuda maxima permitida (ej: 5000000): $");
        double maxDeuda = Double.parseDouble(sc.nextLine().trim());
        ValidadorCredito edad = new ValidadorEdad(edadMin, edadMax);
        ValidadorCredito score = new ValidadorScore(scoreMin);
        ValidadorCredito capacidad = new ValidadorCapacidadPago(ratio);
        ValidadorCredito deuda = new ValidadorDeuda(maxDeuda);
        edad.setSiguiente(score).setSiguiente(capacidad).setSiguiente(deuda);
        SistemaCrediticio sistema = new SistemaCrediticio(scoring, edad);
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nNombre del solicitante (o 'salir'): ");
            String nombre = sc.nextLine().trim();
            if (nombre.equalsIgnoreCase("salir")) {
                continuar = false;
                continue;
            }
            System.out.print("Edad: ");
            int edad2 = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Ingreso mensual: $"); double  ingreso = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Monto solicitado: $"); double  monto   = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Plazo en meses: "); int     plazo   = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Deuda actual: $"); double  deuda2  = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Meses historial limpio: "); int hist    = Integer.parseInt(sc.nextLine().trim());

            SolicitudCredito solicitud = new SolicitudCredito(nombre, edad2, ingreso, monto, plazo, deuda2, hist);
            sistema.evaluar(solicitud);
        }
        sc.close();
    }
}
