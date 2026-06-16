package main.dosw.semana3.Taller4.Ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plataforma de Videojuegos: Personajes ");
        System.out.print("Nombre del personaje: ");
        String nombre = sc.nextLine().trim();
        System.out.println("Clases: Guerrero, Mago, Arquero, Asesino");
        System.out.print("Clase: ");
        String clase = sc.nextLine().trim();
        System.out.print("Puntos de vida (ej: 120): ");
        int vida = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Ataque base (ej: 35): ");
        int ataque = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Defensa base (ej: 15): ");
        int defensa = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Velocidad (ej: 8): ");
        int velocidad = Integer.parseInt(sc.nextLine().trim());
        Unidad unidad = new UnidadBuilder(nombre)
                .clase(clase)
                .vida(vida)
                .ataque(ataque)
                .defensa(defensa)
                .velocidad(velocidad)
                .construir();
        System.out.println("\nUnidad creada:");
        System.out.println("Nombre : " + unidad.getNombre());
        System.out.println("Stats  : " + unidad.getStats());
        System.out.println("Turno base:");
        unidad.ejecutarTurno();
        System.out.println("\nModificadores disponibles: furia, coraza, veneno");
        System.out.println("(pueden combinarse, escribe uno por uno o 'listo' para terminar)");
        boolean activando = true;
        while (activando) {
            System.out.print("Activar modificador (o 'listo'): ");
            String mod = sc.nextLine().trim().toLowerCase();
            switch (mod) {
                case "furia":   unidad = new ModFuria(unidad);   break;
                case "coraza":  unidad = new ModCoraza(unidad);  break;
                case "veneno":  unidad = new ModVeneno(unidad);  break;
                case "listo":   activando = false;               break;
                default: System.out.println("Modificador desconocido.");
            }
            if (!mod.equals("listo")) {
                System.out.println("  Stats actuales: " + unidad.getStats());
            }
        }
        System.out.println("\n Turno con modificadores activos");
        System.out.println("Nombre : " + unidad.getNombre());
        System.out.println("Stats  : " + unidad.getStats());
        unidad.ejecutarTurno();
        sc.close();
    }
}
