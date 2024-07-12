/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.lojacd_dvd;

/**
 *
 * @author rodol
 */
public abstract class Midia {

    private int codigo;
    private double preco;
    private String nome;

    public Midia() {
        this.codigo = 0;
        this.preco = 0;
        this.nome = "";
    }

    public Midia(int codigo, double preco, String nome) {
        this.codigo = codigo;
        this.preco = preco;
        this.nome = nome;
    }

    public String getTipo() {
        return this.nome;
    }

    public void printDados(){
        System.out.println("Nome: " + this.nome);
    }

    public abstract String getDetalhes();

}
