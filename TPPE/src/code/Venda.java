package code;

import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;
    private MetodoPagamento metodoPagamento;
    private double valorFrete;
    private double desconto;
    private double impostoICMS;
    private double impostoMunicipal;
    private double valorFinal;

    public Venda(Date data, Cliente cliente, List<Produto> produtos, MetodoPagamento metodoPagamento, double valorFrete, double desconto) {
        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
        this.metodoPagamento = metodoPagamento;
        this.valorFrete = valorFrete;
        this.desconto = desconto;
        this.valorTotal = calcularValorTotal();
        this.impostoICMS = calcularImpostoICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.valorFinal = calcularValorFinal();
    }

    private double calcularValorTotal() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco() * produto.getQuantidade();
        }
        return total;
    }

    public double calcularImpostoICMS() {
        // Suponha uma taxa de ICMS de 18%
        return valorTotal * 0.18;
    }

    public double calcularImpostoMunicipal() {
        //Suponha uma taxa de imposto municipal de 5%
        return valorTotal * 0.05;
    }

    private double calcularValorFinal() {
        double totalComImpostos = valorTotal + impostoICMS + impostoMunicipal;
        double totalComFreteDesconto = totalComImpostos + valorFrete - desconto;

        if (cliente instanceof ClientePrime) {
            ClientePrime clientePrime = (ClientePrime) cliente;
            double saldoCashback = clientePrime.getSaldoCashback();
            if (saldoCashback > totalComFreteDesconto) {
                clientePrime.utilizarCashback(totalComFreteDesconto);
                return 0.0;
            } else {
                clientePrime.utilizarCashback(saldoCashback);
                return totalComFreteDesconto - saldoCashback;
            }
        }

        return totalComFreteDesconto;
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
        return valorTotal;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getImpostoICMS() {
        return impostoICMS;
    }

    public double getImpostoMunicipal() {
        return impostoMunicipal;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public enum MetodoPagamento {
        CREDITO, DEBITO, DINHEIRO, PIX, BOLETO
    }
}
