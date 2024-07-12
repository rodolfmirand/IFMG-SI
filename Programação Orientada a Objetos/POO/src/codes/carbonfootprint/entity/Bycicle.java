/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.carbonfootprint.entity;

import codes.carbonfootprint.interfaces.CarbonFootprint;

/**
 *
 * @author rodol
 */
public class Bycicle implements CarbonFootprint {

    private String brand; //marca
    private int rim; //tamanho aro

    public Bycicle(String brand, int rim) {
        this.brand = brand;
        this.rim = rim;
    }
    
    @Override
    public int getCarbonFootprint(){
        return rim * 5;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getRim() {
        return rim;
    }

    public void setRim(int rim) {
        this.rim = rim;
    }

}
