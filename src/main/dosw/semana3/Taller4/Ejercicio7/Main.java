package main.dosw.semana3.Taller4.Ejercicio7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pipeline CI/CD de Aprobacion de Commits");

        boolean continuar = true;
        while (continuar) {
            System.out.print("\nHash del commit (o 'salir'): ");
            String hash = sc.nextLine().trim();
            if (hash.equalsIgnoreCase("salir")) {
                continuar = false; continue;
            }
            System.out.print("Autor del commit: ");
            String autor = sc.nextLine().trim();
            System.out.print("Rama (ej: main, develop, hotfix-123): ");
            String rama = sc.nextLine().trim();
            CommitJob job = new CommitJob(hash, autor, rama);
            job.imprimir();
            System.out.print("Cobertura minima de tests % (ej: 80): ");
            int cobertura = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Reglas de linter (ej: google-style, checkstyle): ");
            String reglas = sc.nextLine().trim();
            System.out.print("Escaneo de seguridad estricto? (s/n): ");
            boolean estricto = sc.nextLine().trim().equalsIgnoreCase("s");
            System.out.print("Ambiente de despliegue (staging/production): ");
            String ambiente = sc.nextLine().trim();
            EtapaPipeline tests     = new EtapaTests(cobertura);
            EtapaPipeline linter    = new EtapaLinter(reglas);
            EtapaPipeline seguridad = new EtapaSeguridad(estricto);
            EtapaPipeline deploy    = new EtapaDespliegue(ambiente);
            tests.setSiguiente(linter).setSiguiente(seguridad).setSiguiente(deploy);
            System.out.println("\nEjecutando pipeline");
            job.aprobar();
            tests.ejecutar(job);
            System.out.println();
            job.imprimir();
        }
        sc.close();
    }
}
