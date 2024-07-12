/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.animal.cavalocachorropreguica;

/**
 *
 * @author rodol
 */
public class Main {
    public static void main(String[] args) {
        Animal cavalo = new Cavalo("Spirit", 5);
        Animal cachorro = new Cachorro("Logan", 4);
        Animal preguica = new Preguica("Louis", 23);
        
        cavalo.emitirSom();
        cachorro.emitirSom();
        preguica.emitirSom();
    }
}
