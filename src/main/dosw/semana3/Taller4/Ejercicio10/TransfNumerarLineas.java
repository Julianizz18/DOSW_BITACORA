package main.dosw.semana3.Taller4.Ejercicio10;

public class TransfNumerarLineas extends TransformadorTexto {
    public TransfNumerarLineas(TextoEditable b) { super(b); }

    public String obtenerTexto() {
        String[] lineas = base.obtenerTexto().split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lineas.length; i++) {
            sb.append((i + 1)).append(". ").append(lineas[i]);
            if (i < lineas.length - 1) sb.append("\n");
        }
        return sb.toString();
    }

    public String getDescripcion() { return base.getDescripcion() + ";Numerado"; }
}
