package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import code.Cliente;
import code.ClientePrime;
import code.Produto;
import code.Venda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaTest {

    private Cliente cliente;
    private ClientePrime clientePrime;
    private Produto produto1;
    private Produto produto2;
    private List<Produto> produtos;
    private Venda venda;

    @Before
    public void setUp() {
        cliente = new Cliente("João da Silva", "123.456.789-00", "Rua A, 123");
        clientePrime = new ClientePrime("Maria Prime", "987.654.321-00", "Rua B, 456", 100.0);
        produto1 = new Produto("001", "Notebook", "Notebook de alta performance", 2000.00, "Unidade", 2000.00, 1);
        produto2 = new Produto("002", "Mouse", "Mouse sem fio", 50.00, "Unidade", 50.00, 2);
        produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
    }

    @Test
    public void testCalcularValorTotal() {
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        double expectedValue = 2000.00 + (50.00 * 2);
        assertEquals(expectedValue, venda.getValorTotal(), 0.01);
    }

    @Test
    public void testCalcularValorFinal() {
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        double expectedValue = (2000.00 + (50.00 * 2)) * 1.23 + 20.0 - 10.0; // 1.23 = 1 + ICMS (18%) + Imposto Municipal (5%)
        assertEquals(expectedValue, venda.getValorFinal(), 0.01);
    }

    @Test
    public void testCalcularValorFinalClientePrime() {
        venda = new Venda(new Date(), clientePrime, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        double valorTotal = 2000.00 + (50.00 * 2);
        double impostos = valorTotal * 0.23; // 18% ICMS + 5% imposto municipal
        double totalComImpostos = valorTotal + impostos;
        double totalComFreteDesconto = totalComImpostos + 20.0 - 10.0;
        double expectedValue = totalComFreteDesconto - 100.0; // Cliente prime usa o cashback de 100.0

        assertEquals(expectedValue, venda.getValorFinal(), 0.01);
    }

    @Test
    public void testGetCliente() {
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        assertEquals("João da Silva", venda.getCliente().getNome());
        assertEquals("123.456.789-00", venda.getCliente().getCpf());
    }

    @Test
    public void testGetProdutos() {
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        assertEquals(2, venda.getProdutos().size());
        assertEquals("Notebook", venda.getProdutos().get(0).getNome());
        assertEquals("Mouse", venda.getProdutos().get(1).getNome());
    }

    @Test
    public void testGetData() {
        Date now = new Date();
        venda = new Venda(now, cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        assertEquals(now, venda.getData());
    }

    @Test
    public void testValorTotalComProdutoSemQuantidade() {
    	Produto produto3 = new Produto("003", "Teclado", "Teclado mecânico", 100.00, "Unidade", 100.00, 0);
        produtos.add(produto3);
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        double expectedValue = 2000.00 + (50.00 * 2) + (100.00 * 0);
        assertEquals(expectedValue, venda.getValorTotal(), 0.01);
    }
    @Test
    public void testCalcularDesconto() {
        double desconto = 50.0; // Exemplo de desconto
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, desconto);
        double valorTotal = 2000.00 + (50.00 * 2);
        double expectedValue = valorTotal - desconto;
        assertEquals(expectedValue, venda.getValorTotal() - desconto, 0.01);
    }
    
    @Test
    public void testCalcularICMS() {
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        double valorTotal = 2000.00 + (50.00 * 2);
        double expectedICMS = valorTotal * 0.18; // 18% ICMS
        assertEquals(expectedICMS, venda.calcularImpostoICMS(), 0.01);
    }

    @Test
    public void testCalcularImpostoMunicipal() {
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, 20.0, 10.0);
        double valorTotal = 2000.00 + (50.00 * 2);
        double expectedImpostoMunicipal = valorTotal * 0.05; // 5% Imposto Municipal
        assertEquals(expectedImpostoMunicipal, venda.calcularImpostoMunicipal(), 0.01);
    }
   
    @Test
    public void testCalcularValorFrete() {
        double valorFrete = 20.0; // Exemplo de valor de frete
        venda = new Venda(new Date(), cliente, produtos, Venda.MetodoPagamento.CREDITO, valorFrete, 10.0);
        assertEquals(valorFrete, venda.getValorFrete(), 0.01);
    }
    
    
}
