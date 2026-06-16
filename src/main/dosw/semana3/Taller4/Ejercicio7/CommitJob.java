package main.dosw.semana3.Taller4.Ejercicio7;

public class CommitJob {
    private String hash;
    private String autor;
    private String rama;
    private EstadoPipeline estado;

    public CommitJob(String hash, String autor, String rama) {
        this.hash   = hash;
        this.autor  = autor;
        this.rama   = rama;
        this.estado = new EstadoPendiente();
    }

    public void setEstado(EstadoPipeline e) { this.estado = e; }
    public EstadoPipeline getEstado()       { return estado; }
    public String getHash()  { return hash; }
    public String getAutor() { return autor; }
    public String getRama()  { return rama; }

    public void aprobar()                    { estado.aprobar(this); }
    public void fallar(String motivo)        { estado.fallar(this, motivo); }

    public void imprimir() {
        System.out.println("Commit " + hash + " | Autor: " + autor
                + " | Rama: " + rama + " | Estado: " + estado.getNombre());
    }
}
