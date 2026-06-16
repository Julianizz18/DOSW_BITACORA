package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoRechazado implements EstadoDocumento {
    public void aprobar(Documento d){
        System.out.println("Reingresado a revision.");
        d.setEstado(new EstadoEnRevision());
    }
    public void rechazar(Documento d){
        System.out.println("Ya fue rechazado.");
    }
    public String getNombre(){
        return "RECHAZADO";
    }
}
