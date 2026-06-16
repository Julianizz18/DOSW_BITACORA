package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoBorrador implements EstadoDocumento {
    public void aprobar(Documento d){
        System.out.println("Borrador enviado a revision.");
        d.setEstado(new EstadoEnRevision());
    }
    public void rechazar(Documento d){
        System.out.println("No se puede rechazar un borrador.");
    }
    public String getNombre(){
        return "BORRADOR";
    }
}
