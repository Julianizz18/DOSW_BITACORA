package main.dosw.semana3.Taller4.Ejercicio6;

public class MonitorConsola implements MonitorObservador {
    public void alCambiarAlgoritmo(MetricaServidor m, AlgoritmoDeteccion a) {
        System.out.println("CONSOLA:  " + m.getServidor() + " Algoritmo: " + a.getNombre());
        System.out.println("             Diagnostico: " + a.evaluar(m));
    }
}
