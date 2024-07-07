package code;

public class Produto {
    private String codigo;
    private String nome;
    private String descricao;
    private double valorVenda;
    private String unidade;
    private double preco;
    private int quantidade;

    public Produto(String codigo, String nome, String descricao, double valorVenda, String unidade, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valorVenda = valorVenda;
        this.unidade = unidade;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public String getUnidade() {
        return unidade;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
