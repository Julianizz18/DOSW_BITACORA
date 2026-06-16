package main.dosw.semana3.Taller4.Ejercicio9;

public class ScoringEstandar implements AlgoritmoScoring {
    public int calcularScore(SolicitudCredito s) {
        int score = 600;
        score += (int)(s.getIngreso() / 1000);
        score -= (int)(s.getDeuda()   / 500);
        score += s.getHistorial() * 2;
        double ratio = s.getCuotaMensual() / s.getIngreso();
        if (ratio > 0.4) score -= 100;
        return Math.max(0, Math.min(1000, score));
    }
    public String getNombre() {
        return "Estandar";
    }
}
