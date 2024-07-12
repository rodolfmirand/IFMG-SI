/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.animal.cavalocachorropreguica;

/**
 *
 * @author rodol
 */
public class Preguica extends Animal{
    
    public Preguica(String nome, int idade) {
        super(nome, idade);
    }
    
    public void subirArvore(){
        System.out.println(this.getNome() + " subiu na árvore!");
    }
    
}
