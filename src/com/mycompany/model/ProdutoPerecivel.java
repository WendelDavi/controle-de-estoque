package com.mycompany.model;

public class ProdutoPerecivel extends Produto {
    private Departamento departamento;
    private String dataValidade;

    public ProdutoPerecivel(String nome, int codigo, int quantidade, double preco, Departamento departamento, String dataValidade) {
        super(nome, codigo, quantidade, preco);
        this.departamento = departamento;
        this.dataValidade = dataValidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome:" + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Preço: R$ " + getPreco());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Data de validade: " + dataValidade);
        System.out.println("-------------------------");
    }
}
