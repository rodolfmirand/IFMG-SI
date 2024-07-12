/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.ponto2d;

import java.util.Random;

/**
 *
 * @author rodol
 */
public class Ponto2D {
    private double x, y;
    static Random rnd = new Random();
    public Ponto2D() {
        this.x = 0;
        this.y = 0;
    }
    
    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Ponto2D(Ponto2D obj){
        this.x = obj.getX();
        this.y = obj.getY();
    }
    
    public void movimentarPonto(){
        this.x = rnd.nextDouble(10);
        this.y = rnd.nextDouble(10);
    }
    
    public void movimentarPonto(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public void movimentarPonto(Ponto2D obj){
        this.x = obj.getX();
        this.y = obj.getY();
    }
    
    public double calcularDistancia(Ponto2D obj){
        return Math.sqrt(Math.pow(this.getX() - obj.getX() , 2) + Math.pow(this.getY() - obj.getY(), 2));
    }
    
    public boolean equals (Object obj){
        Ponto2D p = (Ponto2D)obj; //cast
        return this.x == p.getX() && this.y == p.getY();
    }
    
    public String toString(){
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
    
    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
