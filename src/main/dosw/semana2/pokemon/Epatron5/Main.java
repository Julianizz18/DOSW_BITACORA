package main.dosw.semana2.pokemon.Epatron5;
public class Main {
    public static void main(String[] args) {
        Forma circuloRojo = new Circulo(new Rojo());
        circuloRojo.dibujar();
        Forma cuadradoAzul = new Cuadrado(new Azul());
        cuadradoAzul.dibujar();
        Forma trianguloVerde = new Triangulo(new Verde());
        trianguloVerde.dibujar();
        Forma circuloAzul = new Circulo(new Azul());
        circuloAzul.dibujar();
    }
}
