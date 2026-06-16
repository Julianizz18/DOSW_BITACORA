package main.dosw.semana3.Taller4.Ejercicio10;

public class ComandoBlancoNegro implements ComandoFiltro { private ContextoImagen ctx; private ImagenEditable antes;
    public ComandoBlancoNegro(ContextoImagen c){ctx=c;}
    public void ejecutar(){antes=ctx.getActual();ctx.setActual(new FiltroBlanco(antes));System.out.println("  [+] BlancoNegro aplicado.");}
    public void deshacer(){ctx.setActual(antes);System.out.println("  [-] BlancoNegro removido.");}
    public String getNombre(){return "BlancoNegro";} }
