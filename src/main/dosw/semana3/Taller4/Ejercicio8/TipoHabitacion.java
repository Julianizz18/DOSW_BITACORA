package main.dosw.semana3.Taller4.Ejercicio8;

public enum TipoHabitacion {
    SENCILLA, DOBLE, SUITE, PRESIDENCIAL;

    public double tarifaPorNoche() {
        switch (this) {
            case SENCILLA:     return 120000;
            case DOBLE:        return 180000;
            case SUITE:        return 350000;
            case PRESIDENCIAL: return 800000;
            default:           return 120000;
        }
    }
}
