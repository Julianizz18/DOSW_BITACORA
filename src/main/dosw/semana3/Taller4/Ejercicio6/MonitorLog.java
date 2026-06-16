package main.dosw.semana3.Taller4.Ejercicio6;

public class MonitorLog implements MonitorObservador {
    private String archivoLog;
    public MonitorLog(String archivoLog) { this.archivoLog = archivoLog; }

    public void alCambiarAlgoritmo(MetricaServidor m, AlgoritmoDeteccion a) {
        System.out.println("  [LOG:" + archivoLog + "] " + m.getServidor()
                + " cpu=" + m.getCpu() + "% mem=" + m.getMemoria()
                + "% disco=" + m.getDisco() + "% -> " + a.evaluar(m));
    }
}
