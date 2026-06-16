package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorScore extends ValidadorCredito {
    private int scoreMinimo;

    public ValidadorScore(int minimo) { this.scoreMinimo = minimo; }

    protected boolean verificar(SolicitudCredito s, int score) {
        boolean ok = score >= scoreMinimo;
        System.out.println( score + " pts (minimo: " + scoreMinimo + ") -> " + (ok ? "OK" : "RECHAZADO"));
        return ok;
    }
}
