/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasLineares;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class Main {

    static Scanner in = new Scanner(System.in);
    static ListaAlunos lista;
    static ArrayList<Aluno> alunos = new ArrayList();

    public static void main(String[] args) {
        boolean sair = false;

        do {
            System.out.print("---------------------------------------\n"
                    + "1. Criar lista \n2. Criar aluno \n3. Adicionar aluno por indice"
                    + "\n4. Remover aluno por indice \n5. Verificar lista vazia \n6. Verificador lista cheia \n7. Imprimir indices vazios \n8. Limpar lista"
                    + "\n9. Imprimir lista \n10. Buscar indice por RA \n11. Sair"
                    + "\n--------------------------------------- \nR: ");
            int op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    lista = new ListaAlunos();
                    System.out.println("Lista criada");
                    break;
                case 2:
                    System.out.print("Nome aluno: ");
                    String nome = in.nextLine();
                    System.out.print("RA: ");
                    long ra = in.nextLong();
                    alunos.add(new Aluno(nome, ra));
                    System.out.println("Aluno criado");
                    break;
                case 3:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        imprimirAlunos();
                        System.out.print("Opção aluno: ");
                        int indiceArrayAluno = in.nextInt();
                        System.out.print("Posição lista: ");
                        int indiceLista = in.nextInt();
                        lista.insereAlunoNaPosicao(alunos.get(indiceArrayAluno - 1), indiceLista);
                        break;
                    }
                case 4:
                    if(lista == null){
                        System.out.println("Nenhuma lista criada");
                        break;
                    }else{
                        System.out.print("Aluno a ser excluido: ");
                        int indice = in.nextInt();
                        lista.removerAluno(indice);
                        System.out.println("Aluno removido");
                        break;
                    }
                case 5:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        checarVazia();
                        break;
                    }
                case 6:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        checarCheia();
                        break;
                    }
                case 7:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        lista.imprimirIndicesVazios();
                        break;
                    }
                case 8:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        lista.apagarLista();
                        System.out.println("Lista limpada.");
                        break;
                    }
                case 9:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        lista.imprimirLista();
                        
                        break;
                    }
                case 10:
                    if (lista == null) {
                        System.out.println("Nenhuma lista criada");
                        break;
                    } else {
                        System.out.print("RA que deseja buscar: ");
                        ra = in.nextLong();
                        lista.buscarIndicePorRA(ra, 0);
                        break;
                    }
                default:
                    sair = true;
            }

        } while (!sair);

    }

    public static void checarVazia() {
        if (lista.vazia()) {
            System.out.println("Vazia");
        } else {
            System.out.println("Não vazia");
        }
    }

    public static void checarCheia() {
        if (lista.cheia()) {
            System.out.println("Cheia");
        } else {
            System.out.println("Não cheia");
        }
    }

    public static void imprimirAlunos() {
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i + 1) + ". Nome: " + alunos.get(i).getNome() + "\n   RA: " + alunos.get(i).getRa());
        }
    }
}
