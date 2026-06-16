package main.dosw.semana3.Taller4.Ejercicio10;

public class ComandoContraste implements ComandoFiltro {
    private ContextoImagen ctx;
    private ImagenEditable antes;
    public ComandoContraste(ContextoImagen c){
        ctx=c;
    }
    public void ejecutar(){
        antes=ctx.getActual();
        ctx.setActual(new FiltroContraste(antes));
        System.out.println("Contraste aplicado.");
    }
    public void deshacer(){
        ctx.setActual(antes);
        System.out.println("Contraste removido.");
    }
    public String getNombre(){
        return "Contraste";
    }
}
