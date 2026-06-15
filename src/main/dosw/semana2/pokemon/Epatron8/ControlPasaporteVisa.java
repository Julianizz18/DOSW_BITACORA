package main.dosw.semana2.pokemon.Epatron8;

public class ControlPasaporteVisa extends ControlMigratorio {
    @Override
    public void verificar(Viajero viajero) {
        System.out.println("Revisando pasaporte y visa de " + viajero.getNombre() + "...");
        if (!viajero.tienePasaporte() || !viajero.tieneVisa()) {
            System.out.println("RECHAZADO en control de pasaporte/visa: documentos inválidos.");
            return;
        }
        System.out.println("Pasaporte y visa correctos. Pasando al siguiente control.");
        if (siguiente != null) {
            siguiente.verificar(viajero);
        }
    }
}
