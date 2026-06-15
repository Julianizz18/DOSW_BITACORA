package main.dosw.semana2.pokemon.Epatron3;

// Director: controla el proceso de ensamblaje
public class FabricaMuneco {
    private MunecoBuilder builder;

    public FabricaMuneco(MunecoBuilder builder) {

        this.builder = builder;
    }

    public void setBuilder(MunecoBuilder builder) {
        this.builder = builder;
    }

    public Muneco construirMuneco() {
        builder.construirCabeza();
        builder.construirCuerpo();
        builder.construirBrazos();
        builder.construirPiernas();
        builder.construirAccesorios();
        return builder.obtenerMuneco();
    }
}
