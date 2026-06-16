package main.dosw.semana3.Taller4.Ejercicio10;

public class ContextoTexto {
    private TextoEditable actual;

    public ContextoTexto(TextoEditable inicial) {
        this.actual = inicial;
    }
    public TextoEditable getActual() {
        return actual;
    }
    public void setActual(TextoEditable t) {
        this.actual = t;
    }
}
