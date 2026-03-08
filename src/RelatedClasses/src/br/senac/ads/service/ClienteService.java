package RelatedClasses.src.br.senac.ads.service;

import RelatedClasses.src.br.senac.ads.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<>();

    public ClienteService() {
    }

    public List<Cliente> Clientes() {
        return clientes;
    }

    public void cadastrarCliente(Cliente cliente) {
        if (cliente.getNome().equals("")) {
            System.out.println("nome em branco não é aceito");
        } else {
            clientes.add(cliente);
        }
    }

    public Cliente buscarClienteID(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getID() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente removeClienteID(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getID() == id) {
                clientes.remove(cliente);
                return cliente;
            }
        }
        return null;
    }
}
