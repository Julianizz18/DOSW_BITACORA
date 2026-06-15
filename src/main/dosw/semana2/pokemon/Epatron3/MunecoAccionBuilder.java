package main.dosw.semana2.pokemon.Epatron3;

// Constructor concreto - Muñeco de acción
public class MunecoAccionBuilder implements MunecoBuilder {
    private Muneco muneco;

    public MunecoAccionBuilder() {

        this.muneco = new Muneco();
    }

    @Override
    public void construirCabeza() {
        muneco.setCabeza("Cabeza de acción con casco");
    }
    @Override
    public void construirCuerpo() {
        muneco.setCuerpo("Cuerpo musculoso con armadura");
    }
    @Override
    public void construirBrazos() {
        muneco.setBrazos("Brazos articulados con guantes");
    }
    @Override
    public void construirPiernas() {
        muneco.setPiernas("Piernas articuladas con botas");
    }
    @Override
    public void construirAccesorios() {
        muneco.setAccesorios("Espada y escudo");
    }
    @Override
    public Muneco obtenerMuneco() {
        return muneco;
    }
}
