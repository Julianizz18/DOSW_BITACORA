package main.dosw.semana2.pokemon.Epatron7;

public class Main {
    public static void main(String[] args) {
        Barco barco = new BarcoBase("Destructor", 50, 40);
        System.out.println("Barco base: " + barco.describir());
        System.out.println("Ataque: " + barco.getAtaque() + " | Defensa: " + barco.getDefensa());
        System.out.println();
        Barco barcoMejorado = new Misiles(new RadarAvanzado(new BlindajeReforzado(barco)));
        System.out.println("Barco mejorado: " + barcoMejorado.describir());
        System.out.println("Ataque: " + barcoMejorado.getAtaque() + " | Defensa: " + barcoMejorado.getDefensa());
        System.out.println();
        Barco fragata = new SistemaAntitorpedos(new BarcoBase("Fragata", 30, 30));
        System.out.println("Fragata: " + fragata.describir());
        System.out.println("Ataque: " + fragata.getAtaque() + " | Defensa: " + fragata.getDefensa());
    }
}
