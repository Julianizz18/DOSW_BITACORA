package main.dosw.semana2.pokemon.Epatron5;

public class Triangulo extends Forma {
    public Triangulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Triángulo de color " + color.aplicarColor());
    }
}
