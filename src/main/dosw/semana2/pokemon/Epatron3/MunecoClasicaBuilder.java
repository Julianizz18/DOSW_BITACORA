package main.dosw.semana2.pokemon.Epatron3;

public class MunecoClasicaBuilder implements MunecoBuilder {
    private Muneco muneco;

    public MunecoClasicaBuilder() {
        this.muneco = new Muneco();
    }

    @Override
    public void construirCabeza() {
        muneco.setCabeza("Cabeza con cabello largo y diadema");
    }
    @Override
    public void construirCuerpo() {
        muneco.setCuerpo("Cuerpo con vestido rosado");
    }
    @Override
    public void construirBrazos() {
        muneco.setBrazos("Brazos delgados con manos abiertas");
    }
    @Override
    public void construirPiernas() {
        muneco.setPiernas("Piernas con zapatos de tacón");
    }
    @Override
    public void construirAccesorios() {
    }
    @Override
    public Muneco obtenerMuneco() {
        return muneco;
    }
}
