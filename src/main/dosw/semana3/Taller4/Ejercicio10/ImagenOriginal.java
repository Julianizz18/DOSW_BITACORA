package main.dosw.semana3.Taller4.Ejercicio10;

public class ImagenOriginal implements ImagenEditable {
    private String f;
    public ImagenOriginal(String f){
        this.f=f;
    }
    public String renderizar(){
        return "Original:"+f+"";
    }
}
