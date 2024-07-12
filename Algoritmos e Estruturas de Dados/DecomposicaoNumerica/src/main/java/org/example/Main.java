package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        decomporNumero(new ArrayList<>(), in.nextInt(), 1);
    }

    private static void decomporNumero(ArrayList<Integer> decomposicaoAtual, int num, int aux) {

        if(decomposicaoAtual.isEmpty()){
            decomposicaoAtual.add(num);
        }else if(decomposicaoAtual.get(0) == 2 && decomposicaoAtual.get(1) == 2){
            decomposicaoAtual.set(1,1);
            decomposicaoAtual.add(1);
        }else{
            if(decomposicaoAtual.get(0) == 2 && decomposicaoAtual.get(1) == 1){
                decomposicaoAtual.set(0,1);
                decomposicaoAtual.add(1);
            }else if(decomposicaoAtual.size() == 1){
                decomposicaoAtual.set(0, num);
                decomposicaoAtual.add(1);
            }else if(decomposicaoAtual.get(1).equals(2)){
                num++;
                decomposicaoAtual.set(1,1);
                decomposicaoAtual.add(1);
            }else{
                decomposicaoAtual.set(0, num);
                if(aux == 1){
                    aux++;
                }
                decomposicaoAtual.set(1,aux);
            }
        }

        System.out.println(decomposicaoAtual.toString());
        num--;
        if(num != -1) decomporNumero(decomposicaoAtual, num, aux);
    }
}