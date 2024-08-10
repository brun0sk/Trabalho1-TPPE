package testes;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import code.Produto;

@RunWith(Parameterized.class)
public class testeProduto {

    String codigo;
    String nome;
    String descricao;
    double valorVenda;
    String unidade;

    @Parameters
    public static Collection<Object[]> getParameters(){
        Object[][] resposta = new  Object[][] {
            {"001", "Notebook", "Asus, I5 11º, 4GB RAM, SSD 256GB, Cinza", 2500.00, "unidade"},
            {"002", "S24 Ultra", "Snapdragon 8 Gen 3, 12GB RAM, 512GB ROM, Titanio Preto",7300.00, "unidade"},
            {"003", "Iphone 15 Pro Max", "A17 PRO, 8GB RAM, 256GB ROM, Titanio Natural", 9000.00, "unidade"}
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
        Produto produto = new Produto(this.codigo, this.nome, this.descricao, this.valorVenda, this.unidade, 50.00, 2);
        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valorVenda, produto.getValorVenda(), 0.01);
        assertEquals(unidade, produto.getUnidade());
    }
    
}