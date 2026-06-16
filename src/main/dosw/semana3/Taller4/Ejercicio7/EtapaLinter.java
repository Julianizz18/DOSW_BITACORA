package main.dosw.semana3.Taller4.Ejercicio7;

public class EtapaLinter extends EtapaPipeline {
    private String reglasActivas;

    public EtapaLinter(String reglas) {
        this.reglasActivas = reglas;
    }

    protected boolean validar(CommitJob job) {
        System.out.println("Revisando estilo con reglas: " + reglasActivas);
        System.out.println("Autor: " + job.getAutor() + "Archivo: src/**/*.java");
        return true;
    }

    protected String getNombre() {
        return "Linter(" + reglasActivas + ")";
    }
}
