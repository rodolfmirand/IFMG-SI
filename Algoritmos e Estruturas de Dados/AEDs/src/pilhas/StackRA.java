/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilhas;

/**
 *
 * @author rodol
 */
public class StackRA {

    private Item[] itens;
    private int quantidadeAtualElementos;

    public StackRA() {
        this.itens = (Item[]) new Object[2];
        this.quantidadeAtualElementos = 0;
    }
    
    public boolean isEmpty(){
        return this.quantidadeAtualElementos == 0;
    }
    
    public void push(Item item){
        if(this.quantidadeAtualElementos == this.itens.length)
            resize(2 * this.itens.length);
    }

    private void resize(int max) {
        Item[] tempItens;
        tempItens = (Item[]) new Object[max];
        for (int i = 0; i < this.quantidadeAtualElementos; i++) 
            tempItens[i] = this.itens[i];
        this.itens = tempItens;
    }
}
