package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorUbicacion extends ValidadorAcceso {
    protected boolean verificar(ResultadoAuth r,DatosAcceso d){
        boolean ok=d.pais.equalsIgnoreCase("Colombia")||d.pais.equalsIgnoreCase("USA")||d.pais.equalsIgnoreCase("Mexico");
        System.out.println(d.pais+" -> "+(ok?"OK":"DENEGADO"));
        return ok;
    }
}
