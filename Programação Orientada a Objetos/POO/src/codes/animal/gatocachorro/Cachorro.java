/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.animal.gatocachorro;

/**
 *
 * @author rodol
 */
public class Cachorro implements Animal {
    
    public void morder() {
        System.out.println("Mordeu"); 
    }

    @Override
    public void falar() {
        System.out.println("Au!");
    }
}
