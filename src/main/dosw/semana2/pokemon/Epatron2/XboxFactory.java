package main.dosw.semana2.pokemon.Epatron2;
public class XboxFactory implements ConsolaFactory {
    @Override
    public Control crearControl() {
        return new ControlXbox();
    }
    @Override
    public Juego crearJuego() {

        return new JuegoXbox();
    }
    @Override
    public InterfazGrafica crearInterfazGrafica() {

        return new InterfazGraficaXbox();
    }
}
