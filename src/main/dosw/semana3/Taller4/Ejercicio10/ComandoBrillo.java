package main.dosw.semana3.Taller4.Ejercicio10;

public class ComandoBrillo implements ComandoFiltro { private ContextoImagen ctx; private ImagenEditable antes; private int nivel;
    public ComandoBrillo(ContextoImagen c,int n){ctx=c;nivel=n;}
    public void ejecutar(){antes=ctx.getActual();ctx.setActual(new FiltroBrillo(antes,nivel));System.out.println("  [+] Brillo:"+nivel+" aplicado.");}
    public void deshacer(){ctx.setActual(antes);System.out.println("  [-] Brillo:"+nivel+" removido.");}
    public String getNombre(){return "Brillo:"+nivel;} }
