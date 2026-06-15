package main.dosw.semana3.Taller4.Ejercicio2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Notificaciones varias del sistema");
        System.out.print("ID del pedido: ");
        String id = sc.nextLine().trim();
        Pedido pedido = new Pedido(id);
        System.out.println("Canales disponibles para enviar los mensajes: email, sms, push");
        System.out.print("Canales activos: ");
        for (String c : sc.nextLine().trim().split(",")) {
            switch(c.trim().toLowerCase()) {
                case "email": pedido.agregarObservador(new NotificadorEmail()); break;
                case "sms":   pedido.agregarObservador(new NotificadorSms());   break;
                case "push":  pedido.agregarObservador(new NotificadorPush());  break;
                default: System.out.println("Canal desconocido: "+c.trim());
            }
        }
        boolean cont = true;
        while (cont) {
            System.out.print("Nuevo estado (o 'salir'): ");
            String e = sc.nextLine().trim();
            if (e.equalsIgnoreCase("salir")) cont=false;
            else pedido.cambiarEstado(e.toUpperCase());
        }
        sc.close();
    }
}
