package br.senac.ads;

import br.senac.ads.model.*;
import br.senac.ads.service.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        PedidoService pedidoService = new PedidoService();
        ItemPedidoService itemService = new ItemPedidoService();


        List<Cliente> listaClientes = new ArrayList<>();
        List<Produto> listaProdutos = new ArrayList<>();

        int opcao = -1;

        while (opcao != 0) {
            try {
                // SEUS PRINTS ORIGINAIS (MANTIDOS EXATAMENTE IGUAIS)
                System.out.println("\n===== SISTEMA DE PEDIDOS - CAFETERIA =====");
                System.out.println("1 - Gerenciar Clientes");
                System.out.println("2 - Gerenciar Produtos");
                System.out.println("3 - Gerenciar Pedidos");
                System.out.println("4 - Gerenciar Itens do Pedido");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:

                        System.out.print("Digite o ID do Cliente: ");
                        int idC = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome do Cliente: ");
                        String nomeC = scanner.nextLine();
                        System.out.println("Digite um número de telefone: ");
                        String telefoneC = scanner.nextLine();
                        listaClientes.add(new Cliente(idC, nomeC, telefoneC));
                        System.out.println("Cliente cadastrado!");
                        break;

                    case 2:
                        System.out.print("ID do Produto: ");
                        int idP = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome do Produto: ");
                        String nomeP = scanner.nextLine();
                        System.out.print("Preço: ");
                        double preco = scanner.nextDouble();
                        listaProdutos.add(new Produto(idP, nomeP, preco));
                        System.out.println("Produto cadastrado!");
                        break;

                    case 3:
                        System.out.print("ID do novo Pedido: ");
                        int idPed = scanner.nextInt();
                        System.out.print("ID do Cliente para este pedido: ");
                        int idCli = scanner.nextInt();

                        // Busca o objeto Cliente na lista
                        Cliente cliEncontrado = null;
                        for(Cliente c : listaClientes) {
                            if(c.getID() == idCli) cliEncontrado = c;
                        }

                        pedidoService.criarPedido(idPed, idCli, cliEncontrado);
                        break;

                    case 4:
                        System.out.println("1 - Adicionar Item | 2 - Ver Total");
                        int subOpcao = scanner.nextInt();

                        if(subOpcao == 1) {
                            System.out.print("ID do Pedido: ");
                            int pId = scanner.nextInt();
                            System.out.print("ID do Produto: ");
                            int prodId = scanner.nextInt();
                            System.out.print("Quantidade: ");
                            int qtd = scanner.nextInt();
                            itemService.adicionarItemPedido(pId, prodId, qtd, listaProdutos);
                        } else {
                            System.out.print("ID do Pedido: ");
                            int pId = scanner.nextInt();
                            double total = itemService.calcularTotalPedido(pId);
                            System.out.println("Total do Pedido: R$ " + total);
                        }
                        break;

                    case 0:
                        System.out.println("\nEncerrando o sistema...");
                        break;

                    default:
                        System.out.println("\nOpção inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nErro: Digite apenas números!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\nErro inesperado!");

            }
        }
        scanner.close();
    }
}