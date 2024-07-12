/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.pessoa;

import java.util.ArrayList;

/**
 *
 * @author rodol
 */
public abstract class Pessoa {

    private String nome;
    private String endereco;
    private double valorPagamento;
    private ArrayList<Long> contatos = new ArrayList<>(3);

    public Pessoa(String nome, String endereco, double valorPagamento) {
        this.nome = nome;
        this.endereco = endereco;
        this.valorPagamento = valorPagamento;
    }

    public abstract double realizarPagamento();

    public void adicionarContato(long contato) {
        if (contatos.get(3) == null) {
            this.contatos.add(contato);
        } else {
            System.out.println("Lista de contatos cheia.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public ArrayList<Long> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Long> contatos) {
        this.contatos = contatos;
    }
}
