package testes;

import code.ClientePrime;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ClientePrimeTest {
    private ClientePrime clientePrime;

    @Before
    public void setUp() {
        clientePrime = new ClientePrime("Maria", "12345678901", "Rua A, 100", 0.0);
    }

    @Test
    public void testeCreditarCashbackAposCompra() {
        double valorCompra = 200.0; 
        clientePrime.calcularECreditarCashback(valorCompra);
        double expectedCashback = valorCompra * 0.05; 
        assertEquals(expectedCashback, clientePrime.getSaldoCashback(), 0.01);
    }

    @Test
    public void testeAcumularCashbackComMultiplosCreditos() {
        clientePrime.calcularECreditarCashback(100.0); 
        clientePrime.calcularECreditarCashback(200.0); 
        double expectedCashback = (100.0 + 200.0) * 0.05; 
        assertEquals(expectedCashback, clientePrime.getSaldoCashback(), 0.01);
    }

    @Test
    public void naoDeveUsarCashbackAlemDoSaldo() {
        clientePrime.calcularECreditarCashback(100.0); 
        clientePrime.utilizarCashback(10.0); 
        clientePrime.utilizarCashback(10.0); 
        double expectedCashback = (100.0 * 0.05) - 10.0; 
        assertEquals(expectedCashback, clientePrime.getSaldoCashback(), 0.01);
    }

    @Test
    public void saldoCashbackNaoDeveSerNegativo() {
        clientePrime.calcularECreditarCashback(50.0); 
        clientePrime.utilizarCashback(100.0);
        assertTrue("Saldo de cashback não deve ser negativo.", clientePrime.getSaldoCashback() >= 0);
    }


}
