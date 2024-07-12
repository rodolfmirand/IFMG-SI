/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListasLineares;

/**
 *
 * @author rodol
 */
public class ListaAlunos {
    private final int max = 4;
    private int nAtualAlunos;
    private Aluno[] lista;

    public ListaAlunos() {
        this.lista = new Aluno[max];
    }

    public void apagarLista() {
        this.lista = new Aluno[max];
    }

    public boolean vazia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean cheia() {
        int contador = 0;
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                contador++;
            }
        }
        if (contador == this.lista.length) {
            return true;
        } else {
            return false;
        }
    }

    public void insereAlunoNaPosicao(Aluno aluno, int posicao) {
        if (posicao < this.lista.length && posicao >= 0) {
            if (!verificarAlunoNaLista(aluno, 0)) {
                if (!cheia()) {
                    if (this.lista[posicao] == null) {
                        this.lista[posicao] = aluno;
                        nAtualAlunos++;
                        System.out.println("Aluno adicionado à lista");
                    } else {
                        System.out.println("Está posição já está sendo usada");
                        imprimirIndicesVazios();
                    }
                } else {
                    System.out.println("Lista cheia");
                }
            } else {
                System.out.println("Aluno já está na lista");
            }
        } else {
            System.out.println("Posição maior que o tamanho do array ou menor que zero");
        }
    }
    
    public void removerAluno(int indice){
        Aluno[] novaLista = new Aluno[max];
        for (int i = 0; i < this.lista.length; i++) {
            if(i != indice){
                novaLista[i] = this.lista[i];
            }
        }
        this.lista = novaLista;
    }

    public boolean verificarAlunoNaLista(Aluno aluno, int indice) {
        if (indice == lista.length) {
            return false;
        }
        if (lista[indice] != null && lista[indice].getRa() == aluno.getRa()) {
            return true;
        } else {
            return verificarAlunoNaLista(aluno, indice + 1);
        }
    }

    public void imprimirIndicesVazios() {
        if (cheia()) {
            System.out.println("Lista cheia");
            return;
        } else {
            System.out.println("Indices vazios: ");
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] == null) {
                    System.out.print(i + " ");
                }
            }
            System.out.println("\n");
        }
    }

    public void imprimirLista() {
        System.out.println("Alunos inseridos na lista (por indice): ");
        for (int i = 0; i < this.lista.length; i++) {
            if (lista[i] != null) {
                System.out.println(i + ". Nome aluno: " + lista[i].getNome() + "\n   RA: " + lista[i].getRa());
            }
        }
    }

    public void buscarIndicePorRA(long ra, int indice) {
        if(indice == this.lista.length){
            System.out.println("Aluno não encontrado");
            return;
        }
        if (this.lista[indice] != null && this.lista[indice].getRa() == ra) {
            System.out.println("Indice do aluno na lista: " + indice);
        }else{
            buscarIndicePorRA(ra, indice+1);
        }
    }
}
