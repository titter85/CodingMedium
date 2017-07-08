package pl.thelizardproject.sda.medium;

import org.junit.Before;
import org.junit.Test;
import pl.thelizardproject.sda.medium.captain.Captain;
import pl.thelizardproject.sda.medium.ship.Boat;
import pl.thelizardproject.sda.medium.ship.TransatlanticShip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Exercise3 {

    private Captain captain;

    @Before
    public void setUp() throws Exception {
        captain = new Captain();
    }

    @Test
    public void testSailingWithTransatlanticShip() throws Exception {
        String expectedSailStyle = "I can't sail with Transatlantic Ship!";
        captain.setShip(new TransatlanticShip());

        String sailStyle = captain.sail();

        assertThat(sailStyle)
                .isEqualTo(expectedSailStyle);
    }

    @Test
    public void testSailingWithBoat() throws Exception {
        String expectedSailStyle = "I can sail with Boat like a boss, mate!";
        captain.setShip(new Boat());

        String sailStyle = captain.sail();

        assertThat(sailStyle)
                .isEqualTo(expectedSailStyle);
    }

    @Test
    public void testSailingWithoutShip() throws Exception {
        assertThatThrownBy(captain::sail)
                .isInstanceOf(IllegalStateException.class)
                .withFailMessage("I can't sail without the ship!");
    }
}