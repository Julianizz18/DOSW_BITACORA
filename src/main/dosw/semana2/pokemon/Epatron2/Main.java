package main.dosw.semana2.pokemon.Epatron2;

public class Main {
    public static void main(String[] args) {
        System.out.println("PlayStation");
        MotorJuego motorPS = new MotorJuego(new PlayStationFactory());
        motorPS.iniciar();

        System.out.println("Xbox");
        MotorJuego motorXbox = new MotorJuego(new XboxFactory());
        motorXbox.iniciar();
    }
}
