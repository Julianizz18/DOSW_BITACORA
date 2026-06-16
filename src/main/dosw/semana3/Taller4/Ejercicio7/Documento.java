package main.dosw.semana3.Taller4.Ejercicio7;

public class Documento {
    private String titulo; private EstadoDocumento estado;
    public Documento(String t){
        titulo=t; estado=new EstadoBorrador();
    }
    public void setEstado(EstadoDocumento e){
        estado=e;
    }
    public EstadoDocumento getEstado(){
        return estado;
    }
    public void aprobar(){
        estado.aprobar(this);
    }
    public void rechazar(){
        estado.rechazar(this);
    }
    public void mostrarEstado(){
        System.out.println("Documento '"+titulo+"' -> "+estado.getNombre());
    }
}
