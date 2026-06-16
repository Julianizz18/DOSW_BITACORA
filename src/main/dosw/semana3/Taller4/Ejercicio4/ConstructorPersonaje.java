package main.dosw.semana3.Taller4.Ejercicio4;

public class ConstructorPersonaje {
    private String nombre, armadura="Tela", arma="Daga", habilidad="Ataque basico";
    public ConstructorPersonaje(String n){ nombre=n; }
    public ConstructorPersonaje conArmadura(String a){ armadura=a; return this; }
    public ConstructorPersonaje conArma(String a){ arma=a; return this; }
    public ConstructorPersonaje conHabilidad(String h){ habilidad=h; return this; }
    public Personaje construir(){ return new PersonajeBase(nombre,armadura,arma,habilidad); }
}
