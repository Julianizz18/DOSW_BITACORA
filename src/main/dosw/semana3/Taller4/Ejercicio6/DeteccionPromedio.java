package main.dosw.semana3.Taller4.Ejercicio6;
public class DeteccionPromedio implements AlgoritmoDeteccion {
    private double umbralPromedio;

    public DeteccionPromedio(double umbralPromedio) {
        this.umbralPromedio = umbralPromedio;
    }

    public String evaluar(MetricaServidor m) {
        double promedio = (m.getCpu() + m.getMemoria() + m.getDisco()) / 3.0;
        String nivel = promedio > umbralPromedio ? "SOBRECARGA" : "NORMAL";
        return nivel + " (promedio=" + String.format("%.1f", promedio) + "%)";
    }

    public String getNombre() {
        return "Promedio(umbral=" + umbralPromedio + "%)";
    }
}
