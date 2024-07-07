package code;

public class ClientePrime extends Cliente {
    private double saldoCashback;

    public ClientePrime(String nome, String cpf, String endereco, double saldoCashback) {
        super(nome, cpf, endereco);
        this.saldoCashback = saldoCashback;
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public void utilizarCashback(double valor) {
        if (valor <= saldoCashback) {
            saldoCashback -= valor;
        } else {
            saldoCashback = 0.0;
        }
    }
    
    public void creditarCashback(double valor) {
        saldoCashback += valor;
    }
}
