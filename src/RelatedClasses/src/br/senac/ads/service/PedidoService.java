package RelatedClasses.src.br.senac.ads.service;

import RelatedClasses.src.br.senac.ads.model.Cliente;
import RelatedClasses.src.br.senac.ads.model.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class PedidoService {

    List<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(int id, int idCliente, List<Cliente> clientes) {

        boolean clienteExiste = false;

        for (Cliente c : clientes) {
            if (c.getID() == idCliente) {
                clienteExiste = true;
                break;
            }
        }

        if (!clienteExiste) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        String data = LocalDate.now().toString();

        Pedido novoPedido = new Pedido(id, idCliente, data);

        pedidos.add(novoPedido);

        System.out.println("Pedido criado com sucesso.");
    }

    public void listarPedidos() {

        for (Pedido p : pedidos) {
            System.out.println("ID Pedido: " + p.getId());
            System.out.println("Cliente: " + p.getCliente());
            System.out.println("Data: " + p.getData());
            System.out.println("---");
        }

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
            System.out.println("Pedido cancelado.");
        } else {
            System.out.println("Pedido não encontrado.");
        }

    }
}