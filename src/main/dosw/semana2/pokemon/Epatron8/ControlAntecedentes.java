package main.dosw.semana2.pokemon.Epatron8;

public class ControlAntecedentes extends ControlMigratorio {
    @Override
    public void verificar(Viajero viajero) {
        System.out.println("Revisando antecedentes de " + viajero.getNombre() + "...");
        if (viajero.tieneAntecedentes()) {
            System.out.println("RECHAZADO en control de antecedentes: registros criminales encontrados.");
            return;
        }
        System.out.println("Sin antecedentes. Pasando al siguiente control.");
        if (siguiente != null) {
            siguiente.verificar(viajero);
        }
    }
}
