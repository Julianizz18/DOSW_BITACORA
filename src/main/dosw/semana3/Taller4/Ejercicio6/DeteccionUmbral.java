package main.dosw.semana3.Taller4.Ejercicio6;

public class DeteccionUmbral implements AlgoritmoDeteccion {
    private double umbralCpu;
    private double umbralMem;
    private double umbralDisco;

    public DeteccionUmbral(double umbralCpu, double umbralMem, double umbralDisco) {
        this.umbralCpu   = umbralCpu;
        this.umbralMem   = umbralMem;
        this.umbralDisco = umbralDisco;
    }

    public String evaluar(MetricaServidor m) {
        StringBuilder resultado = new StringBuilder();
        if (m.getCpu()     > umbralCpu)   resultado.append("CPU CRITICA(").append(m.getCpu()).append("%) ");
        if (m.getMemoria() > umbralMem)   resultado.append("MEM CRITICA(").append(m.getMemoria()).append("%) ");
        if (m.getDisco()   > umbralDisco) resultado.append("DISCO CRITICO(").append(m.getDisco()).append("%) ");
        return resultado.length() == 0 ? "NORMAL" : "ALERTA: " + resultado.toString().trim();
    }

    public String getNombre() {
        return "Umbral(CPU>" + umbralCpu + "% MEM>" + umbralMem + "% DISCO>" + umbralDisco + "%)";
    }
}
