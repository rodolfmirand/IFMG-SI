/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp_transferenciadedados;

/**
 *
 * @author rodol
 */
public class Receptor {
    //mensagem recebida pelo transmissor

    private String mensagem;

    public Receptor() {
        //mensagem vazia no inicio da execução
        this.mensagem = "";
    }

    public String getMensagem() {
        return mensagem;
    }

    private boolean decodificarDado(boolean bits[]) {
        int codigoAscii = 0;
        int expoente = bits.length - 1;

        //converntendo os "bits" para valor inteiro para então encontrar o valor tabela ASCII
        for (int i = 0; i < bits.length; i++) {
            if (bits[i]) {
                codigoAscii += Math.pow(2, expoente);
            }
            expoente--;
        }

        //concatenando cada simbolo na mensagem original
        this.mensagem += (char) codigoAscii;

        //esse retorno precisa ser pensado... será que o dado sempre chega sem ruído???
        return true;
    }

    //decodificado o dado com bits CRC recebido
    private boolean decodificarDadoCRC(boolean[] bits) {
        //bitsResto recebe o resto do último XOR calculado
        boolean bitsResto[] = xorDadoRecebido(bits);

        //se todos os bits do resto forem falsos (0) o código recebido está correto e o verificador retorna como true
        //caso contrário, houve algum ruido e o verificador retorna como false
        for (int i = 0; i < bitsResto.length; i++) {
            if (bitsResto[i]) {
                return false;
            }
        }

        return true;
    }
    
    //calculos XORs do dado com CRC recebido
    private boolean[] xorDadoRecebido(boolean[] bits) {
        //polinomio 1011
        boolean polinomio[] = {true, false, true, true};
        //vetor para guardar os restos do XOR
        boolean bitsResultado[] = new boolean[4];

        //guarda os quatro primeiros bits do dado no vetor bitsXOR para o primeiro calculo
        for (int i = 0; i < bitsResultado.length; i++) {
            bitsResultado[i] = bits[i];
        }

        //percorre o dado modificado a parit da posição 3
        //bitIndircador = próximo bit que deve "descer"
        for (int bitIndicador = 4; bitIndicador <= bits.length; bitIndicador++) {
            //calculo XOR dos bits
            if (bitsResultado[0]) {
                for (int i = 0; i < 4; i++) {
                    if (bitsResultado[i] == polinomio[i]) {
                        bitsResultado[i] = false;
                    } else {
                        bitsResultado[i] = true;
                    }
                }
            }
            //desloca os bits uma casa para esquerda "descendo" o próximo bit (bitIndicador)
            if (bitIndicador < 12) {
                deslocarBits(bits, bitIndicador, bitsResultado);
            }
        }

        return bitsResultado;
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
    
    //remove os bits do código CRC dos bits do dado a ser decodificado
    private boolean[] dividirBitsCRC(boolean[] bits) {
        boolean[] novosBits = new boolean[8];

        for (int i = 0; i < novosBits.length; i++) {
            novosBits[i] = bits[i];
        }
        return novosBits;
    }

    //recebe os dados do transmissor
    public boolean receberDadoBits(boolean bits[]) {
        //se 'decodoficarDadoCRC' retornar false, significa que houve algum ruido durante a transmissão e o receptor pede a retransmissão do dado
        //se 'decodificarDadoCRC' retornar true, não houve ruido e o receptor decodificará o dado
        if (decodificarDadoCRC(bits)) {
            decodificarDado(dividirBitsCRC(bits));
        } else {
            return false;
        }
        
        return true;
    }
}
