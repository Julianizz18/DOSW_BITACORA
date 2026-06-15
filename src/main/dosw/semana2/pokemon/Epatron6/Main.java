package main.dosw.semana2.pokemon.Epatron6;

public class Main {
    public static void main(String[] args) {
        Producto laptop = new Producto("Laptop", 1500.00);
        Producto mouse = new Producto("Mouse", 25.00);
        Producto teclado = new Producto("Teclado", 45.00);
        Producto libro = new Producto("Libro Java", 35.00);
        Producto usb = new Producto("USB", 15.00);
        Caja cajaAccesorios = new Caja("Accesorios");
        cajaAccesorios.agregar(mouse);
        cajaAccesorios.agregar(teclado);
        Caja cajaElectronicos = new Caja("Electrónicos");
        cajaElectronicos.agregar(laptop);
        cajaElectronicos.agregar(cajaAccesorios);
        Caja cajaGeneral = new Caja("General");
        cajaGeneral.agregar(cajaElectronicos);
        cajaGeneral.agregar(libro);
        cajaGeneral.agregar(usb);
        cajaGeneral.mostrar("");
        System.out.println("Precio total: $" + cajaGeneral.calcularPrecio());
    }
}
