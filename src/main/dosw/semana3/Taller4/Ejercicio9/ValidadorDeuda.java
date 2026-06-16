package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorDeuda extends ValidadorCredito {
    private double maxDeudaPermitida;

    public ValidadorDeuda(double max) { this.maxDeudaPermitida = max; }

    protected boolean verificar(SolicitudCredito s, int score) {
        boolean ok = s.getDeuda() <= maxDeudaPermitida;
        System.out.printf("$%.0f (max $%.0f) -> %s%n",
                s.getDeuda(), maxDeudaPermitida, ok ? "OK" : "RECHAZADO");
        return ok;
    }
}
