package main.dosw.semana3.Taller4.Ejercicio4;

public class ModFuria extends ModificadorUnidad {
    public ModFuria(Unidad base) { super(base); }

    public String getNombre() { return base.getNombre() + " <FURIA>"; }

    public Stats getStats() {
        Stats s = base.getStats();
        return new Stats(
            s.getVida(),
            (int)(s.getAtaque()  * 1.5),
            (int)(s.getDefensa() * 0.8),
            s.getVelocidad()
        );
    }

    public void ejecutarTurno() {
        System.out.println("[FURIA] Potencia de ataque x1.5, defensa reducida 20%");
        Stats s = getStats();
        System.out.println(">> " + getNombre() + " golpea con fuerza: " + s.getAtaque() + " de daño.");
    }
}
