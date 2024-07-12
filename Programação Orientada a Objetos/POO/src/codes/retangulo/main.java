/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.retangulo;

/**
 *
 * @author rodol
 */
public class main {
    public static void main(String[] args) {
        Retangulo ret = new Retangulo();
        
        ret.setAltura(2);
        ret.setLargura(4);
        System.out.println(ret.getArea() + "\n" + ret.getPerimetro());
    }
}
