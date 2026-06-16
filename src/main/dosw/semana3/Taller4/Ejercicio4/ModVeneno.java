package main.dosw.semana3.Taller4.Ejercicio4;
public class ModVeneno extends ModificadorUnidad {
    public ModVeneno(Unidad base) { super(base); }
    public String getNombre() { return base.getNombre() + " <VENENO>"; }
    public Stats getStats() {
        Stats s = base.getStats();
        return new Stats(
            (int)(s.getVida()   * 0.9),
            s.getAtaque() + 15,
            s.getDefensa(),
            s.getVelocidad()
        );
    }
    public void ejecutarTurno() {
        System.out.println("[VENENO] Ataque +15 de daño toxico, vida propia -10%");
        Stats s = getStats();
        System.out.println(">> " + getNombre() + " envenena al enemigo: " + s.getAtaque() + " de daño total.");
    }
}
