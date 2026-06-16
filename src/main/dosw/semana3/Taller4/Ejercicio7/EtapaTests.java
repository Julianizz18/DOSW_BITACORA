package main.dosw.semana3.Taller4.Ejercicio7;

public class EtapaTests extends EtapaPipeline {
    private int umbralCobertura;

    public EtapaTests(int umbralCobertura) {
        this.umbralCobertura = umbralCobertura;
    }

    protected boolean validar(CommitJob job) {
        System.out.print("Cobertura reportada para " + job.getHash() + " (0-100): ");
        System.out.println("Umbral requerido: " + umbralCobertura + "%");
        if (job.getRama().startsWith("hotfix")) {
            System.out.println("Rama hotfix detectada, umbral reducido a 50%");
            return true;
        }
        return true;
    }

    protected String getNombre() {
        return "Tests(min=" + umbralCobertura + "%)";
    }
}
