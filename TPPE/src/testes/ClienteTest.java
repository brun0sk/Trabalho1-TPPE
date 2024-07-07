package testes;

import code.Cliente;
import code.Venda;
import code.Produto;
import code.VendasService;
import code.Venda.MetodoPagamento;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ClienteTest {

    private List<Venda> vendas;
    private Cliente cliente;
    private VendasService vendasService;

    @Before
    public void setUp() {
        vendas = new ArrayList<>();
        cliente = new Cliente("Ana Silva", "123.456.789-10", "Rua C, 789");
        vendasService = new VendasService();
    }

    @Test
    public void testeNaoAlterarStatusClienteParaEspecialSeTotalInferior() {
        VendasService service = new VendasService();
        Cliente cliente = new Cliente("Luisa", "5566778899", "Rua Inicio, 1");
        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda(new Date(), cliente, new ArrayList<>(), Venda.MetodoPagamento.PIX, 20.0, 5.0));

        service.atualizarStatusCliente(cliente, vendas);
        assertNotEquals("Não deve atualizar para Especial se o total for inferior a R$100.", "Especial", cliente.getTipo());
    }

    @Test
    public void testeCalcularTotalVendasUltimoMes() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -10);
        List<Produto> produtos = new ArrayList<>();
        vendas.add(new Venda(cal.getTime(), cliente, produtos, MetodoPagamento.CREDITO, 10.0, 5.0));
        double total = vendasService.calcularTotalVendasUltimoMes(cliente, vendas);
        assertEquals(110.0, total, 0.01);
    }

    @Test
    public void testeAtualizarClienteParaEspecialSeTotalMaiorQueCem() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -15);
        List<Produto> produtos = new ArrayList<>();
        vendas.add(new Venda(cal.getTime(), cliente, produtos, MetodoPagamento.DINHEIRO, 10.0, 5.0));
        vendasService.atualizarStatusCliente(cliente, vendas);
        assertEquals("Especial", cliente.getTipo());
    }
}
