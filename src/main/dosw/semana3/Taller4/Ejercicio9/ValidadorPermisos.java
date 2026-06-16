package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorPermisos extends ValidadorAcceso {
    protected boolean verificar(ResultadoAuth r,DatosAcceso d)
    { boolean ok=r.getRol().equals("USUARIO")||r.getRol().equals("ADMIN");
        System.out.println(" Rol:"+r.getRol()+" -> "+(ok?"OK":"DENEGADO")); return ok;
    }
}
