package main.dosw.semana3.Taller4.Ejercicio4;

public class PersonajeBase implements Personaje {
    private String nombre, armadura, arma, habilidad;
    public PersonajeBase(String n,String a,String ar,String h){ nombre=n;armadura=a;arma=ar;habilidad=h; }
    public void atacar() { System.out.println("["+nombre+"] Usa "+arma+" | Habilidad: "+habilidad); }
    public String describir() { return nombre+" | Armadura: "+armadura+" | Arma: "+arma+" | Habilidad: "+habilidad; }
}
