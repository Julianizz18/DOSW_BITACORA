package main.dosw.semana3.Taller4.Ejercicio10;

public class CmdCensurar implements ComandoTransformacion {
    private ContextoTexto ctx; private TextoEditable anterior; private String palabra;
    public CmdCensurar(ContextoTexto c, String p) { ctx=c; palabra=p; }
    public void ejecutar() { anterior=ctx.getActual(); ctx.setActual(new TransfCensurar(anterior,palabra)); System.out.println("  [+] Censurado '"+palabra+"'."); }
    public void deshacer() { ctx.setActual(anterior); System.out.println("  [-] Censura '"+palabra+"' revertida."); }
    public String getNombre() { return "Censurar("+palabra+")"; }
}
