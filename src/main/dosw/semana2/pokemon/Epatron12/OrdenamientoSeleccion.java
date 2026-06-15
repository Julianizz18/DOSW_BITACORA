package main.dosw.semana2.pokemon.Epatron12;

public class OrdenamientoSeleccion implements EstrategiaOrdenamiento {
    @Override
    public int[] ordenar(int[] datos) {
        int[] resultado = datos.clone();
        int n = resultado.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (resultado[j] < resultado[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = resultado[minIdx];
            resultado[minIdx] = resultado[i];
            resultado[i] = temp;
        }
        return resultado;
    }

    @Override
    public String getNombre() { return "Selección"; }
}
