public class ProdutoEletronico extends Produto {
    private String marca;
    private int garantia;

    public ProdutoEletronico(String nome, int codigo, int quantidade, double preco, String marca, int garantia) {
        super(nome, codigo, quantidade, preco);
        this.marca = marca;
        this.garantia = garantia;
    }

    public String getMarca() {
        return marca;
    }
    public int getGarantia() {
        return garantia;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Marca: " + getMarca());
        System.out.println("Garantia: " + getGarantia());
        System.out.println("-------------------------");
    }
}
