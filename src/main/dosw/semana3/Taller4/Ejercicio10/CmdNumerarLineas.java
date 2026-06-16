package main.dosw.semana3.Taller4.Ejercicio10;

public class CmdNumerarLineas implements ComandoTransformacion {
    private ContextoTexto ctx; private TextoEditable anterior;
    public CmdNumerarLineas(ContextoTexto c) { ctx=c; }
    public void ejecutar() { anterior=ctx.getActual(); ctx.setActual(new TransfNumerarLineas(anterior)); System.out.println("  [+] Numerado de lineas aplicado."); }
    public void deshacer() { ctx.setActual(anterior); System.out.println("  [-] Numerado revertido."); }
    public String getNombre() { return "NumerarLineas"; }
}
