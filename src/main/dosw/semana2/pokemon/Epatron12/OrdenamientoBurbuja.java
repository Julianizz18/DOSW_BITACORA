package main.dosw.semana2.pokemon.Epatron12;
public class OrdenamientoBurbuja implements EstrategiaOrdenamiento {
    @Override
    public int[] ordenar(int[] datos) {
        int[] resultado = datos.clone();
        int n = resultado.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (resultado[j] > resultado[j + 1]) {
                    int temp = resultado[j];
                    resultado[j] = resultado[j + 1];
                    resultado[j + 1] = temp;
                }
            }
        }
        return resultado;
    }
    @Override
    public String getNombre() { return "Burbuja"; }
}
