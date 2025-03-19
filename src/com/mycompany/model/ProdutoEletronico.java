package com.mycompany.model;
public class ProdutoEletronico extends Produto {
    private String marca;
    private String modelo;
    private int mesesGarantia;

    public ProdutoEletronico(String nome, int codigo, int quantidade, Departamento departamento, double precoCompra, double precoVenda, String marca, String modelo, int mesesGarantia) {
        super(nome, codigo, quantidade, departamento, precoCompra, precoVenda);
        this.marca = marca;
        this.modelo = modelo;
        this.mesesGarantia = mesesGarantia;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Preço de Compra: " + getPrecoCompra());
        System.out.println("Preço de Venda: " + getPrecoVenda());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Garantia: " + getMesesGarantia());
        System.out.println("-------------------------");
    }
}
