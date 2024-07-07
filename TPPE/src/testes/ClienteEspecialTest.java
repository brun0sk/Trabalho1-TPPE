package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import code.ClientEspecial;

public class ClienteEspecialTest {
	private ClientEspecial clienteEspecial;

    @Before
    public void setUp() {
        clienteEspecial= new ClientEspecial("Mario", "50345678901", "Rua A, 100");
    }

	@Test
    public void testeDescontoCompraCartaoLoja() {
        double valorCompra = 200.0;
        String numeroCartao = "4296131111111111";
        double desconto = clienteEspecial.calcularDesconto(valorCompra, numeroCartao);
        double valorEsperado = valorCompra * 0.1; 
        assertEquals(valorEsperado, desconto, 0.01);
    }
    
    @Test
    public void testeDescontoCompraSemCartaoLoja() {
        double valorCompra = 200.0;
        String numeroCartao = "4776131111111111";
        double desconto = clienteEspecial.calcularDesconto(valorCompra, numeroCartao);
        double valorEsperado = 0; 
        assertEquals(valorEsperado, desconto, 0.01);
    }
    
    @Test
    public void testeDescontoFrete() {
    	double valorFrete = 15.0;
        double descontoFrete = clienteEspecial.calcularDescontoFrete(valorFrete);
        double valorEsperado = valorFrete * 0.3; 
        assertEquals(valorEsperado, descontoFrete, 0.01);
    }
    
}
