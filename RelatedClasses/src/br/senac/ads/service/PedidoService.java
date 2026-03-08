package br.senac.ads.service;

import br.senac.ads.model.Cliente;
import br.senac.ads.model.Pedido;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class PedidoService {


    private List<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(int id, int idCliente, Cliente cliente) {

        boolean clienteExiste = (cliente != null && cliente.getID() == idCliente);

        if (!clienteExiste) {
            System.out.println("Cliente não encontrado ou ID divergente.");
            return;
        }

        String data = LocalDate.now().toString();

        Pedido novoPedido = new Pedido(id, cliente, data);


        pedidos.add(novoPedido);
        System.out.println("Pedido criado com sucesso para o cliente: " + idCliente);
    }

    public Pedido buscarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void cancelarPedido(int id) {
        Pedido pedido = buscarPedido(id);

        if (pedido != null) {
            pedidos.remove(pedido);
            System.out.println("Pedido " + id + " cancelado com sucesso.");
        } else {
            System.out.println("Pedido " + id + " não encontrado para cancelamento.");
        }
    }

    public List<Pedido> listarTodos() {
        return this.pedidos;
    }
}