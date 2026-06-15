package main.dosw.semana3.Taller4.Ejercicio3;

public class ReporteCSV extends PlantillaReporte {

    private char separador;
    private boolean incluirCabecera;

    public ReporteCSV(String archivo, char separador, boolean incluirCabecera) {
        super(archivo);
        this.separador = separador;
        this.incluirCabecera = incluirCabecera;
    }

    protected void paso3_formatear() {
        System.out.println("  [Paso 3] Serializando filas con separador '" + separador + "'...");
        if (incluirCabecera) System.out.println("           + Insertando fila de cabecera con nombres de campo");
        System.out.println("           + Escapando caracteres especiales en texto");
    }

    protected void paso4_escribir(String archivo) {
        System.out.println("  [Paso 4] Escribiendo texto plano UTF-8 -> " + archivo);
        System.out.println("           + Codificando saltos de linea (CRLF)");
    }
}
