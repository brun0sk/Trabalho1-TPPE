package code;

public class NotaFiscal {
    private double valorTotal;
    private double valorFrete;
    private double desconto;
    private double impostoICMS;
    private double impostoMunicipal;
    private double valorFinal;
    private Cliente cliente;

    public NotaFiscal(double valorTotal, double valorFrete, double desconto, Cliente cliente) {
        this.valorTotal = valorTotal;
        this.valorFrete = valorFrete;
        this.desconto = desconto;
        this.cliente = cliente;
        this.impostoICMS = calcularImpostoICMS();
        this.impostoMunicipal = calcularImpostoMunicipal();
        this.valorFinal = calcularValorFinal();
    }

    public double calcularImpostoICMS() {
        return valorTotal * 0.18; // Taxa de ICMS de 18%
    }

    public double calcularImpostoMunicipal() {
        return valorTotal * 0.05; // Taxa de imposto municipal de 5%
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

        if (cliente instanceof ClientePrime) {
            ((ClientePrime) cliente).calcularECreditarCashback(this.valorTotal);
        }

        return totalComFreteDesconto;
    }

    public double getValorTotal() {
        return valorTotal;
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
}
