package pl.thelizardproject.sda.medium.ship;

import pl.thelizardproject.sda.medium.exception.BrokenShipException;

/**
 * Created by RENT on 2017-07-05.
 */
public class Boat extends Ship {
    public Boat() {
        super(200);
        this.shipType = ShipType.Boat;
        this.capacity = 5;
    }

    public void sail() throws BrokenShipException{
        this.endurance--;
        super.sail();
    }

    @Override
    public String getName() {
        return "Boat";
    }
}
