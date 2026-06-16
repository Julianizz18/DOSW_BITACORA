package main.dosw.semana3.Taller4.Ejercicio9;

public class GestorAutenticacion {
    private ValidadorAcceso cadena;
    public GestorAutenticacion(){
        ValidadorAcceso c=new ValidadorCredenciales(),p=new ValidadorPermisos(),u=new ValidadorUbicacion(),h=new ValidadorHorario();
        c.setSiguiente(p).setSiguiente(u).setSiguiente(h);
        cadena=c;
    }
    public boolean iniciarSesion(EstrategiaAuth e,DatosAcceso d){
        System.out.println("Acceso: "+d.usuario);
        ResultadoAuth r=e.autenticar(d);
        boolean ok=cadena.validar(r,d);
        System.out.println(ok?"CONCEDIDO":"DENEGADO\n");
        return ok;
    }
}
