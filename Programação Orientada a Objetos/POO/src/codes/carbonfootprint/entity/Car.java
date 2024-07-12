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
public class Car implements CarbonFootprint {

    private String fuelType;
    private int cc; //cilindrada

    public Car(String fuelType, int cc) {
        this.fuelType = fuelType;
        this.cc = cc;
    }

    @Override
    public int getCarbonFootprint() {
        return switch (fuelType) {
            case "etanol" ->
                cc * 2;
            case "gas" ->
                cc * 3;
            case "diesel" ->
                cc * 4;
            case "eletric" ->
                0;
            default ->
                0;
        };
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public float getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

}
