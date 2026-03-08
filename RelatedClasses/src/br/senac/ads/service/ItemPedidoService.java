package br.senac.ads.service;

import br.senac.ads.model.ItemPedido;
import br.senac.ads.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ItemPedidoService {

    List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItemPedido(int idPedido, int idProduto, int quantidade, List<Produto> produtos) {

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        boolean produtoExiste = false;

        for (Produto p : produtos) {

            if (p.getId() == idProduto) {
                produtoExiste = true;
                break;
            }

        }

        if (!produtoExiste) {

            System.out.println("Produto não encontrado.");
            return;

        }

        ItemPedido item = new ItemPedido(idPedido, idProduto, quantidade);

        itens.add(item);

        System.out.println("Item adicionado ao pedido.");
    }

    public void listarItensPedido(int idPedido) {

        boolean encontrou = false;

        for (ItemPedido i : itens) {

            if (i.getIdPedido() == idPedido) {

                System.out.println("Produto: " + i.getIdProduto());
                System.out.println("Quantidade: " + i.getQuantidade());
                System.out.println("--------------------");

                encontrou = true;
            }

        }

        if (!encontrou) {
            System.out.println("Nenhum item encontrado para esse pedido.");
        }

    }


}