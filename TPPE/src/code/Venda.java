package code;
import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;

    public Venda(Date data, Cliente cliente, List<Produto> produtos) {
        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = calcularValorTotal();
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
        return valorTotal;
    }
}
