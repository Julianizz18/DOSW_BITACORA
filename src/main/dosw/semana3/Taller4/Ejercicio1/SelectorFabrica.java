package main.dosw.semana3.Taller4.Ejercicio1;

public class SelectorFabrica {
    public static FabricaPagos obtener(String pais) {
        switch(pais.toLowerCase()) {
            case "colombia": return new FabricaColombia(); case "usa": return new FabricaUsa();
            default: throw new IllegalArgumentException("Pais no soportado: "+pais);
        }
    }
}
