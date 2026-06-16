package main.dosw.semana3.Taller4.Ejercicio9;

public abstract class ValidadorAcceso {
    private ValidadorAcceso siguiente;
    public ValidadorAcceso setSiguiente(ValidadorAcceso s){
        this.siguiente=s;
        return s;
    }
    public boolean validar(ResultadoAuth r,DatosAcceso d){
        if(!verificar(r,d))return false;
        return siguiente==null||siguiente.validar(r,d);
    }
    protected abstract boolean verificar(ResultadoAuth r,DatosAcceso d);
}
