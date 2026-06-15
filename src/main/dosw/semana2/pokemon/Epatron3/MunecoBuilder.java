package main.dosw.semana2.pokemon.Epatron3;

// Interfaz constructora: declara los pasos de construcción
public interface MunecoBuilder {
    void construirCabeza();
    void construirCuerpo();
    void construirBrazos();
    void construirPiernas();
    void construirAccesorios();
    Muneco obtenerMuneco();
}
