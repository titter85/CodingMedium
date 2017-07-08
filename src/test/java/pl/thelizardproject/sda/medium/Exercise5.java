package pl.thelizardproject.sda.medium;

import org.junit.Before;
import org.junit.Test;
import pl.thelizardproject.sda.medium.captain.Captain;
import pl.thelizardproject.sda.medium.ship.Boat;
import pl.thelizardproject.sda.medium.ship.ShipType;
import pl.thelizardproject.sda.medium.ship.TransatlanticShip;
import pl.thelizardproject.sda.medium.ship.strategy.BoatControlStrategy;
import pl.thelizardproject.sda.medium.ship.strategy.TransatlanticShipControlStrategy;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Exercise5 {

   private Captain captain;

    @Before
    public void setUp() throws Exception {
        captain = new Captain();
    }

    @Test
    public void testSailingWithKnownTransatlanticShip() throws Exception {
        String expectedSailStyle = "I can sail with Transatlantic Ship with a transatlantic ship style!";
        captain.setShip(new TransatlanticShip());
        captain.learn(ShipType.Transatlantic, new TransatlanticShipControlStrategy());

        String sailStyle = captain.sail();

        assertThat(sailStyle)
                .isEqualTo(expectedSailStyle);
    }

    @Test
    public void testSailingWithKnownBoat() throws Exception {
        String expectedSailStyle = "I can sail with Boat with a boat style!";
        captain.setShip(new Boat());
        captain.learn(ShipType.Boat, new BoatControlStrategy());

        String sailStyle = captain.sail();

        assertThat(sailStyle)
                .isEqualTo(expectedSailStyle);
    }

    @Test
    public void testSailingWithUnknownTransatlanticShip() throws Exception {
        String expectedSailStyle = "I can't sail with Transatlantic Ship!";
        captain.setShip(new TransatlanticShip());
        captain.learn(ShipType.Boat, new BoatControlStrategy());
        try {
            String sailStyle = captain.sail();

            assertThat(sailStyle)
                    .isEqualTo(expectedSailStyle);
        }catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }

    @Test
    public void testSailingWithUnknownBoat() throws Exception {
        String expectedSailStyle = "I can't sail with Boat!";
        captain.setShip(new Boat());
        captain.learn(ShipType.Transatlantic, new TransatlanticShipControlStrategy());
        try {
            String sailStyle = captain.sail();

            assertThat(sailStyle)
                    .isEqualTo(expectedSailStyle);
        }catch (IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }

    @Test
    public void testSailingWithoutShip() throws Exception {
        assertThatThrownBy(captain::sail)
                .isInstanceOf(IllegalStateException.class)
                .withFailMessage("I can't sail without the ship!");
    }
}