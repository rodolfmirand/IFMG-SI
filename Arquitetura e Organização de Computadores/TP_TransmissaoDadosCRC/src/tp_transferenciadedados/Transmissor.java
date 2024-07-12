/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_transferenciadedados;

import java.util.Random;

/**
 *
 * @author rodol
 */
public class Transmissor {

    private String mensagem;

    public Transmissor(String mensagem) {
        this.mensagem = mensagem;
    }

    //convertendo um símbolo para "vetor" de boolean (bits)
    private boolean[] streamCaracter(char simbolo) {

        //cada símbolo da tabela ASCII é representado com 8 bits
        boolean bits[] = new boolean[8];

        //convertendo um char para int (encontramos o valor do mesmo na tabela ASCII)
        int valorSimbolo = (int) simbolo;
        int indice = 7;

        //convertendo cada "bits" do valor da tabela ASCII
        while (valorSimbolo >= 2) {
            int resto = valorSimbolo % 2;
            valorSimbolo /= 2;
            bits[indice] = (resto == 1);
            indice--;
        }
        bits[indice] = (valorSimbolo == 1);

        return bits;
    }

    //não modifique (seu objetivo é corrigir esse erro gerado no receptor)
    private void geradorRuido(boolean bits[]) {
        Random geradorAleatorio = new Random();

        //pode gerar um erro ou não..
        if (geradorAleatorio.nextInt(5) > 1) {
            int indice = geradorAleatorio.nextInt(8);
            bits[indice] = !bits[indice];
        }
    }

    private boolean[] dadoBitsCRC(boolean bits[]) {
        //insere os zeros ao dado original
        //faz o calculo do código CRC
        //mescla o dado orignal ao código CRC
        return mesclarBits(bits, xorDadoModificado(inserirZeros(bits)));
    }

    //insere os zeros nos bits originais 
    private boolean[] inserirZeros(boolean bits[]) {
        boolean bitsZeros[] = new boolean[12];
        for (int i = 0; i < bitsZeros.length; i++) {
            if (i >= bits.length) {
                bitsZeros[i] = false;
            } else {
                bitsZeros[i] = bits[i];
            }
        }
        return bitsZeros;
    }

    //faz os XORs dos bits originais utilizando o polinomio 1011
    private boolean[] xorDadoModificado(boolean[] bits) {
        //polinomio 1011
        boolean polinomio[] = {true, false, true, true}; 
        //vetor para guardar os restos do XOR
        boolean bitsXOR[] = new boolean[4];

        //guarda os quatro primeiros bits do dado no vetor bitsXOR para o calculo 
        for (int i = 0; i < bitsXOR.length; i++) {
            bitsXOR[i] = bits[i];
        }

        //percorre o dado modificado a partir da posição 4
        //bitIndircador = próximo bit que deve "descer"
        for (int bitIndicador = 4; bitIndicador <= bits.length; bitIndicador++) {
            //calculo XOR dos bits
            if (bitsXOR[0]) {
                for (int i = 0; i < 4; i++) {
                    if (bitsXOR[i] == polinomio[i]) {
                        bitsXOR[i] = false;
                    } else {
                        bitsXOR[i] = true;
                    }
                }
            }
            //desloca os bits uma casa para esquerda "descendo" o próximo bit (bitIndicador)
            if (bitIndicador < 12) {
                deslocarBits(bits, bitIndicador, bitsXOR);
            }
        }
        
        return bitsXOR;
    }

    //remove o zero inicial do resultado XOR e desloca os bits uma casa para esquerda
    private boolean[] deslocarBits(boolean[] bits, int bitIndicador, boolean[] bitsResultado) {
        for (int i = 0; i < bitsResultado.length; i++) {
            if (i + 1 == 4) {
                bitsResultado[i] = bits[bitIndicador];
            } else {
                bitsResultado[i] = bitsResultado[i + 1];
            }
        }
        return bitsResultado;
    }
    
    //mescla os bits originais com o código CRC
    private boolean[] mesclarBits(boolean bits[], boolean bitsCRC[]) {
        boolean novosBits[] = new boolean[12];
        int contador = 0;
        for (int i = 0; i < novosBits.length; i++) {
            if (i < bits.length) {
                novosBits[i] = bits[i];
            } else {
                novosBits[i] = bitsCRC[contador];
                contador++;
            }
        }
        return novosBits;
    }

    public void enviaDado(Receptor receptor) {
        for (int i = 0; i < this.mensagem.length(); i++) {
            boolean bits[] = streamCaracter(this.mensagem.charAt(i));
            boolean bitsCRC[] = dadoBitsCRC(bits);

            geradorRuido(bitsCRC);
            
            //envia o dado codificado com ou sem ruido ao receptor, que o mesmo faz a verificação do dado
            //se o receptor encontrar erros, ele faz a requisição de retransmissão dos dados por meio da função "receptor.receberDadosBits()" retornar true ou false
            while (!receptor.receberDadoBits(bitsCRC)) {
                bitsCRC = dadoBitsCRC(bits);
                geradorRuido(bitsCRC);
            }
        }
    }
}
