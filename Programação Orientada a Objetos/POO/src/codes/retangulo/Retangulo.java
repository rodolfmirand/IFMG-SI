/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.retangulo;

/**
 *
 * @author rodol
 */
public class Retangulo {
    int largura, altura;
    
    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPerimetro() {
        return (2*this.altura) + (2*this.largura);
    }

    public int getArea() {
        return this.altura * this.largura;
    }
}
