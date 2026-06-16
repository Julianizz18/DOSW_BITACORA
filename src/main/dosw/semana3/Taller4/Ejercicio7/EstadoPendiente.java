package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoPendiente implements EstadoPipeline {
    public void aprobar(CommitJob job) {
        System.out.println("Commit entra al pipeline CI/CD.");
        job.setEstado(new EstadoEnPipeline());
    }
    public void fallar(CommitJob job, String motivo) {
        System.out.println("No se puede fallar un commit pendiente.");
    }
    public String getNombre() { return "PENDIENTE"; }
}
