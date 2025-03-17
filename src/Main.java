import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ControleEstoque controle = new ControleEstoque();
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            OUTER:
            while (true) {
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
                        controle.adicionarProduto(nome, codigo, quantidade, preco);
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
                        Produto novoProduto = new Produto(nome, codigo, quantidade, preco);
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