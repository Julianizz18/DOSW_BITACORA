package main.dosw.semana3.Taller4.Ejercicio9;

public class EstrategiaBiometrica implements EstrategiaAuth {
    public ResultadoAuth autenticar(DatosAcceso d){
        boolean ok=d.token.startsWith("BIO_");
        System.out.println((ok?"OK":"FALLO"));
        return new ResultadoAuth(ok,d.usuario,"ADMIN");
    }
}
