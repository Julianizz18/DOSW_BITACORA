package main.dosw.semana3.Taller4.Ejercicio5;

public class ServicioBancoLegado {
    private int saldoCentavos;
    public ServicioBancoLegado(int s){
        saldoCentavos=s;
    }
    public boolean realizarTransaccion(String c, int centavos) {
        if(saldoCentavos>=centavos){saldoCentavos-=centavos; System.out.println("Transaccion("+c+", "+centavos+" centavos) -> OK"); return true;}
        System.out.println("Saldo insuficiente."); return false;
    }
    public int consultarSaldoCentavos(String c){
        System.out.println(" Saldo("+c+") -> "+saldoCentavos+" centavos");
        return saldoCentavos; }
}
