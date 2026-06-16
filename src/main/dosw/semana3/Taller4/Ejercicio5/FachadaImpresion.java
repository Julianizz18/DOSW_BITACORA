package main.dosw.semana3.Taller4.Ejercicio5;

public class FachadaImpresion {
    private TrabajoImpresion impresora;
    private String nombreImpresora;

    public FachadaImpresion(String modeloImpresora) {
        this.nombreImpresora = modeloImpresora;
        inicializarDriver();
    }

    private void inicializarDriver() {
        System.out.println("Paso 1: Detectando puerto LPT/USB...");
        System.out.println("Paso 2: Cargando driver ESC/P para " + nombreImpresora + "...");
        System.out.println("Paso 3: Negociando velocidad de comunicacion (9600 baud)...");
        System.out.println("Paso 4: Encendiendo impresora...");
        ImpresoraLegado legado = new ImpresoraLegado(nombreImpresora);
        legado.encender();
        System.out.println("Paso 5: Inicializando cola de impresion...");
        System.out.println("Paso 6: Calibrando cabezal de impresion...");
        System.out.println("Paso 7: Verificando papel y toner...");
        System.out.println("Paso 8: Driver listo.\n");
        this.impresora = new AdaptadorImpresora(legado);
    }
    public void enviarDocumento(String texto, int copias) {
        System.out.println("Enviando documento (" + copias + " copia/s)...");
        boolean ok = impresora.imprimir(texto, copias);
        System.out.println("Resultado: " + (ok ? "IMPRIMIENDO" : "ERROR"));
    }
    public void verEstado() {
        System.out.println("Estado: " + impresora.consultarEstado());
        System.out.println("En cola: " + impresora.consultarColaEspera() + " trabajo/s");
    }
}
