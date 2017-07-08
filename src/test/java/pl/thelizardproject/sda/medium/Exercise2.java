package pl.thelizardproject.sda.medium;

import org.junit.Before;
import org.junit.Test;
import pl.thelizardproject.sda.medium.ship.Boat;
import pl.thelizardproject.sda.medium.ship.Ship;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise2 {

    private Ship ship;

    @Before
    public void setUp() throws Exception {
        ship = new Boat();
    }

    @Test
    public void testName() throws Exception {
        String expectedName = "Boat";

        String name = ship.getName();

        assertThat(name)
                .isEqualTo(expectedName);
    }

    @Test
    public void testEnduranceOfNewShip() throws Exception {
        int expectedEndurance = 200;

        int endurance = ship.getEndurance();

        assertThat(endurance)
                .isEqualTo(expectedEndurance);
    }

    @Test
    public void testEnduranceAfterOneTrip() throws Exception {
        int expectedEndurance = 198;

        sail(ship, 1);
        int endurance = ship.getEndurance();

        assertThat(endurance)
                .isEqualTo(expectedEndurance);
    }

    @Test
    public void testEnduranceAfter20Trips() throws Exception {
        int expectedEndurance = 160;

        sail(ship, 20);
        int endurance = ship.getEndurance();

        assertThat(endurance)
                .isEqualTo(expectedEndurance);
    }

    private static void sail(Ship ship, int amount) throws Exception {
        for (int i = 0; i < amount; i++) {
            ship.sail();
        }
    }
}