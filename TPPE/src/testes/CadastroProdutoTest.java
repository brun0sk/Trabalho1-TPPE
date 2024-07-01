package testes;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import code.Produto;

public class CadastroProdutoTest {
	Produto produto;
	
	@Before
	public void setup() {
		produto = new Produto();
	}

	@Test
	public void testCadastrarUmProduto() {
		produto.cadastarProduto(1, "Banana", 6.00, "Kg");
		assertEquals(1, produto.getcodigo(), 0);
	}

	@Test
	public void testCadastrarDoisProdutos() {
		produto.cadastarProduto(2, "Arroz", 22.00, "Kg");
		produto.cadastarProduto(3, "Caixa Chocolate", 12.00, "unidade");
		assertEquals(3, produto.getcodigo(), 0);
	}

	@Test
	public void testCadastrarTresProdutos() {
		produto.cadastarProduto(4, "Café", 15.00, "Unidade");
		produto.cadastarProduto(5, "Feijão", 8.00, "g");
		produto.cadastarProduto(6, "Alho", 20.00, "Kg");
		assertEquals(6, produto.getcodigo(), 0);
	}
}
