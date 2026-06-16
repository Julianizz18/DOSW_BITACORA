package main.dosw.semana3.Taller4.Ejercicio7;

public abstract class EtapaPipeline {
    private EtapaPipeline siguiente;

    public EtapaPipeline setSiguiente(EtapaPipeline s) {
        this.siguiente = s; return s;
    }

    public void ejecutar(CommitJob job) {
        if (!job.getEstado().getNombre().equals("EN_PIPELINE")
         && !job.getEstado().getNombre().equals("PENDIENTE")) {
            System.out.println(getClass().getSimpleName() + " omitido (estado: " + job.getEstado().getNombre() + ")");
            return;
        }
        if (validar(job)) {
            System.out.println("  [" + getNombre() + "] PASS");
            if (siguiente != null) siguiente.ejecutar(job);
            else job.aprobar();
        } else {
            job.fallar(getNombre() + " fallo");
        }
    }

    protected abstract boolean validar(CommitJob job);
    protected abstract String getNombre();
}
