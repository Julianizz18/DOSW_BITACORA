package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorCredenciales extends ValidadorAcceso {
    protected boolean verificar(ResultadoAuth r,DatosAcceso d){
        if(!r.isValido()){
            System.out.println("BLOQUEADO.");
            return false;
        }
        System.out.println("OK"); return true;
    }
}
