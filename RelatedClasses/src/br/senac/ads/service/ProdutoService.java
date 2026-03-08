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
       else {produtos.add(produto);}



    }
}

