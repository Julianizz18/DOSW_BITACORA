package main.dosw.semana3.Taller4.Ejercicio4;
public class ModCoraza extends ModificadorUnidad {
    public ModCoraza(Unidad base) { super(base); }
    public String getNombre() { return base.getNombre() + " <CORAZA>"; }
    public Stats getStats() {
        Stats s = base.getStats();
        return new Stats(
            (int)(s.getVida()      * 1.3),
            s.getAtaque(),
            (int)(s.getDefensa()   * 1.8),
            (int)(s.getVelocidad() * 0.7)
        );
    }

    public void ejecutarTurno() {
        System.out.println("[CORAZA] Defensa x1.8, vida +30%, velocidad -30%");
        Stats s = getStats();
        System.out.println(">> " + getNombre() + " resiste el impacto con " + s.getDefensa() + " de defensa.");
    }
}
