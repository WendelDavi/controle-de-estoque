import java.util.ArrayList;

public class ControleEstoque {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void atualizarEstoque(int codigo, Produto novoProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                produtos.set(i, novoProduto);
            }
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
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                produtos.remove(i);
                System.out.println("Produto removido com sucesso!");
                break;
            }
        }
    }
}
