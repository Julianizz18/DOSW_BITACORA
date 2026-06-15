package main.dosw.semana3.Taller4.Ejercicio3;

public class ReporteExcel extends PlantillaReporte {

    private int numHojas;
    private boolean conGraficos;

    public ReporteExcel(String archivo, int numHojas, boolean conGraficos) {
        super(archivo);
        this.numHojas = numHojas;
        this.conGraficos = conGraficos;
    }

    protected void paso3_formatear() {
        System.out.println("  [Paso 3] Distribuyendo datos en " + numHojas + " hoja(s) de calculo...");
        System.out.println("           + Aplicando formulas SUM/AVERAGE en columnas numericas");
        if (conGraficos) System.out.println("           + Generando graficos de barras y pastel");
    }

    protected void paso4_escribir(String archivo) {
        System.out.println("  [Paso 4] Construyendo libro OOXML -> " + archivo);
        System.out.println("           + Empaquetando en ZIP interno (.xlsx)");
    }
}
