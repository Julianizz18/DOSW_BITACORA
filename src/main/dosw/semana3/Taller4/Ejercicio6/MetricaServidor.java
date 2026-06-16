package main.dosw.semana3.Taller4.Ejercicio6;

public class MetricaServidor {
    private double cpuPorcentaje;
    private double memoriaPorcentaje;
    private double discoPorcentaje;
    private String servidor;

    public MetricaServidor(String servidor, double cpu, double mem, double disco) {
        this.servidor = servidor;
        this.cpuPorcentaje  = cpu;
        this.memoriaPorcentaje = mem;
        this.discoPorcentaje = disco;
    }

    public String getServidor(){
        return servidor;
    }
    public double getCpu()              {
        return cpuPorcentaje;
    }
    public double getMemoria()          {
        return memoriaPorcentaje;
    }
    public double getDisco()            {
        return discoPorcentaje;
    }
}
