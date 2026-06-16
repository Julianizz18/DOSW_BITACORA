package main.dosw.semana3.Taller4.Ejercicio10;

public class FiltroBrillo extends DecoradorFiltro {
    private int n; public FiltroBrillo(ImagenEditable i, int n){
        super(i);
        this.n=n;
    }
    public String renderizar()
    {return img.renderizar()+" -> [Brillo:"+n+"]";}
}
