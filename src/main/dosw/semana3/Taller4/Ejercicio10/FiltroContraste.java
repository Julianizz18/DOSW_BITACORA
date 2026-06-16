package main.dosw.semana3.Taller4.Ejercicio10;

public class FiltroContraste extends DecoradorFiltro {
    public FiltroContraste(ImagenEditable i){
        super(i);
    }
    public String renderizar(){
        return img.renderizar()+"; Contraste";
    }
}
