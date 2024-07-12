/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.carbonfootprint;

import codes.carbonfootprint.entity.Building;
import codes.carbonfootprint.entity.Bycicle;
import codes.carbonfootprint.entity.Car;
import codes.carbonfootprint.interfaces.CarbonFootprint;

/**
 *
 * @author rodol
 */
public class Main {
    public static void main(String[] args) {
        CarbonFootprint car = new Car("etanol", 1000);
        CarbonFootprint bycicle = new Bycicle("Caloi", 29);
        CarbonFootprint building = new Building(15, true, 35, true);
        
    }
}
