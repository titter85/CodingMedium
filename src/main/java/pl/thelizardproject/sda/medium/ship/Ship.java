package pl.thelizardproject.sda.medium.ship;

import pl.thelizardproject.sda.medium.exception.BrokenShipException;
import pl.thelizardproject.sda.medium.tourist.Tourist;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Ship {

    int endurance;
    ShipType shipType;
    int capacity;
    ArrayList<Tourist> tourists = new ArrayList<>();

    Ship(int endurance) {
        this.endurance = endurance;
    }

    public void sail() throws BrokenShipException {
        this.endurance--;
        if (this.endurance == 0) {
            throw new BrokenShipException(this.getName());
        }
    }

    public int getEndurance() {
        return endurance;
    }

    public abstract String getName();

    public ShipType getShipType() {
        return shipType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addTourist(Tourist tourist) throws IllegalStateException{
        if (tourists.size() != this.getCapacity()){
            tourists.add(tourist);
        }else{
            throw new IllegalStateException("Too much tourists!");
        }
    }

    public int getTouristCount() {
        return tourists.size();
    }

    public Tourist getFirstTourist() {
        return (!tourists.isEmpty())?tourists.get(0):null;
    }

    public boolean isNotEmpty(){
        return (tourists.isEmpty())?true:false;
    }
}