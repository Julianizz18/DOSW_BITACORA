package main.dosw.semana2.pokemon.Epatron11;

public class Main {
    public static void main(String[] args) {
        AplicacionNavegacion app = new AplicacionNavegacion(new RutaMasRapida());
        app.navegar("Bogotá", "Medellín");
        app.setEstrategia(new RutaMasCorta());
        app.navegar("Bogotá", "Cali");
        app.setEstrategia(new RutaEscenica());
        app.navegar("Bogotá", "Cartagena");
        app.setEstrategia(new RutaTransportePublico());
        app.navegar("Bogotá", "Bucaramanga");
    }
}
