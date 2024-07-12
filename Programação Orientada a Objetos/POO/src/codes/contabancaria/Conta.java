/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.contabancaria;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author 0057149
 */
public class Conta {

    Random rnd = new Random(); // rnd.nextInt((max - min) + 1) + min;
    public String titular;
    private int numero;
    private double saldo;
    private ArrayList<Cliente> clientes = Banco.clientes;
    private boolean verificador = false;
    
    public Conta(String titular) {
        this.titular = titular;
        this.numero = rnd.nextInt(999);
        for (int i = 0; i < clientes.size() ; i++) {
            if(this.numero == clientes.get(i).getContaBancaria().getNumero()){
                i = 0;
                this.numero = rnd.nextInt(999);
            }
        }
        this.saldo = 0;
    }
    
    public void getSacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Valor sacado: R$" + valor + "\nSaldo atual: R$" + this.saldo);
        } else {
            System.out.println("Saldo indiponível. \nSaldo atual: R$ " + this.saldo);
        }
    }

    public void transferir(Cliente destino, double valor) {

        if (valor <= this.saldo) {
            this.saldo -= valor;
            destino.getContaBancaria().setSaldo(valor);
        } else {
            System.out.println("Saldo insuficiente para fazer a transferência.");
        }
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double valor) {
        if (valor >= 0) {
            this.saldo += valor;
            System.out.println("Nome: " + this.titular + "\nValor depositado: R$" + valor + "\nSaldo atual: R$" + this.saldo);
        }else{
            System.out.println("Impossível inserir valor negativo.");
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }
}
