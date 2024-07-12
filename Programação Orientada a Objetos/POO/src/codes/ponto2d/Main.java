/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.ponto2d;

/**
 *
 * @author rodol
 */
public class Main {
    public static void main(String[] args) {
        Ponto2D p1 = new Ponto2D();
        Ponto2D p2 = new Ponto2D(3,5);
        Ponto2D p3 = new Ponto2D(p2);
        
 
        
        if(p2.equals(p3)){
            System.out.println("Iguais");
        }else{
            System.out.println("Diferentes");
        }
        
        System.out.println(p1.getX() + " " + p1.getY());
        System.out.println(p2.getX() + " " + p2.getY());
        System.out.println(p3.getX() + " " + p3.getY());
        
        System.out.println(p2.toString());
    }
}
