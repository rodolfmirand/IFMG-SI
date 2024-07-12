/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.lojacd_dvd;

/**
 *
 * @author rodol
 */
public class CD extends Midia{
    private int numMusicas;

    public CD(int numMusicas, int codigo, double preco, String nome) {
        super(codigo, preco, nome);
        this.numMusicas = numMusicas;
    }
    
    @Override
    public void printDados() {
    }

    @Override
    public String getDetalhes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
