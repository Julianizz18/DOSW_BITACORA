package main.dosw.semana3.Taller4.Ejercicio9;

public class SistemaCrediticio {
    private AlgoritmoScoring scoring;
    private ValidadorCredito cadena;

    public SistemaCrediticio(AlgoritmoScoring scoring, ValidadorCredito cadena) {
        this.scoring = scoring;
        this.cadena  = cadena;
    }

    public void evaluar(SolicitudCredito s) {
        System.out.println("\nEvaluando solicitud de: " + s.getNombre());
        System.out.printf("  Monto: $%.0f | Plazo: %d meses | Cuota est.: $%.0f/mes%n",
                s.getMonto(), s.getPlazo(), s.getCuotaMensual());

        int score = scoring.calcularScore(s);
        System.out.println("  Scoring [" + scoring.getNombre() + "]: " + score + " puntos");
        System.out.println("  Validando condiciones:");

        boolean aprobado = cadena.validar(s, score);
        System.out.println("\n  Resultado: " + (aprobado ? "CREDITO APROBADO" : "CREDITO RECHAZADO"));
    }
}
