package main.dosw.semana3.Taller4.Ejercicio10;

public class CmdInvertir implements ComandoTransformacion {
    private ContextoTexto ctx; private TextoEditable anterior;
    public CmdInvertir(ContextoTexto c) { ctx=c; }
    public void ejecutar() { anterior=ctx.getActual(); ctx.setActual(new TransfInvertir(anterior)); System.out.println("  [+] Texto invertido."); }
    public void deshacer() { ctx.setActual(anterior); System.out.println("  [-] Inversion revertida."); }
    public String getNombre() { return "Invertir"; }
}
