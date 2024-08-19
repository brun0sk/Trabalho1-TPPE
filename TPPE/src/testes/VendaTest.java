package testes;

import code.Cliente;
import code.ClientePrime;
import code.NotaFiscal;
import org.junit.Test;

class NotaFiscalTest {

    @Test
    void testCalcularImpostoICMS() {
        Cliente cliente = new Cliente("João Silva", null, null);
        NotaFiscal notaFiscal = new NotaFiscal(1000.0, 50.0, 100.0, cliente);

        assertEquals(180.0, notaFiscal.calcularImpostoICMS(), 0.01);
    }

    private void assertEquals(double d, double calcularImpostoICMS, double e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    void testCalcularImpostoMunicipal() {
        Cliente cliente = new Cliente("João Silva", null, null);
        NotaFiscal notaFiscal = new NotaFiscal(1000.0, 50.0, 100.0, cliente);

        assertEquals(50.0, notaFiscal.calcularImpostoMunicipal(), 0.01);
    }

    @Test
    void testCalcularValorFinalSemClientePrime() {
        Cliente cliente = new Cliente("João Silva", null, null);
        NotaFiscal notaFiscal = new NotaFiscal(1000.0, 50.0, 100.0, cliente);

        double valorFinalEsperado = 1180.0; // valorTotal + ICMS + Municipal + Frete - Desconto
        assertEquals(valorFinalEsperado, notaFiscal.getValorFinal(), 0.01);
    }

    @Test
    void testCalcularValorFinalComClientePrimeSemCashback() {
        ClientePrime clientePrime = new ClientePrime("Maria Souza", null, null, 0.0);
        NotaFiscal notaFiscal = new NotaFiscal(1000.0, 50.0, 100.0, clientePrime);

        double valorFinalEsperado = 1180.0; // valorTotal + ICMS + Municipal + Frete - Desconto
        assertEquals(valorFinalEsperado, notaFiscal.getValorFinal(), 0.01);
    }

    @Test
    void testCalcularValorFinalComClientePrimeComCashback() {
        ClientePrime clientePrime = new ClientePrime("Maria Souza", null, null, 500.0);
        NotaFiscal notaFiscal = new NotaFiscal(1000.0, 50.0, 100.0, clientePrime);

        double valorFinalEsperado = 680.0; // valorFinal - saldoCashback (500.0)
        assertEquals(valorFinalEsperado, notaFiscal.getValorFinal(), 0.01);
    }
}
