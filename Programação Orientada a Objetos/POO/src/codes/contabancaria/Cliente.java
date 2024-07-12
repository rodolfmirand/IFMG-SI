/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.contabancaria;

import java.util.Random;

/**
 *
 * @author rodol
 */
public class Cliente {
    private String nome, cpf, end;
    private Conta contaBancaria = new Conta(this.nome);
    public void setInfo(String nome, String cpf, String end){
        this.setNome(nome);
        this.setCpf(formatCPF(cpf));
        this.setEnd(end);
    }
    
    public void criarContaBancaria(String titular){
        contaBancaria.titular = getNome();
    }
    
    public Cliente(String nome, String cpf, String end) {
        this.nome = nome;
        this.cpf = cpf;
        this.end = end;
    }
    
    public Cliente(){
        this.nome = null;
        this.cpf = null;
        this.end = null;
    }
    
    public void getInformacoes(){
        System.out.println("---------------------------\n"
                + "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nEndereço: " + this.getEnd());
        System.out.println("Conta Bancária: \n\tNúmero: " + this.contaBancaria.getNumero() + "\n\tSaldo: R$"+ this.contaBancaria.getSaldo() 
                + "\n---------------------------");
    }
    public Conta getContaBancaria(){
        return contaBancaria;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return formatCPF(this.cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
       
    public String formatCPF(String cpf){
        String bloco1 = cpf.substring(0, 3);
	String bloco2 = cpf.substring(3, 6);
	String bloco3 = cpf.substring(6, 9);
	String bloco4 = cpf.substring(9, 11);
        cpf = String.format("%s.%s.%s-%s", bloco1, bloco2, bloco3, bloco4);
        return cpf;
    }
}
