package main.dosw.semana3.Taller4.Ejercicio10;

public class TransfCensurar extends TransformadorTexto {
    private String palabraClave;

    public TransfCensurar(TextoEditable b, String palabra) {
        super(b);
        this.palabraClave = palabra;
    }

    public String obtenerTexto() {
        String stars = "*".repeat(palabraClave.length());
        return base.obtenerTexto().replaceAll("(?i)" + palabraClave, stars);
    }

    public String getDescripcion() {
        return base.getDescripcion() + "; Censurado:'" + palabraClave + "'";
    }
}
