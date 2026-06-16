package main.dosw.semana3.Taller4.Ejercicio10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editor de Texto Enriquecido");
        System.out.print("Ingrese el texto a editar: ");
        String textoInicial = sc.nextLine();
        EditorTexto editor = new EditorTexto(textoInicial);
        System.out.println("Texto cargado: " + editor.ctx.getActual().obtenerTexto());
        System.out.println("\nComandos: aplicar, deshacer, rehacer, ver, salir");
        System.out.println("Transformaciones: mayusculas, censurar, numerarlineas, invertir");
        boolean continuar = true;
        while (continuar) {
            System.out.print("\nComando: ");
            String cmd = sc.nextLine().trim().toLowerCase();
            switch (cmd) {
                case "aplicar":
                    System.out.print("  Transformacion: ");
                    String trans = sc.nextLine().trim().toLowerCase();
                    switch (trans) {
                        case "mayusculas":
                            editor.aplicar(new CmdMayusculas(editor.ctx)); break;
                        case "censurar":
                            System.out.print("  Palabra a censurar: ");
                            String pal = sc.nextLine().trim();
                            editor.aplicar(new CmdCensurar(editor.ctx, pal)); break;
                        case "numerarlineas":
                            editor.aplicar(new CmdNumerarLineas(editor.ctx)); break;
                        case "invertir":
                            editor.aplicar(new CmdInvertir(editor.ctx)); break;
                        default:
                            System.out.println("  Transformacion desconocida.");
                    }
                    break;
                case "deshacer": editor.deshacer(); break;
                case "rehacer":  editor.rehacer();  break;
                case "ver":
                    System.out.println("  Texto actual: " + editor.ctx.getActual().obtenerTexto());
                    break;
                case "salir": continuar = false; break;
                default: System.out.println("Comando no reconocido.");
            }
        }
        sc.close();
    }
}
