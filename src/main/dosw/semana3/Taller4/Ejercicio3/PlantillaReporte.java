package main.dosw.semana3.Taller4.Ejercicio3;

public abstract class PlantillaReporte {

    private String nombreArchivo;

    public PlantillaReporte(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // Metodo final: el esqueleto no cambia
    public final void ejecutar() {
        System.out.println("  >> Iniciando pipeline...");
        paso1_extraerDatos();
        paso2_transformar();
        paso3_formatear();
        paso4_escribir(nombreArchivo);
        System.out.println("  >> Pipeline finalizado: " + nombreArchivo + "\n");
    }

    // Pasos fijos (iguales para todos los formatos)
    private void paso1_extraerDatos() {
        System.out.println("  [Paso 1] Extrayendo registros de la base de datos...");
    }

    private void paso2_transformar() {
        System.out.println("  [Paso 2] Aplicando reglas de negocio y calculos...");
    }

    // Pasos variables (cada formato los implementa)
    protected abstract void paso3_formatear();
    protected abstract void paso4_escribir(String archivo);

    public String getNombreArchivo() { return nombreArchivo; }
}
