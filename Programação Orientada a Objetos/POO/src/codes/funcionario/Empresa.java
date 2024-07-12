/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario;

import codes.funcionario.classes.funcionarios.assistentes.Administrativo;
import codes.funcionario.classes.Funcionario;
import codes.funcionario.classes.funcionarios.Gerente;
import codes.funcionario.classes.funcionarios.assistentes.Tecnico;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class Empresa {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int indiceFunc = 0;
        boolean out = false;
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();

        do {
            System.out.print("========================"
                    + "\n 1 - Cadastrar Gerente "
                    + "\n 2 - Adicionar Funcionário "
                    + "\n 3 - Modificar Salário "
                    + "\nR: ");

            switch (in.nextInt()) {
                case 1:
                    System.out.print("=== Cadastro Gerente ==="
                            + "\nNome: ");
                    String nome = in.next();
                    System.out.print("CPF: ");
                    String cpf = in.next();
                    System.out.print("Senha: ");
                    int senha = in.nextInt();
                    System.out.print("Salario: ");
                    double salario = in.nextDouble();

                    gerentes.add(new Gerente(nome, formatarCPF(cpf), salario, senha));
                    System.out.println(gerentes.get(0).calcularBonificacao());
                    break;
                case 2:
                    if (gerentes.isEmpty()) {
                        System.out.println("Nenhum gerente criado.");
                        break;
                    }
                    System.out.print("=== Adicionar Funcionario ==="
                            + "\nSenha gerente: ");
                    if (gerentes.get(0).validaSenha(in.nextInt())) {
                        System.out.print("Qual tipo de funcionário?"
                                + "\n 1 - Tecnico"
                                + "\n 2 - Administrativo"
                                + "\nR: ");

                        switch (in.nextInt()) {
                            case 1:
                                System.out.print("=== Tecnico ==="
                                        + "\nNome: ");
                                String nomeTec = in.next();
                                System.out.print("Cpf: ");
                                String cpfTec = in.next();
                                System.out.print("Salário: R$ ");
                                double salarioTec = in.nextDouble();
                                funcionarios.add(new Tecnico(nomeTec, formatarCPF(cpfTec), salarioTec, 1919));

                                break;
                            default:
                                throw new AssertionError();
                        }
                    } else {
                        System.out.println("Senha incorreta!");
                    }

                    break;
                case 3:
                    
                    break;
                case 5:
                    System.out.println("Nome: " + funcionarios.get(0).getNome()
                    + "\nCPF: " + funcionarios.get(0).getCpf()
                    + "\nSalário: R$" + funcionarios.get(0).getSalario()
                    + "\nBonificação: R$ " + funcionarios.get(0).calcularBonificacao());
                    break;
                default:
                    out = true;
            }
        } while (!out);

    }

    static void cadastrarFuncionario(ArrayList<Funcionario> funcionarios, int indiceFunc) {
        //funcionarios.add(new Funcionario());

        System.out.print("[--- Cadastro de Funcionário ---} "
                + "\nNome: ");
        funcionarios.get(indiceFunc).setNome(in.next());
        System.out.print("Salário inicial: R$");
        funcionarios.get(indiceFunc).setSalario(in.nextDouble());
        System.out.println("Cadastro realizado com sucesso!\n");
    }

    static void imprimirFuncionarios(ArrayList<Funcionario> funcionarios) {
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.print((i + 1) + ". ");
            funcionarios.get(i).exibirInformacoes();
        }
    }

    public static String formatarCPF(String cpf) {
        if (cpf.length() != 11) {
            throw new IllegalArgumentException("O CPF deve conter exatamente 11 dígitos.");
        }

        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

}
