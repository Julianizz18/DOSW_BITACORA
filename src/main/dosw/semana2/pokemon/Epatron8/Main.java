package main.dosw.semana2.pokemon.Epatron8;

public class Main {
    public static void main(String[] args) {
        ControlMigratorio pasaporteVisa = new ControlPasaporteVisa();
        ControlMigratorio antecedentes = new ControlAntecedentes();
        ControlMigratorio motivoViaje = new ControlMotivoViaje();
        ControlMigratorio aprobacion = new AprobacionMigracion();
        pasaporteVisa.setSiguiente(antecedentes).setSiguiente(motivoViaje).setSiguiente(aprobacion);
        System.out.println("Viajero 1: Todo en orden ");
        Viajero v1 = new Viajero("Carlos Lopez", true, true, false, "Turismo");
        pasaporteVisa.verificar(v1);
        System.out.println("\nViajero 2: Sin visa");
        Viajero v2 = new Viajero("Maria Garcia", true, false, false, "Negocios");
        pasaporteVisa.verificar(v2);
        System.out.println("\nViajero 3: Con antecedentes");
        Viajero v3 = new Viajero("Pedro Ramirez", true, true, true, "Visita familiar");
        pasaporteVisa.verificar(v3);
    }
}
