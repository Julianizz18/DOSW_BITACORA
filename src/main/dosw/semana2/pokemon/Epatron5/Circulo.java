package main.dosw.semana2.pokemon.Epatron5;

public class Circulo extends Forma {
    public Circulo(Color color) {
        super(color);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Círculo de color " + color.aplicarColor());
    }
}
