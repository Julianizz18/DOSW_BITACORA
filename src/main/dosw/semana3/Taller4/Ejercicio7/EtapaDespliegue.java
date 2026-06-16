package main.dosw.semana3.Taller4.Ejercicio7;

public class EtapaDespliegue extends EtapaPipeline {
    private String ambiente;

    public EtapaDespliegue(String ambiente) {
        this.ambiente = ambiente;
    }

    protected boolean validar(CommitJob job) {
        System.out.println("Desplegando " + job.getHash() + " en ambiente: " + ambiente);
        System.out.println("Rama: " + job.getRama() + " Autor: " + job.getAutor());
        job.aprobar();
        return false;
    }

    protected String getNombre() {
        return "Deploy(" + ambiente + ")";
    }
}
