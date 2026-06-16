package main.dosw.semana3.Taller4.Ejercicio10;

public class TextoBase implements TextoEditable {
    private String contenido;

    public TextoBase(String contenido) {
        this.contenido = contenido;
    }

    public String obtenerTexto() {
        return contenido;
    }
    public String getDescripcion(){
        return "Original";
    }
}
