package pl.thelizardproject.sda.medium;

import org.junit.Test;
import pl.thelizardproject.sda.medium.exception.BrokenShipException;
import pl.thelizardproject.sda.medium.ship.Boat;
import pl.thelizardproject.sda.medium.ship.Ship;
import pl.thelizardproject.sda.medium.ship.TransatlanticShip;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Exercise4 {

    @Test
    public void testSailAfterOfBrokenShip() {
        Ship ship = new TransatlanticShip();
        try{
            sail(ship, 10000);
            assertThatThrownBy(ship::sail)
                   .isInstanceOf(BrokenShipException.class);
                  //.withFailMessage("The Transatlantic Ship is broken");
        }catch (BrokenShipException bse){
            System.out.println(bse.getMessage());
        }
    }

    private static void sail(Ship ship, int amount) throws BrokenShipException {
        for (int i = 0; i < amount; i++) {
            ship.sail();
        }
    }
}