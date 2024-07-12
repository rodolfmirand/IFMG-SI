/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario.classes;

/**
 *
 * @author rodol
 */
public abstract class Funcionario {

    protected String nome;
    protected String cpf;
    protected double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public abstract double calcularBonificacao();

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome + 
                "\tCPF: " + this.cpf + 
                "\tSalário: R$" + this.salario);
    }

    public void aumentarSalario() {
        this.setSalario(this.salario + this.salario * 0.1);
        System.out.println("Salário aumentado!");
        this.exibirInformacoes();
    }

    public void diminuirSalario() {
        this.setSalario(this.salario - (this.salario * 0.1));
        System.out.println("Salário reduzido!");
        this.exibirInformacoes();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return formatarCPF(this.cpf);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double ganhoAnual() {
        return this.salario * 12;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", salario=" + salario + '}';
    }
    
    private static String formatarCPF(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos.");
        }

        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }
    
    
}
