/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.exerciciosjava_classeobjeto;

/**
 *
 * @author rodol
 */
public class Fatura {
    double faturaTotal;
    String numero, descricao;
    int qntdItem;
    double preco;
    
    public double getFaturaTotal(){
        if(preco < 0){
            preco = 0;
        }
        
        faturaTotal = qntdItem * preco;
        if(faturaTotal < 0){
            return 0.0;
        }else{
            return faturaTotal;
        }
    }
}
