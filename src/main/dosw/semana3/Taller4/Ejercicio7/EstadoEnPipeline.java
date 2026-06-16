package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoEnPipeline implements EstadoPipeline {
    public void aprobar(CommitJob job) {
        System.out.println("Todas las etapas pasaron -> DESPLEGADO.");
        job.setEstado(new EstadoDesplegado());
    }
    public void fallar(CommitJob job, String motivo) {
        System.out.println("Pipeline fallido: " + motivo);
        job.setEstado(new EstadoFallido(motivo));
    }
    public String getNombre() {
        return "EN_PIPELINE";
    }
}
