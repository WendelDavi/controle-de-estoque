package com.mycompany.estoque;

import com.mycompany.model.*;
import com.mycompany.service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ControleEstoque controle = new ControleEstoque();
        CadastroService cadastroService = new CadastroService();
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            OUTER: while (true) {
                System.out.println("1. Cadastrar produto");
                System.out.println("2. Atualizar produto");
                System.out.println("3. Listar produtos");
                System.out.println("4. Remover produto");
                System.out.println("5. Sair");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1 -> {
                        System.out.println("Qual o tipo de produto que deseja adicionar?");
                        System.out.println("1. Perecível");
                        System.out.println("2. Eletrônico");
                        int tipo = scanner.nextInt();
                        
                        switch (tipo) {
                            case 1 -> {
                                Produto produto = cadastroService.cadastrarProdutoPerecivel(scanner);
                                controle.adicionarProduto(produto);
                            }
                            case 2 -> {
                                Produto produto = cadastroService.cadastrarProdutoEletronico(scanner);
                                controle.adicionarProduto(produto);
                            }
                            default -> System.out.println("Tipo de produto inválido");
                        }
                    }
                    case 2 -> {
                        System.out.println("Digite o código do produto que deseja alterar:");
                        int codigoAlterar = scanner.nextInt();
                        scanner.nextLine();
                        Produto produtoExistente = controle.buscarProdutoPorCodigo(codigoAlterar).orElse(null);
                        if (produtoExistente == null) {
                            System.out.println("Produto não encontrado!");
                            break;
                        }
                        System.out.println("Produto encontrado");
                        produtoExistente.exibirInformacoes();

                        Produto novoProduto;
                        if (produtoExistente instanceof ProdutoPerecivel) {
                            novoProduto = cadastroService.cadastrarProdutoPerecivel(scanner);
                        } else if (produtoExistente instanceof ProdutoEletronico) {
                            novoProduto = cadastroService.cadastrarProdutoEletronico(scanner);
                        } else {
                            System.out.println("Tipo de produto desconhecido!");
                            break;
                        }
                        controle.atualizarProduto(codigoAlterar, novoProduto);
                    }
                    case 3 -> {
                        controle.listarProdutos();
                    }
                    case 4 -> {
                        System.out.println("Digite o código do produto que deseja remover:");
                        int codigo = scanner.nextInt();
                        controle.removerProduto(codigo);
                    }
                    case 5 -> {
                        break OUTER;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }
        }
    }
}