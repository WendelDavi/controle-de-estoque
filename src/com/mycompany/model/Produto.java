package com.mycompany.model;
public abstract class Produto {
    
    private String nome;
    private int codigo;
    private int quantidade;
    private Departamento departamento;
    private double precoCompra;
    private double precoVenda;

    public Produto(String nome, int codigo, int quantidade, Departamento departamento, double precoCompra, double precoVenda) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.departamento = departamento;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }


    public abstract void exibirInformacoes();
}    
