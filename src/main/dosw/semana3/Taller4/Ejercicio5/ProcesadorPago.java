package main.dosw.semana3.Taller4.Ejercicio5;

public interface ProcesadorPago {
    boolean cobrar(double monto);
    double consultarSaldo();
}
