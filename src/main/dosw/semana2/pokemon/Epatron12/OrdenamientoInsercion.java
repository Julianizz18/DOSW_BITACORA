package main.dosw.semana2.pokemon.Epatron12;

public class OrdenamientoInsercion implements EstrategiaOrdenamiento {
    @Override
    public int[] ordenar(int[] datos) {
        int[] resultado = datos.clone();
        int n = resultado.length;
        for (int i = 1; i < n; i++) {
            int clave = resultado[i];
            int j = i - 1;
            while (j >= 0 && resultado[j] > clave) {
                resultado[j + 1] = resultado[j];
                j--;
            }
            resultado[j + 1] = clave;
        }
        return resultado;
    }

    @Override
    public String getNombre() { return "Inserción"; }
}
