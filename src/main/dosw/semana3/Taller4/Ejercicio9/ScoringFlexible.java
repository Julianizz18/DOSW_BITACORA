package main.dosw.semana3.Taller4.Ejercicio9;

public class ScoringFlexible implements AlgoritmoScoring {
    public int calcularScore(SolicitudCredito s) {
        int score = 650;
        score += (int)(s.getIngreso() / 800);
        score -= (int)(s.getDeuda()   / 1000);
        score += s.getHistorial();
        return Math.max(0, Math.min(1000, score));
    }
    public String getNombre() { return "Flexible"; }
}
