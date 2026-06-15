package main.dosw.semana2.pokemon.Epatron9;

public class Personaje {
    private String nombre;
    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public void caminar() {
        System.out.println(nombre + " está caminando.");
    }

    public void saltar() {
        System.out.println(nombre + " está saltando.");
    }

    public void atacar() {
        System.out.println(nombre + " está atacando.");
    }

    public void defenderse() {
        System.out.println(nombre + " está defendiéndose.");
    }
}
