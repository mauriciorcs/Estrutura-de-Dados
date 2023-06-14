import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mochila {
    private static List<Item> melhorSolucao;
    private static int melhorValor;

    public static List<Item> resolverMochila(List<Item> items, int pesoMax) {
        melhorSolucao = new ArrayList<>();
        melhorValor = 0;

        Collections.sort(items);

        backtrack(0, 0, new ArrayList<>(), items, pesoMax);

        return melhorSolucao;
    }

    private static void backtrack(int pesoAtual, int valorAtural, List<Item> solucaoAtual,
                                  List<Item> items, int pesoMax) {
        if (pesoAtual > pesoMax) {
            return;
        }

        if (valorAtural > melhorValor) {
            melhorValor = valorAtural;
            melhorSolucao = new ArrayList<>(solucaoAtual);
        }

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (!solucaoAtual.contains(item)) {
                solucaoAtual.add(item);
                backtrack(pesoAtual + item.peso, valorAtural + item.valor, solucaoAtual,
                        items.subList(i + 1, items.size()), pesoMax);
                solucaoAtual.remove(item);
            }
        }
    }

    public static void main(String[] args) {
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(4, 40));
        itens.add(new Item(7, 42));
        itens.add(new Item(5, 25));
        itens.add(new Item(3, 12));

        int capacidade = 10;

        List<Item> solucao = resolverMochila(itens, capacidade);

        System.out.println("Itens escolhidos:");
        for (Item item : solucao) {
            System.out.println("Peso: " + item.peso + ", Valor: " + item.peso);
        }

        System.out.println("Valor total: " + melhorValor);
    }
}
