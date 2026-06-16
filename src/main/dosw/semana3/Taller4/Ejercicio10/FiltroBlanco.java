package main.dosw.semana3.Taller4.Ejercicio10;

public class FiltroBlanco extends DecoradorFiltro {
    public FiltroBlanco(ImagenEditable i){
        super(i);
    }
    public String renderizar(){
        return img.renderizar()+"; BlancoNegro";
    }
}
