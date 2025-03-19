package com.mycompany.estoque;
import com.mycompany.model.Departamento;
import com.mycompany.model.Produto;
import com.mycompany.model.ProdutoEletronico;
import com.mycompany.model.ProdutoPerecivel;
import com.mycompany.service.ControleEstoque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ControleEstoque controle = new ControleEstoque();
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
                        System.out.println("Digite o nome:");
                        String nome = scanner.next();
                        scanner.nextLine();
                        System.out.println("Digite o código:");
                        int codigo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite a quantidade:");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o preço:");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Tipo de Produto:");
                        System.out.println("1. Produto Perecível");
                        System.out.println("2. Produto Eletronico");
                        System.out.println("3. Sair");
                        int tipoProduto = scanner.nextInt();
                        switch (tipoProduto) {
                            case 1 -> {
                                System.out.println("Digite o departamento: ");
                                for (Departamento d : Departamento.values()) {
                                    System.out.println(d.ordinal() + " - " + d);
                                }
                                int escolha = scanner.nextInt();
                                Departamento departamento = Departamento.values()[escolha];
                                scanner.nextLine();
                                System.out.println("Digite a data de validade (dd/MM/yyyy):");
                                String dataValidade = scanner.nextLine();
                                Produto produto = new ProdutoPerecivel(nome, codigo, quantidade, preco, departamento, dataValidade);
                                controle.adicionarProduto(produto);
                            }
                            case 2 -> {
                                System.out.println("Digite a marca");
                                String marca = scanner.nextLine();
                                scanner.nextLine();
                                System.out.println("Digite a garantia em meses:");
                                int garantia = scanner.nextInt();
                                Produto produto = new ProdutoEletronico(nome, codigo, quantidade, preco, marca, garantia);
                                controle.adicionarProduto(produto);
                            }
                            case 3 -> {
                                break OUTER;
                            }

                            default -> System.out.println("Opção Inválida");
                        }
                    }
                    case 2 -> {
                        System.out.println("Digite o código do produto que deseja alterar:");
                        int codigoAlterar = scanner.nextInt();
                        System.out.println("Digite o nome:");
                        String nome = scanner.next();
                        scanner.nextLine();
                        System.out.println("Digite o código:");
                        int codigo = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite a quantidade:");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o preço:");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Digite o departamento: ");
                        for (Departamento d : Departamento.values()) {
                            System.out.println(d.ordinal() + " - " + d);
                        }
                        int escolha = scanner.nextInt();
                        Departamento departamento = Departamento.values()[escolha];
                        scanner.nextLine();
                        System.out.println("Digite a data de validade");
                        String dataValidade = scanner.nextLine();
                        Produto novoProduto = new ProdutoPerecivel(nome, codigo, quantidade, preco, departamento, dataValidade);
                        controle.atualizarEstoque(codigoAlterar, novoProduto);
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