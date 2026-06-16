package main.dosw.semana3.Taller4.Ejercicio10;

import java.util.ArrayDeque;
import java.util.Deque;

public class EditorTexto {
    ContextoTexto ctx;
    private Deque<ComandoTransformacion> historial  = new ArrayDeque<>();
    private Deque<ComandoTransformacion> pilaRehace = new ArrayDeque<>();

    public EditorTexto(String textoInicial) {
        ctx = new ContextoTexto(new TextoBase(textoInicial));
    }

    public void aplicar(ComandoTransformacion cmd) {
        cmd.ejecutar();
        historial.push(cmd);
        pilaRehace.clear();
        mostrar();
    }

    public void deshacer() {
        if (historial.isEmpty()) { System.out.println("Nada que deshacer."); return; }
        ComandoTransformacion cmd = historial.pop();
        cmd.deshacer();
        pilaRehace.push(cmd);
        mostrar();
    }

    public void rehacer() {
        if (pilaRehace.isEmpty()) { System.out.println("Nada que rehacer."); return; }
        ComandoTransformacion cmd = pilaRehace.pop();
        cmd.ejecutar();
        historial.push(cmd);
        mostrar();
    }

    private void mostrar() {
        System.out.println("  Pipeline : " + ctx.getActual().getDescripcion());
        System.out.println("  Resultado: " + ctx.getActual().obtenerTexto());
        System.out.println();
    }
}
