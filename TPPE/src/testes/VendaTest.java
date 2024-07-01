package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import code.Cliente;
import code.Produto;
import code.Venda;

public class VendaTest {

    private Cliente cliente;
    private Produto produto1;
    private Produto produto2;
    private List<Produto> produtos;
    private Venda venda;

    @Before
    public void setUp() {
        cliente = new Cliente("João da Silva", "123.456.789-00");
        produto1 = new Produto("Notebook", 2000.00, 1);
        produto2 = new Produto("Mouse", 50.00, 2);
        produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        venda = new Venda(new Date(), cliente, produtos);
    }

    @Test
    public void testCalcularValorTotal() {
        double expectedValue = 2000.00 + (50.00 * 2);
        assertEquals(expectedValue, venda.getValorTotal(), 0.01);
    }

    @Test
    public void testGetCliente() {
        assertEquals("João da Silva", venda.getCliente().getNome());
        assertEquals("123.456.789-00", venda.getCliente().getCpf());
    }

    @Test
    public void testGetProdutos() {
        assertEquals(2, venda.getProdutos().size());
        assertEquals("Notebook", venda.getProdutos().get(0).getNome());
        assertEquals("Mouse", venda.getProdutos().get(1).getNome());
    }

    @Test
    public void testGetData() {
        Date now = new Date();
        venda = new Venda(now, cliente, produtos);
        assertEquals(now, venda.getData());
    }

    @Test
    public void testValorTotalComProdutoSemQuantidade() {
        Produto produto3 = new Produto("Teclado", 100.00, 0);
        produtos.add(produto3);
        venda = new Venda(new Date(), cliente, produtos);
        double expectedValue = 2000.00 + (50.00 * 2) + (100.00 * 0);
        assertEquals(expectedValue, venda.getValorTotal(), 0.01);
    }
}
