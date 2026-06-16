package main.dosw.semana3.Taller4.Ejercicio6;

public class MonitorEmail implements MonitorObservador {
    private String destinatario;
    public MonitorEmail(String destinatario) { this.destinatario = destinatario; }

    public void alCambiarAlgoritmo(MetricaServidor m, AlgoritmoDeteccion a) {
        String diag = a.evaluar(m);
        if (diag.contains("ALERTA") || diag.contains("CRITICO") || diag.contains("SOBRECARGA")) {
            System.out.println("EMAIL -> " + destinatario + " INCIDENTE en " + m.getServidor() + ": " + diag);
        } else {
            System.out.println("EMAIL -> " + destinatario + " Sin incidentes en " + m.getServidor());
        }
    }
}
