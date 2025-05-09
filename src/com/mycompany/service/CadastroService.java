package com.mycompany.service;

import com.mycompany.model.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroService {

    public ProdutoPerecivel cadastrarProdutoPerecivel(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.next();
        scanner.nextLine();
        System.out.println("Digite o código:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o preço de compra:");
        double precoCompra = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite o preço de venda:");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite o departamento: ");
        for (Departamento d : Departamento.values()) {
            System.out.println(d.ordinal() + " - " + d);
        }
        int escolha = scanner.nextInt();
        Departamento departamento = Departamento.values()[escolha];
        scanner.nextLine();
        System.out.println("Digite o fornecedor:");
        String fornecedor = scanner.next();
        scanner.nextLine();
        
        System.out.println("Deseja informar uma data de validade? (S/N)");
        String resposta = scanner.nextLine().trim().toUpperCase();
        LocalDate dataValidade = null;
        
        if(resposta.equals("S")) {
        	System.out.println("Digite a data de validade (dd/MM/yyyy):");
        	String dataTexto = scanner.nextLine();
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	dataValidade = LocalDate.parse(dataTexto, formatter);
        }
        
        return new ProdutoPerecivel(nome, codigo, quantidade, departamento, precoCompra, precoVenda, fornecedor,
                dataValidade);
    }

    public ProdutoEletronico cadastrarProdutoEletronico(Scanner scanner) {
        System.out.println("Digite o nome:");
        String nome = scanner.next();
        scanner.nextLine();
        System.out.println("Digite o código:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o preço de compra:");
        double precoCompra = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite o preço de venda:");
        double precoVenda = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Digite o departamento: ");
        for (Departamento d : Departamento.values()) {
            System.out.println(d.ordinal() + " - " + d);
        }
        int escolha = scanner.nextInt();
        Departamento departamento = Departamento.values()[escolha];
        scanner.nextLine();
        System.out.println("Digite a marca");
        String marca = scanner.nextLine();
        System.out.println("Digite o modelo");
        String modelo = scanner.nextLine();
        System.out.println("Digite a garantia em meses:");
        int mesesGarantia = scanner.nextInt();
        return new ProdutoEletronico(nome, codigo, quantidade, departamento, precoCompra, precoVenda, marca, modelo, mesesGarantia);
    }
}
