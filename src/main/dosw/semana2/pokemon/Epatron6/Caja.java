package main.dosw.semana2.pokemon.Epatron6;
import java.util.ArrayList;
import java.util.List;

public class Caja implements ItemBodega {
    private String nombre;
    private List<ItemBodega> items = new ArrayList<>();
    public Caja(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ItemBodega item) {
        items.add(item);
    }

    public void eliminar(ItemBodega item) {
        items.remove(item);
    }

    @Override
    public double calcularPrecio() {
        double total = 0;
        for (ItemBodega item : items) {
            total += item.calcularPrecio();
        }
        return total;
    }

    @Override
    public void mostrar(String indentacion) {
        System.out.println(indentacion + "Caja: " + nombre);
        for (ItemBodega item : items) {
            item.mostrar(indentacion + "  ");
        }
    }
}
