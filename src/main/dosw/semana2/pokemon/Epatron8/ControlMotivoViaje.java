package main.dosw.semana2.pokemon.Epatron8;

public class ControlMotivoViaje extends ControlMigratorio {
    @Override
    public void verificar(Viajero viajero) {
        System.out.println("Revisando motivo de viaje de " + viajero.getNombre() + "...");
        if (viajero.getMotivoViaje() == null || viajero.getMotivoViaje().isEmpty()) {
            System.out.println("RECHAZADO en control de motivo: motivo de viaje no declarado.");
            return;
        }
        System.out.println("Motivo válido: " + viajero.getMotivoViaje() + ". Pasando al siguiente control.");
        if (siguiente != null) {
            siguiente.verificar(viajero);
        }
    }
}
