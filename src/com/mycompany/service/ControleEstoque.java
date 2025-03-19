package com.mycompany.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mycompany.model.*;

public class ControleEstoque {

    private List<Produto> produtos;

    public ControleEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void cadastrarProdutoPerecivel(String nome, int codigo, int quantidade, Departamento departamento,
            double precoCompra, double precoVenda, String fornecedor,
            LocalDate dataValidade) {
        ProdutoPerecivel produto = new ProdutoPerecivel(nome, codigo, quantidade, departamento,
                precoCompra, precoVenda, fornecedor, dataValidade);
        adicionarProduto(produto);
    }

    public void cadastrarProdutoEletronico(String nome, int codigo, int quantidade, Departamento departamento,
            double precoCompra, double precoVenda, String marca, String modelo, int mesesGarantia) {
        ProdutoEletronico produto = new ProdutoEletronico(nome, codigo, quantidade, departamento,
                precoCompra, precoVenda, marca, modelo, mesesGarantia);
        adicionarProduto(produto);
    }

    public void atualizarProduto(int codigo, Produto novoProduto) {
        Optional<Produto> produtoOptional = buscarProdutoPorCodigo(codigo);
        if (produtoOptional.isPresent()) {
            int index = produtos.indexOf(produtoOptional.get());
            produtos.set(index, novoProduto);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos no estoque.");
        } else {
            for (Produto p : produtos) {
                p.exibirInformacoes();
            }
        }
    }

    public void removerProduto(int codigo) {
        Optional<Produto> produOptional = buscarProdutoPorCodigo(codigo);
        if (produOptional.isPresent()) {
            produtos.remove(produOptional.get());
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public Optional<Produto> buscarProdutoPorCodigo(int codigo) {
        return produtos.stream()
                .filter(p -> p.getCodigo() == codigo)
                .findFirst();
    }
}