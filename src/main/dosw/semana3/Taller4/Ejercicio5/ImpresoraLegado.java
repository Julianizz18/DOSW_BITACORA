package main.dosw.semana3.Taller4.Ejercicio5;
public class ImpresoraLegado {
    private int trabajosEnCola = 0;
    private boolean encendida  = false;
    private String modelo;
    public ImpresoraLegado(String modelo) {
        this.modelo = modelo;
    }
    public void enviarComandoESC(String codigo) {
        System.out.println( modelo + "] ESC/P CMD: " + codigo);
    }
    public int insertarEnCola(byte[] datos, int prioridad) {
        trabajosEnCola++;
        int jobId = 1000 + trabajosEnCola;
        System.out.println( modelo + "] Spool #" + jobId + " insertado (prior:" + prioridad + ", bytes:" + datos.length + ")");
        return jobId;
    }

    public boolean verificarListoParaImprimir() {
        if (!encendida) {
            System.out.println( modelo + "] ERROR: impresora apagada.");
            return false;
        }
        System.out.println( modelo + "] Verificacion OK.");
        return true;
    }

    public int leerColaInterna() {
        return trabajosEnCola;
    }

    public String leerRegistroEstado() {
        return encendida ? "ONLINE|LISTA|TONER:OK" : "OFFLINE";
    }

    public void encender() {
        encendida = true;
        System.out.println("  [LEGADO:" + modelo + "] Powering ON...");
    }
}
