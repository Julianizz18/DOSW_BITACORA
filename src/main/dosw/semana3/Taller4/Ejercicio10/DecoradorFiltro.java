package main.dosw.semana3.Taller4.Ejercicio10;

public abstract class DecoradorFiltro implements ImagenEditable
{ protected ImagenEditable img;
    public DecoradorFiltro(ImagenEditable i){
        img=i;
    }
}
