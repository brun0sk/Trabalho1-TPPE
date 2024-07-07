package testes;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import code.ClientEspecial;

@RunWith(Parameterized.class)
public class ClienteEspecialTest {
	ClientEspecial clienteEspecial;
	String nome; 
	String cpf;
	String endereco;

    @Parameters
    public static Collection<Object[]> getParameters() {
    	 Object[][] resposta = new  Object[][] {
    		 {"Mario", "50345678901", "Rua A, 100"},
    		 {"Marlon", "50345678222", "Rua B, 100"},
    		 {"Gustavo", "50345678988", "Rua C, 100"}
    	 };
    	 return Arrays.asList(resposta);
    }
    
    public ClienteEspecialTest(String nome, String cpf, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

	@Test
    public void testeDescontoCompraCartaoLoja() {
		clienteEspecial = new ClientEspecial(nome, cpf, endereco);
        double valorCompra = 200.0;
        String numeroCartao = "4296131111111111";
        double desconto = clienteEspecial.calcularDesconto(valorCompra, numeroCartao);
        double valorEsperado = valorCompra * 0.1; 
        assertEquals(valorEsperado, desconto, 0.01);
    }
    
    @Test
    public void testeDescontoCompraSemCartaoLoja() {
    	clienteEspecial = new ClientEspecial(nome, cpf, endereco);
        double valorCompra = 200.0;
        String numeroCartao = "4776131111111111";
        double desconto = clienteEspecial.calcularDesconto(valorCompra, numeroCartao);
        double valorEsperado = 0; 
        assertEquals(valorEsperado, desconto, 0.01);
    }
    
    @Test
    public void testeDescontoFrete() {
    	clienteEspecial = new ClientEspecial(nome, cpf, endereco);
    	double valorFrete = 15.0;
        double descontoFrete = clienteEspecial.calcularDescontoFrete(valorFrete);
        double valorEsperado = valorFrete * 0.3; 
        assertEquals(valorEsperado, descontoFrete, 0.01);
    }
    
}
