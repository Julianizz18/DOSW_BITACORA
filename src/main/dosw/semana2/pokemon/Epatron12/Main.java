package main.dosw.semana2.pokemon.Epatron12;
public class Main {
    public static void main(String[] args) {
        int[] datos = {64, 34, 25, 12, 22, 11, 90};
        Ordenador ordenador = new Ordenador(new OrdenamientoBurbuja());
        ordenador.ordenar(datos);
        System.out.println();
        ordenador.setEstrategia(new OrdenamientoSeleccion());
        ordenador.ordenar(datos);
        System.out.println();
        ordenador.setEstrategia(new OrdenamientoInsercion());
        ordenador.ordenar(datos);
    }
}
