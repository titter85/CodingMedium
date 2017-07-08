package pl.thelizardproject.sda.medium;

import org.junit.Before;
import org.junit.Test;
import pl.thelizardproject.sda.medium.ship.Ship;
import pl.thelizardproject.sda.medium.ship.TransatlanticShip;


import static org.assertj.core.api.Assertions.assertThat;

public class Exercise1 {

    private Ship ship;

    @Before
    public void setUp() throws Exception {
       ship = new TransatlanticShip();
    }

    @Test
    public void testName() throws Exception {
        String expectedName = "Transatlantic Ship";

        String name = ship.getName();

        assertThat(name)
                .isEqualTo(expectedName);
    }

    @Test
    public void testEnduranceOfNewShip() throws Exception {
        int expectedEndurance = 10000;

        int endurance = ship.getEndurance();

        assertThat(endurance)
                .isEqualTo(expectedEndurance);
    }

    @Test
    public void testEnduranceAfterOneTrip() throws Exception {
        int expectedEndurance = 9999;

        sail(ship, 1);
        int endurance = ship.getEndurance();

        assertThat(endurance)
                .isEqualTo(expectedEndurance);
    }

    @Test
    public void testEnduranceAfter20Trips() throws Exception {
        int expectedEndurance = 9980;

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