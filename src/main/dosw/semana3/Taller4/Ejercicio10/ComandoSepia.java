package main.dosw.semana3.Taller4.Ejercicio10;

public class ComandoSepia implements ComandoFiltro { private ContextoImagen ctx; private ImagenEditable antes;
    public ComandoSepia(ContextoImagen c){ctx=c;}
    public void ejecutar(){
        antes=ctx.getActual();
        ctx.setActual(new FiltroSepia(antes));
        System.out.println("Sepia aplicado.");
    }
    public void deshacer(){
        ctx.setActual(antes);
        System.out.println("Sepia removido.");}
    public String getNombre(){return "Sepia";} }
