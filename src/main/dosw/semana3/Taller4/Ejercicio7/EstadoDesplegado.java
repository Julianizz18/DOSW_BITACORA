package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoDesplegado implements EstadoPipeline {
    public void aprobar(CommitJob job) {
        System.out.println("Ya fue desplegado.");
    }
    public void fallar(CommitJob job, String motivo) {
        System.out.println("No se puede fallar lo que ya fue desplegado.");
    }
    public String getNombre() {
        return "DESPLEGADO";
    }
}
