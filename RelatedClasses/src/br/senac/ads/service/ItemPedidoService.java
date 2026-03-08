package br.senac.ads.service;

import br.senac.ads.model.ItemPedido;
import br.senac.ads.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoService {

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItemPedido(int idPedido, int idProduto, int quantidade, List<Produto> produtos) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        Produto produtoEncontrado = null;
        for (Produto p : produtos) {
            if (p.getId() == idProduto) {
                produtoEncontrado = p; // Salvamos o objeto encontrado
                break;
            }
        }

        if (produtoEncontrado == null) {
            System.out.println("Produto não encontrado.");
            return;
        }



        ItemPedido item = new ItemPedido(idPedido, produtoEncontrado, quantidade);
        itens.add(item);
        System.out.println("Item adicionado ao pedido.");
    }

    public double calcularTotalPedido(int idPedido) {
        double total = 0;
        for (ItemPedido i : itens) {
            if (i.getIdPedido() == idPedido) {

                total += i.getProduto().getPreco() * i.getQuantidade();
            }
        }
        return total;
    }

    public void removerItemPedido(int idPedido, int idProduto) {
        ItemPedido itemRemover = null;

        for (ItemPedido i : itens) {

            if (i.getIdPedido() == idPedido && i.getProduto().getId() == idProduto) {
                itemRemover = i;
                break;
            }
        }

        if (itemRemover != null) {
            itens.remove(itemRemover);
            System.out.println("Item removido.");
        } else {
            System.out.println("Item não encontrado.");
        }
    }
}
