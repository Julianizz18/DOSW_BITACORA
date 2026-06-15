package main.dosw.semana2.pokemon.Epatron9;
public class ControlJuego {
    private Comando botonA;
    private Comando botonB;
    private Comando botonX;
    private Comando botonY;
    public void setBotonA(Comando comando) {
        this.botonA = comando;
    }
    public void setBotonB(Comando comando) {
        this.botonB = comando;
    }
    public void setBotonX(Comando comando) {
        this.botonX = comando;
    }
    public void setBotonY(Comando comando) {
        this.botonY = comando;
    }
    public void presionarA() {
        if (botonA != null) botonA.ejecutar();
    }
    public void presionarB() {
        if (botonB != null) botonB.ejecutar();
    }
    public void presionarX() {
        if (botonX != null) botonX.ejecutar();
    }
    public void presionarY() {
        if (botonY != null) botonY.ejecutar();
    }
}
