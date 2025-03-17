import java.util.ArrayList;

public class ControleEstoque {

    private ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProdutoPerecivel(String nome, int codigo, int quantidade, double preco, Departamento departamento, String dataValidade) {
        produtos.add(new ProdutoPerecivel(nome, codigo, quantidade, preco, departamento, dataValidade));
    }

    public void adicionarProdutoEletronico(String nome, int codigo, int quantidade, double preco, String marca, int garantia) {
        produtos.add(new ProdutoEletronico(nome, codigo, quantidade, preco, marca, garantia));
    }

    public void atualizarEstoque(int codigo, Produto novoProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo() == codigo) {
                produtos.set(i, novoProduto);
            }
        }
    }

    public void listarProdutos() {
        for (Produto p : produtos) {
            System.out.println("Nome: " + p.getNome());
            System.out.println("Código: " + p.getCodigo());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Preço: " + p.getPreco());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
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
