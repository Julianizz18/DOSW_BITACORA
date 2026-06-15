package main.dosw.semana3.Taller4.Ejercicio3;

public class ReportePDF extends PlantillaReporte {

    private boolean incluirPortada;
    private int margenMm;

    public ReportePDF(String archivo, boolean incluirPortada, int margenMm) {
        super(archivo);
        this.incluirPortada = incluirPortada;
        this.margenMm = margenMm;
    }

    protected void paso3_formatear() {
        System.out.println("  [Paso 3] Mapeando datos a estructura PDF...");
        if (incluirPortada) System.out.println("           + Agregando portada con logo corporativo");
        System.out.println("           + Configurando margenes de " + margenMm + "mm");
        System.out.println("           + Incrustando fuentes y estilos");
    }

    protected void paso4_escribir(String archivo) {
        System.out.println("  [Paso 4] Serializando binario PDF -> " + archivo);
        System.out.println("           + Comprimiendo con Deflate");
    }
}
