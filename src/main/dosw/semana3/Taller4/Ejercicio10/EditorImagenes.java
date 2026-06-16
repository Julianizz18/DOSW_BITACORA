package main.dosw.semana3.Taller4.Ejercicio10;

import java.util.ArrayDeque; import java.util.Deque;
public class EditorImagenes {
    ContextoImagen ctx; private Deque<ComandoFiltro> historial=new ArrayDeque<>(),pila=new ArrayDeque<>();
    public EditorImagenes(String f){
        ctx=new ContextoImagen(new ImagenOriginal(f));
    }
    public void aplicar(ComandoFiltro c){
        c.ejecutar();
        historial.push(c);
        pila.clear();
        mostrar();
    }
    public void deshacer(){
        if(historial.isEmpty()){
            System.out.println("Historial vacio.");
            return;
        }
        ComandoFiltro c=historial.pop();
        c.deshacer();
        pila.push(c);
        mostrar();
    }
    public void rehacer(){
        if(pila.isEmpty()){
            System.out.println("Nada que rehacer.");
            return;
        }
        ComandoFiltro c=pila.pop();
        c.ejecutar();
        historial.push(c);
        mostrar();
    }
    private void mostrar(){
        System.out.println("Vista: "+ctx.getActual().renderizar()+"\n");
    }
}
