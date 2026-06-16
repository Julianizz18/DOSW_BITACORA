package main.dosw.semana3.Taller4.Ejercicio10;

public class CmdMayusculas implements ComandoTransformacion {
    private ContextoTexto ctx; private TextoEditable anterior;
    public CmdMayusculas(ContextoTexto c) { ctx = c; }
    public void ejecutar() { anterior=ctx.getActual(); ctx.setActual(new TransfMayusculas(anterior)); System.out.println("  [+] Mayusculas aplicado."); }
    public void deshacer() { ctx.setActual(anterior); System.out.println("  [-] Mayusculas revertido."); }
    public String getNombre() { return "Mayusculas"; }
}
