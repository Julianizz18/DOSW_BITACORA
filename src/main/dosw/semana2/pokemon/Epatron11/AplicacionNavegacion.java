package main.dosw.semana2.pokemon.Epatron11;

public class AplicacionNavegacion {
    private EstrategiaRuta estrategia;
    public AplicacionNavegacion(EstrategiaRuta estrategia) {
        this.estrategia = estrategia;
    }
    public void setEstrategia(EstrategiaRuta estrategia) {
        this.estrategia = estrategia;
    }
    public void navegar(String origen, String destino) {
        estrategia.calcularRuta(origen, destino);
    }
}
