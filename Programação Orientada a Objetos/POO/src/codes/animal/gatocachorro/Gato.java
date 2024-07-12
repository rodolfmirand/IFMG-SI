/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.animal.gatocachorro;

/**
 *
 * @author rodol
 */
public class Gato implements Animal{

    public void arranhar() {
        System.out.println("Arranhou!");
    }

    @Override
    public void falar() {
        System.out.println("Miau!");
    }
}
