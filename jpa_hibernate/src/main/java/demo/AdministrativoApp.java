package demo;

import entities.Pessoa;
import entities.Produto;
import models.ProdutoModel;

import java.util.List;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        System.out.println(produtoModel.findById(p1).getNome());

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        // TODO - Testar os demais metódos das classes: ProdutoModel e PessoaModel

    }
}