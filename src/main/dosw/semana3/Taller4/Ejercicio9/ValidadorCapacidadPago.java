package main.dosw.semana3.Taller4.Ejercicio9;

public class ValidadorCapacidadPago extends ValidadorCredito {
    private double maxRatioCuotaIngreso; // ej: 0.35 = cuota max 35% del ingreso

    public ValidadorCapacidadPago(double maxRatio) { this.maxRatioCuotaIngreso = maxRatio; }

    protected boolean verificar(SolicitudCredito s, int score) {
        double ratio = s.getCuotaMensual() / s.getIngreso();
        boolean ok   = ratio <= maxRatioCuotaIngreso;
        System.out.printf(" Cuota/Ingreso=%.1f%% (max %.0f%%) -> %s%n",
                ratio * 100, maxRatioCuotaIngreso * 100, ok ? "OK" : "RECHAZADO");
        return ok;
    }
}
