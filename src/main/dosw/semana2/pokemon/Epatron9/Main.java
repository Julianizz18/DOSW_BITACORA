package main.dosw.semana2.pokemon.Epatron9;

public class Main {
    public static void main(String[] args) {
        Personaje heroe = new Personaje("Héroe");
        ControlJuego control = new ControlJuego();
        control.setBotonA(new ComandoCaminar(heroe));
        control.setBotonB(new ComandoSaltar(heroe));
        control.setBotonX(new ComandoAtacar(heroe));
        control.setBotonY(new ComandoDefenderse(heroe));
        control.presionarA();
        control.presionarB();
        control.presionarX();
        control.presionarY();
    }
}
