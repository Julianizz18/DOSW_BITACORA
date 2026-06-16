package main.dosw.semana3.Taller4.Ejercicio10;

public abstract class TransformadorTexto implements TextoEditable {
    protected TextoEditable base;

    public TransformadorTexto(TextoEditable base) {
        this.base = base;
    }
    public TextoEditable getBase() {
        return base;
    }
}
