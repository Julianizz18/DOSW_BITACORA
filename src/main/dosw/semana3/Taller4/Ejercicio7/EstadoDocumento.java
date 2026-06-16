package main.dosw.semana3.Taller4.Ejercicio7;

public interface EstadoDocumento {
    void aprobar(Documento d);
    void rechazar(Documento d);
    String getNombre();
}
