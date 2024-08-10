package code;

import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private Cliente cliente;
    private List<Produto> produtos;
    private NotaFiscal notaFiscal;
    private MetodoPagamento metodoPagamento;

    public Venda(Date data, Cliente cliente, List<Produto> produtos, MetodoPagamento metodoPagamento, double valorFrete, double desconto) {
        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
        this.metodoPagamento = metodoPagamento;

        double valorTotal = calcularValorTotal();
        this.notaFiscal = new NotaFiscal(valorTotal, valorFrete, desconto, cliente);
    }

    private double calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getValorTotal() {
        return notaFiscal.getValorTotal();
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public double getValorFrete() {
        return notaFiscal.getValorTotal();
    }

    public double getDesconto() {
        return notaFiscal.getValorTotal();
    }

    public double getImpostoICMS() {
        return notaFiscal.getImpostoICMS();
    }

    public double getImpostoMunicipal() {
        return notaFiscal.getImpostoMunicipal();
    }

    public double getValorFinal() {
        return notaFiscal.getValorFinal();
    }

    public enum MetodoPagamento {
        CREDITO, DEBITO, DINHEIRO, PIX, BOLETO
    }
}
