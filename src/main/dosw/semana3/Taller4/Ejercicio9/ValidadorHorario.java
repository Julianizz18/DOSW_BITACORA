package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorHorario extends ValidadorAcceso {
    protected boolean verificar(ResultadoAuth r,DatosAcceso d){
        boolean ok=d.hora>=7&&d.hora<=21;
        System.out.println(" Hora "+d.hora+":00 -> "+(ok?"OK":"DENEGADO")); return ok;
    }
}
