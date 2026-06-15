package main.dosw.semana2.pokemon.Epatron3;

// Producto complejo
public class Muneco {
    private String cabeza;
    private String cuerpo;
    private String brazos;
    private String piernas;
    private String accesorios;

    public void setCabeza(String cabeza) {
        this.cabeza = cabeza;
    }
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    public void setBrazos(String brazos) {
        this.brazos = brazos;
    }
    public void setPiernas(String piernas) {
        this.piernas = piernas;
    }
    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    @Override
    public String toString() {
        return "Muneco{cabeza='" + cabeza + "', cuerpo='" + cuerpo +
               "', brazos='" + brazos + "', piernas='" + piernas +
               "', accesorios='" + (accesorios != null ? accesorios : "ninguno") + "'}";
    }
}
