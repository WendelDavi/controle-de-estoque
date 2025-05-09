package com.mycompany.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProdutoPerecivel extends Produto {
    private String fornecedor;
    private LocalDate dataValidade;

    public ProdutoPerecivel(String nome, int codigo, int quantidade, Departamento departamento, double precoCompra, double precoVenda, String fornecedor, LocalDate dataValidade) {
        super(nome, codigo, quantidade, departamento, precoCompra, precoVenda);
        this.fornecedor = fornecedor;
        this.dataValidade = dataValidade;
    }

    
    public String getFornecedor() {
        return fornecedor;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Nome:" + getNome());
        System.out.println("Código: " + getCodigo());
        System.out.println("Quantidade: " + getQuantidade());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Preço de Compra: R$ " + getPrecoCompra());
        System.out.println("Preço de Venda: R$ " + getPrecoVenda());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Fornecedor: " + fornecedor);
        if (dataValidade != null) {
        System.out.println("Validade: " + dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
        	System.out.println("Validade: Não informada");
        }
        System.out.println("-------------------------");
    }
}
