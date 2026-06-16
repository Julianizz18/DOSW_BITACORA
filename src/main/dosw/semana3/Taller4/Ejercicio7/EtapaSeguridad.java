package main.dosw.semana3.Taller4.Ejercicio7;

public class EtapaSeguridad extends EtapaPipeline {
    private boolean bloquearVulnerabilidades;

    public EtapaSeguridad(boolean bloquear) {
        this.bloquearVulnerabilidades = bloquear;
    }

    protected boolean validar(CommitJob job) {
        System.out.println(" Escaneando dependencias del commit " + job.getHash());
        System.out.println("Modo bloqueo: " + (bloquearVulnerabilidades ? "ESTRICTO" : "ADVERTENCIA"));
        if (job.getRama().equals("main") && bloquearVulnerabilidades) {
            System.out.println("Rama main con escaneo estricto activado.");
        }
        return true;
    }

    protected String getNombre() {
        return "SecurityScan";
    }
}
