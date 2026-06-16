package main.dosw.semana3.Taller4.Ejercicio10;

public class ContextoImagen {
    private ImagenEditable actual;
    public ContextoImagen(ImagenEditable i){actual=i;
    }
    public ImagenEditable getActual(){
        return actual;
    } public void setActual(ImagenEditable i){
        actual=i;
    }
}
