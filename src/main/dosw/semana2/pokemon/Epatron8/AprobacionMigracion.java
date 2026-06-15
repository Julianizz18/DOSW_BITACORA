package main.dosw.semana2.pokemon.Epatron8;

public class AprobacionMigracion extends ControlMigratorio {
    @Override
    public void verificar(Viajero viajero) {
        System.out.println("Aprobación final de migración para " + viajero.getNombre() + "...");
        System.out.println("APROBADO. Bienvenido a Estados Unidos, " + viajero.getNombre() + "!");
    }
}
