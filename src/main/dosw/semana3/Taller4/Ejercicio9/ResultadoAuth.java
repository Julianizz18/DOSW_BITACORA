package main.dosw.semana3.Taller4.Ejercicio9;

public class ResultadoAuth {
    private boolean valido;
    private String rol;
    public ResultadoAuth(boolean v,String u,String r){
        valido=v;rol=r;
    }
    public boolean isValido(){
        return valido;
    }
    public String getRol(){
        return rol;
    }
}
