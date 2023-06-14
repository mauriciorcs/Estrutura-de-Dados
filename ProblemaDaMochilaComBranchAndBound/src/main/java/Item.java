import java.util.Objects;

public class Item implements Comparable<Item> {

    int peso;
    int valor;
    double razao;

    public Item(int peso, int valor) {
        this.peso = peso;
        this.valor = valor;
        this.razao = (double) valor / peso;
    }

    @Override
    public int compareTo(Item other) {
        if (this.razao > other.razao) {
            return -1;
        } else if (this.razao < other.razao) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return peso == item.peso && valor == item.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peso, valor);
    }
}
