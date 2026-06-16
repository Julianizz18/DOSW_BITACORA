package main.dosw.semana3.Taller4.Ejercicio4;
public class UnidadBase implements Unidad {
    private String nombre;
    private String clase;
    private Stats stats;
    public UnidadBase(String nombre, String clase, Stats stats) {
        this.nombre = nombre;
        this.clase  = clase;
        this.stats  = stats;
    }

    public String getNombre() {
        return nombre + " [" + clase + "]";
    }
    public Stats  getStats()  {
        return stats;
    }

    public void ejecutarTurno() {
        System.out.println("> " + getNombre() + " ataca causando " + stats.getAtaque() + " de danio base.");
    }
}
