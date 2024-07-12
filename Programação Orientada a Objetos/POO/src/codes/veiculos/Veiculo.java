/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.veiculos;

/**
 *
 * @author rodol
 */
public abstract class Veiculo {
    private String marca;
    private double preco;

    public Veiculo(String modelo, double preco) {
        this.marca = modelo;
        this.preco = preco;
    }
    
    public void printDados(){
        System.out.println("Modelo: " + this.marca + "\n"
                + "Preço: R$" + preco);
    }

    public String getModelo() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.marca = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
