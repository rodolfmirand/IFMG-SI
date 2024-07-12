/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.exerciciosjava_classeobjeto;

/**
 *
 * @author rodol
 */
public class Pessoa {
    int idade, mes, dia, anoNasc;
    String nome;
    
    void ajustaDataNasc(String n, int d, int m, int a){
        this.nome = n;
        this.dia = d;
        this.mes = m;
        this.anoNasc = a;
    }
    
    void calculaIdade(int diaAtual, int mesAtual, int anoAtual){
        if(this.mes >= mesAtual && this.dia >= diaAtual){
            this.idade = anoAtual - this.anoNasc;
        }else{
            this.idade = anoAtual - this.anoNasc - 1;
        }
    }
    
    int informaIdade(){
        return this.idade;
    }
}
