import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class MochilaTest {
    private List<Item> itens;
    private int capacidade;

    @BeforeEach
    void setUp() {
        itens = new ArrayList<>();

        itens.add(new Item(4, 40));
        itens.add(new Item(7, 42));
        itens.add(new Item(5, 25));
        itens.add(new Item(3, 12));

        capacidade = 10;

    }

    @Test
    void mochilaTest() {

        List<Item> solucao = Mochila.resolverMochila(itens, capacidade);

        assertEquals(2, solucao.size());
        assertTrue(solucao.contains(new Item(4, 40)));
        assertTrue(solucao.contains(new Item(5, 25)));

    }

    @Test
    void mochilaVaziaTest() {
        capacidade = 0;

        List<Item> solucao = Mochila.resolverMochila(itens, capacidade);

        assertEquals(0, solucao.size());
    }

    @Test
    void MachilaSemSolucao() {
        itens.clear();
        itens.add(new Item(6, 8));
        itens.add(new Item(4, 5));
        itens.add(new Item(3, 3));

        capacidade = 2;

        List<Item> solucao = Mochila.resolverMochila(itens, capacidade);

        assertEquals(0, solucao.size());
    }
}