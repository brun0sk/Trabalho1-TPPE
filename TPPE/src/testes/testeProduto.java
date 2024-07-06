package testes;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class testeProduto {

    String codigo;
    String descricao;
    double valorVenda;
    String unidade;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] resposta = new  Object[][] {
            {"P001", "Banana", 8.00, "Kg"},
            {"P002", "Feijão", 9.00, "unidade"},
            {"P003", "Arroz", 25.00, "unidade"},
            {"P004", "Café", 18.00, "unidade"}
        };
        return Arrays.asList(resposta);
    }

    public testeProduto(String codigo, String descricao, double valorVenda, String unidade){
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.unidade = unidade;
    }

    @Test
    public void testeCadastroProduto(){
        Produto produto = new Produto(codigo, descricao, valorVenda, unidade);
        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valorVenda, produto.getValorVenda(), 0.01);
        assertEquals(unidade, produto.getUnidade());
    }
    
}