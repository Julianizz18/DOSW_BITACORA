package main.dosw.semana3.Taller4.Ejercicio10;

public class TransfInvertir extends TransformadorTexto {
    public TransfInvertir(TextoEditable b) {
        super(b);
    }
    public String obtenerTexto()  {
        return new StringBuilder(base.obtenerTexto()).reverse().toString();
    }
    public String getDescripcion(){
        return base.getDescripcion() + ";Invertido";
    }
}
