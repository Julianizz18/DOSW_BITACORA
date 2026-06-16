package main.dosw.semana3.Taller4.Ejercicio5;

public class AdaptadorImpresora implements TrabajoImpresion {
    private ImpresoraLegado legado;
    public AdaptadorImpresora(ImpresoraLegado legado) {
        this.legado = legado;
    }
    public boolean imprimir(String contenido, int copias) {
        if (!legado.verificarListoParaImprimir()) return false;
        legado.enviarComandoESC("ESC@");
        legado.enviarComandoESC("ESC!n 0x00");
        for (int i = 0; i < copias; i++) {
            byte[] datos = (contenido + "\f").getBytes();
            legado.insertarEnCola(datos, copias - i);
        }
        legado.enviarComandoESC("ESC FF");
        return true;
    }

    public int consultarColaEspera() {
        return legado.leerColaInterna();
    }

    public String consultarEstado() {
        String raw = legado.leerRegistroEstado();
        if (raw.startsWith("ONLINE")) return "Disponible";
        return "Fuera de linea";
    }
}
