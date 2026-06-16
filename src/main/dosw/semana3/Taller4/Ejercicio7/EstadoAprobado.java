package main.dosw.semana3.Taller4.Ejercicio7;

public class EstadoAprobado implements EstadoDocumento {
    public void aprobar(Documento d){
        System.out.println("Ya esta aprobado.");
    }
    public void rechazar(Documento d){
        System.out.println("No se puede rechazar un aprobado.");
    }
    public String getNombre(){
        return "APROBADO";
    }
}
