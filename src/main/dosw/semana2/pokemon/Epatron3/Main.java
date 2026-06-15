package main.dosw.semana2.pokemon.Epatron3;

// Clase principal para validar la solución
public class Main {
    public static void main(String[] args) {
        FabricaMuneco fabrica = new FabricaMuneco(new MunecoAccionBuilder());
        Muneco munecoAccion = fabrica.construirMuneco();
        System.out.println("Muñeco de acción: " + munecoAccion);

        fabrica.setBuilder(new MunecoClasicaBuilder());
        Muneco munecoClasica = fabrica.construirMuneco();
        System.out.println("Muñeco clásico: " + munecoClasica);
    }
}
