package pl.thelizardproject.sda.medium.ship;

import pl.thelizardproject.sda.medium.exception.BrokenShipException;

/**
 * Created by RENT on 2017-07-05.
 */
public class TransatlanticShip extends Ship {
    public TransatlanticShip() {
        super(10000);
        this.shipType = ShipType.Transatlantic;
        this.capacity = 5000;
    }

    @Override
    public String getName() {
        return "Transatlantic Ship";
    }
}
