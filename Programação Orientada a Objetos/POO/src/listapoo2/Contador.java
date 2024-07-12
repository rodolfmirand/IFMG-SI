/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listapoo2;

/**
 *
 * @author rodol
 */
public class Contador {
    private int contador;
    
    public void zerar(){
        this.contador = 0;
    }
    
    public void incrementarUm(){
        this.setContador(this.contador + 1);
    }
    
    public void incrementarQuantidade(int quantidade){
        this.setContador(this.contador + quantidade);
    }
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
}
