package main.dosw.semana3.Taller4.Ejercicio9;

public abstract class ValidadorCredito {
    private ValidadorCredito siguiente;

    public ValidadorCredito setSiguiente(ValidadorCredito s) { this.siguiente = s; return s; }

    public boolean validar(SolicitudCredito s, int score) {
        if (!verificar(s, score)) return false;
        return siguiente == null || siguiente.validar(s, score);
    }

    protected abstract boolean verificar(SolicitudCredito s, int score);
}
