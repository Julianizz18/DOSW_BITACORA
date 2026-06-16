package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoFallido implements EstadoPipeline {
    private String motivo;
    public EstadoFallido(String motivo) { this.motivo = motivo; }
    public void aprobar(CommitJob job) {
        System.out.println("Commit corregido y reingresado al pipeline.");
        job.setEstado(new EstadoEnPipeline());
    }
    public void fallar(CommitJob job, String m) {
        System.out.println("Ya esta fallido por: " + motivo);
    }
    public String getNombre() {
        return "FALLIDO";
    }
}
