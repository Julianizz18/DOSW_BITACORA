package main.dosw.semana3.Taller4.Ejercicio7;

public interface EstadoPipeline {
    void aprobar(CommitJob job);
    void fallar(CommitJob job, String motivo);
    String getNombre();
}
