package main.dosw.semana3.Taller4.Ejercicio6;
public class DeteccionCombinada implements AlgoritmoDeteccion {
    private double umbralIndividual;
    private double umbralPromedio;
    public DeteccionCombinada(double umbralIndividual, double umbralPromedio) {
        this.umbralIndividual = umbralIndividual;
        this.umbralPromedio   = umbralPromedio;
    }

    public String evaluar(MetricaServidor m) {
        double promedio = (m.getCpu() + m.getMemoria() + m.getDisco()) / 3.0;
        boolean algunaCritica = m.getCpu() > umbralIndividual
                             || m.getMemoria() > umbralIndividual
                             || m.getDisco() > umbralIndividual;
        boolean promedioAlto  = promedio > umbralPromedio;

        if (algunaCritica && promedioAlto) return "CRITICO COMBINADO (prom=" + String.format("%.1f",promedio) + "%)";
        if (algunaCritica) return "ADVERTENCIA individual detectada";
        if (promedioAlto) return "CARGA ALTA en promedio";
        return "SISTEMA ESTABLE";
    }

    public String getNombre() {
        return "Combinado(ind>" + umbralIndividual + "% prom>" + umbralPromedio + "%)";
    }
}
