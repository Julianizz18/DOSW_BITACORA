package main.dosw.semana2.pokemon.Epatron5;

public class Cuadrado extends Forma {
    public Cuadrado(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Cuadrado de color " + color.aplicarColor());
    }
}
