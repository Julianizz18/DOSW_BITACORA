package main.dosw.semana3.Taller4.Ejercicio10;

public class FiltroSepia extends DecoradorFiltro {
    public FiltroSepia(ImagenEditable i){
        super(i);
    }
    public String renderizar(){
        return img.renderizar()+" -> [Sepia]";
    }
}
