package pl.thelizardproject.sda.medium.captain;

import pl.thelizardproject.sda.medium.ship.Boat;
import pl.thelizardproject.sda.medium.ship.Ship;
import pl.thelizardproject.sda.medium.ship.ShipType;
import pl.thelizardproject.sda.medium.ship.TransatlanticShip;
import pl.thelizardproject.sda.medium.ship.strategy.ControlStrategy;

import java.util.*;

/**
 * Created by RENT on 2017-07-05.
 */
public class Captain {

    private Ship ship;
    private HashMap<ShipType, ControlStrategy> strategies = new HashMap<ShipType, ControlStrategy>();

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String sail() throws IllegalStateException{
        try{
            ShipType st = this.ship.getShipType();
            if (strategies.containsKey(st))
                return "I can sail with "+ this.ship.getName() +" with a "+strategies.get(st).getStrategyDefinition() +"!";
            else
                throw new IllegalStateException("I can't sail with the "+this.ship.getName()+"!");
        }catch(NullPointerException npe){
            throw new IllegalStateException("I can't sail without the ship!");
        }
    }

    public void learn(ShipType st, ControlStrategy cs){
        strategies.put(st, cs);
    }
}
