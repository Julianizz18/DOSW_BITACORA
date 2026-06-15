package main.dosw.semana2.pokemon.Epatron2;

public class MotorJuego {
    private Control control;
    private Juego juego;
    private InterfazGrafica interfazGrafica;

    public MotorJuego(ConsolaFactory factory) {
        this.control = factory.crearControl();
        this.juego = factory.crearJuego();
        this.interfazGrafica = factory.crearInterfazGrafica();
    }

    public void iniciar() {
        control.conectar();
        juego.iniciar();
        interfazGrafica.renderizar();
    }
}
