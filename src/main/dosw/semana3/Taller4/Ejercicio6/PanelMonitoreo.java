package main.dosw.semana3.Taller4.Ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class PanelMonitoreo {
    private AlgoritmoDeteccion algoritmo;
    private MetricaServidor ultimaMetrica;
    private List<MonitorObservador> observadores = new ArrayList<>();

    public void agregarObservador(MonitorObservador o) { observadores.add(o); }

    public void cambiarAlgoritmo(AlgoritmoDeteccion nuevoAlgoritmo) {
        this.algoritmo = nuevoAlgoritmo;
        System.out.println("\nAlgoritmo cambiado a: " + nuevoAlgoritmo.getNombre());
        if (ultimaMetrica != null) notificar();
    }

    public void recibirMetrica(MetricaServidor m) {
        this.ultimaMetrica = m;
        System.out.println("\nNueva metrica recibida de " + m.getServidor());
        if (algoritmo != null) notificar();
    }

    private void notificar() {
        for (MonitorObservador o : observadores) {
            o.alCambiarAlgoritmo(ultimaMetrica, algoritmo);
        }
    }
}
