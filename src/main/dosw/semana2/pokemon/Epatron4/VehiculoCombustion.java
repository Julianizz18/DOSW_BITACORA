package main.dosw.semana2.pokemon.Epatron4;

public class VehiculoCombustion implements SurtidorGasolineria {
    @Override
    public void abastecer(double litros) {
        System.out.println("Abasteciendo vehículo a combustión con " + litros + " litros de gasolina");
    }
}
