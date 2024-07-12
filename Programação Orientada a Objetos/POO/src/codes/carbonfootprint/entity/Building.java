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
public class Building implements CarbonFootprint {

    private int numPeople;
    private boolean renewblaEnergy;
    private int numLamps;
    private boolean useAirConditioner;

    public Building(int numPeople, boolean renewblaEnergy, int numLamps, boolean useAirConditioner) {
        this.numPeople = numPeople;
        this.renewblaEnergy = renewblaEnergy;
        this.numLamps = numLamps;
        this.useAirConditioner = useAirConditioner;
    }

    @Override
    public int getCarbonFootprint() {
        if(renewblaEnergy){
            return numPeople + numLamps;
        }else{
            return numPeople * numLamps;
        }
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public boolean isRenewblaEnergy() {
        return renewblaEnergy;
    }

    public void setRenewblaEnergy(boolean renewblaEnergy) {
        this.renewblaEnergy = renewblaEnergy;
    }

    public int getNumLamps() {
        return numLamps;
    }

    public void setNumLamps(int numLamps) {
        this.numLamps = numLamps;
    }

    public boolean isUseAirConditioner() {
        return useAirConditioner;
    }

    public void setUseAirConditioner(boolean useAirConditioner) {
        this.useAirConditioner = useAirConditioner;
    }

}
