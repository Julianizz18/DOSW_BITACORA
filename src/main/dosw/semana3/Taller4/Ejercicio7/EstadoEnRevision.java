package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoEnRevision implements EstadoDocumento {
    public void aprobar(Documento d){
        System.out.println("Documento aprobado.");
        d.setEstado(new EstadoAprobado());
    }
    public void rechazar(Documento d){
        System.out.println("Documento rechazado.");
        d.setEstado(new EstadoRechazado());
    }
    public String getNombre(){
        return "EN_REVISION";
    }
}
