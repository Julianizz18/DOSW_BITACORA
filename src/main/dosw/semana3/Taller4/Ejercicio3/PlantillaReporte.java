package main.dosw.semana3.Taller4.Ejercicio3;

public abstract class PlantillaReporte {
    private String nombreArchivo;
    public PlantillaReporte(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    public final void ejecutar() {
        System.out.println("Iniciando pipeline...");
        paso1_extraerDatos();
        paso2_transformar();
        paso3_formatear();
        paso4_escribir(nombreArchivo);
        System.out.println("Pipeline finalizado: " + nombreArchivo + "\n");
    }
    private void paso1_extraerDatos() {
        System.out.println("Extrayendo registros de la base de datos...");
    }
    private void paso2_transformar() {
        System.out.println("Aplicando reglas de negocio y calculos...");
    }
    protected abstract void paso3_formatear();
    protected abstract void paso4_escribir(String archivo);

    public String getNombreArchivo() { return nombreArchivo; }
}
