package code;

import java.util.List;
import java.util.Calendar;



public class VendasService {

    public double calcularTotalVendasUltimoMes(Cliente cliente, List<Venda> vendas) {
        Calendar umMesAtras = Calendar.getInstance();
        umMesAtras.add(Calendar.MONTH, -1);
        double total = 0.0;
        for (Venda venda : vendas) {
            if (venda.getCliente().equals(cliente) && venda.getData().after(umMesAtras.getTime())) {
                total += venda.getValorTotal();
            }
        }
        return total;
    }

    public void atualizarStatusCliente(Cliente cliente, List<Venda> vendas) {
        double total = calcularTotalVendasUltimoMes(cliente, vendas);
        if (total > 100.0) {
            cliente.setTipo("Especial");
        }
    }
}

