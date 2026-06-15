package main.dosw.semana3.Taller4.Ejercicio3;

public abstract class GeneradorReporte {
    public final void generar() { cargarDatos(); procesarDatos(); darFormato(); guardarArchivo(); System.out.println("Reporte listo."); }
    private void cargarDatos()   { System.out.println(" [1] Cargando datos..."); }
    private void procesarDatos() { System.out.println(" [2] Procesando informacion..."); }
    protected abstract void darFormato();
    protected abstract void guardarArchivo();
}
