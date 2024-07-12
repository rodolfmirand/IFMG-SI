/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.contabancaria;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 0057149
 */
public class Banco {

    static Scanner in = new Scanner(System.in);
    static ArrayList<Cliente> clientes = new ArrayList();
    static int indiceCliente = 0;

    public static void main(String[] args) {
        boolean menuOn;
        int ind;

        System.out.println("---------------------------"
                + "\n1. Criar novo Cliente \n2. Informações da conta \n3. Depositar \n4. Sacar \n5. Transferir"
                + "\n---------------------------");
        do {
            System.out.println("O que deseja fazer?");
            int opcao = in.nextInt();
            switch (opcao) {
                case 1:
                    clientes.add(new Cliente());
                    cadastrarCliente();
                    break;
                case 2:
                    System.out.println("Informações de qual conta deseja saber?");
                    imprimirClientes();
                    clientes.get(in.nextInt() - 1).getInformacoes();
                    break;
                case 3:
                    if (clientes.size() == 0) {
                        System.out.println("Nenhuma conta existente.");
                        break;
                    } else {
                        System.out.println("Em qual conta deseja depositar?");
                        imprimirClientes();
                        ind = in.nextInt();
                        System.out.print("Qual valor a depositar? R$");
                        clientes.get(ind - 1).getContaBancaria().setSaldo(in.nextDouble());
                        break;
                    }
                case 4:
                    if (clientes.size() == 0) {
                        System.out.println("Nenhuma conta existente.");
                        break;
                    } else {
                        System.out.println("Em qual conta deseja sacar?");
                        imprimirClientes();
                        ind = in.nextInt();
                        System.out.print("Qual valor a sacar? R$");
                        clientes.get(ind - 1).getContaBancaria().getSacar(in.nextDouble());
                        break;
                    }
                case 5:
                    if (clientes.size() == 0) {
                        System.out.println("Nenhuma conta existente.");
                        break;
                    } else {
                        System.out.println("Conta origem: ");
                        int clienteOrigem = in.nextInt() - 1;
                        System.out.println("Conta destino: ");
                        int clienteDestino = in.nextInt() - 1;
                        System.out.print("Valor a transferir: R$");
                        clientes.get(clienteOrigem).getContaBancaria().transferir(clientes.get(clienteDestino), in.nextDouble());
                        break;
                    }
                default:
                    menuOn = false;
            }
        } while (menuOn = true);

    }

    static void cadastrarCliente() {
        System.out.println("---------------------------"
                + "\nNome da conta: ");
        clientes.get(indiceCliente).setNome(in.nextLine());
        System.out.println("CPF:");
        clientes.get(indiceCliente).setCpf(in.next());
        System.out.println("Endereço: ");
        clientes.get(indiceCliente).setEnd(in.nextLine());
        clientes.get(indiceCliente).criarContaBancaria(clientes.get(indiceCliente).getNome());
        System.out.println("Conta criada com sucesso!"
                + "\n---------------------------");
        indiceCliente++;
    }

    static void imprimirClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNome());
        }
    }
}
