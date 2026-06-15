package main.dosw.semana2.pokemon.Epatron12;

import java.util.Arrays;

public class Ordenador {
    private EstrategiaOrdenamiento estrategia;
    public Ordenador(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }
    public void setEstrategia(EstrategiaOrdenamiento estrategia) {
        this.estrategia = estrategia;
    }
    public void ordenar(int[] datos) {
        System.out.println("Algoritmo: " + estrategia.getNombre());
        System.out.println("Datos originales: " + Arrays.toString(datos));
        int[] resultado = estrategia.ordenar(datos);
        System.out.println("Datos ordenados:  " + Arrays.toString(resultado));
    }
}
