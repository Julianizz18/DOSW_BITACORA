package main.dosw.semana3.Taller4.Ejercicio9;

public class ScoringConservador implements AlgoritmoScoring {
    public int calcularScore(SolicitudCredito s) {
        int score = 500;
        score += (int)(s.getIngreso() / 500);
        score -= (int)(s.getDeuda()   / 200);
        score += s.getHistorial() * 3;
        if (s.getEdad() < 25 || s.getEdad() > 65) score -= 50;
        return Math.max(0, Math.min(1000, score));
    }
    public String getNombre() { return "Conservador"; }
}
