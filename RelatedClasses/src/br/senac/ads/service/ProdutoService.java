package br.senac.ads.service;

import br.senac.ads.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    List<Produto> produtos= new ArrayList<>();
   public void cadastrarProduto(Produto produto){
       if (produto.getNome().isEmpty()||produto.getNome()==null && produto.getPreco()<=0){
           System.out.println("requisitos não atendidos");
       }
       else {produtos.add(produto);
       }

    }
    public List<Produto> listarProdutos(){
       return produtos;
    }
    public void atualizarPreco(int id, double novoPreco){
       for (Produto produto : produtos) {
           if (produto.getId()==id && novoPreco >0) {
               produto.setPreco(novoPreco);
           }
           else {
               System.out.println("produto nao pode ser cadastrado, nao atende os requisitos");
           }
       }

    }
    public void removerProduto(int id){
       for (Produto produto : produtos) {
           if (produto.getId()==id) {
               produtos.remove(produto);
               System.out.println("Produto removido com sucesso");
           }
           else {
               System.out.println("id invalido");
           }
       }
    }

}

