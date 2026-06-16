package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorEdad extends ValidadorCredito {
    private int edadMinima;
    private int edadMaxima;

    public ValidadorEdad(int min, int max) { this.edadMinima = min; this.edadMaxima = max; }

    protected boolean verificar(SolicitudCredito s, int score) {
        boolean ok = s.getEdad() >= edadMinima && s.getEdad() <= edadMaxima;
        System.out.println( s.getEdad() + " años -> " + (ok ? "OK" : "RECHAZADO (rango " + edadMinima + "-" + edadMaxima + ")"));
        return ok;
    }
}
