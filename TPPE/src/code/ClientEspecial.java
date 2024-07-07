package code;


public class ClientEspecial extends Cliente {
	
	private String tipo;
	
	public ClientEspecial(String nome, String cpf, String endereco) {
		super(nome, cpf, endereco);
		this.tipo="Especial";
	}

	public double calcularDesconto(double valorCompra, String numeroCartao) {

		String inicioCartao = "429613";
			
		if (inicioCartao.equals(numeroCartao.substring(0, 6))) {
			double desconto = valorCompra * 0.1;
			return desconto;
		}
		else {
			return 0;
		}
	}
	public double calcularDescontoFrete(double valorFrete) {
		double desconto = valorFrete * 0.3;
		
		return desconto;
	}
}
