package code;

public class Produto {
    private String descricao;
    private int codigo;
    private float valor;
    private String unidade;

    public Produto() {
        
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getcodigo() {
        return codigo;
    }

    public void setcodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getvalor() {
        return valor;
    }

    public void setvalor(float valor) {
        this.valor = valor;
    }

    public float getunidade() {
        return valor;
    }

    public void setunidade(float valor) {
        this.valor = valor;
    }

    public void cadastarProduto(int codigo, String descricao, float valor, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }
}