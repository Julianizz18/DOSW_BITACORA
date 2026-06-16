package main.dosw.semana3.Taller4.Ejercicio10;

public class TransfMayusculas extends TransformadorTexto {
    public TransfMayusculas(TextoEditable b) {
        super(b);
    }
    public String obtenerTexto()  {
        return base.obtenerTexto().toUpperCase();
    }
    public String getDescripcion(){
        return base.getDescripcion() + "; MAYUSCULAS";
    }
}
