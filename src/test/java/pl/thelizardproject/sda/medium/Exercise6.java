package pl.thelizardproject.sda.medium;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import pl.thelizardproject.sda.medium.exception.BrokenShipException;
import pl.thelizardproject.sda.medium.ship.Boat;
import pl.thelizardproject.sda.medium.ship.Ship;
import pl.thelizardproject.sda.medium.ship.TransatlanticShip;
import pl.thelizardproject.sda.medium.tourist.Tourist;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;



public class Exercise6 {

    @Test
    public void testCapacityOnTransatlanticShip() throws Exception {
        int expectedCapacity = 5000;
        Ship ship = new TransatlanticShip();

        int capacity = ship.getCapacity();

        assertThat(capacity)
                .isEqualTo(expectedCapacity);
    }

    @Test
    public void testCapacityOnBoat() throws Exception {
        int expectedCapacity = 5;
        Ship ship = new Boat();

        int capacity = ship.getCapacity();

        assertThat(capacity)
                .isEqualTo(expectedCapacity);
    }

    @Test
    public void testExceedCapacityOnBoat() throws Exception {
        try {
            Ship ship = new Boat();
            addTourist(ship, new Tourist("", 1, false), new Tourist("", 1, false), new Tourist("", 1, false), new Tourist("", 1, false), new Tourist("", 1, false));

            assertThatThrownBy(() -> ship.addTourist(new Tourist("", 1, false)))
                    .isInstanceOf(IllegalStateException.class)
                    .withFailMessage("Too much tourists!");
        }catch(IllegalStateException ise){
            System.out.println(ise.getMessage());
        }
    }

    @Test
    public void testAddTourist() throws Exception {
        Tourist tourist = new Tourist("tourist1", 18, false);
        Ship ship = new TransatlanticShip();

        ship.addTourist(tourist);

        assertThat(ship.getTouristCount())
                .isEqualTo(1);
    }

    @Test
    public void testGetFirstTourist() throws Exception {
        Ship ship = new TransatlanticShip();
        Tourist tourist1 = new Tourist("Adam", 15, true);
        Tourist tourist2 = new Tourist("Tomasz", 8, true);
        Tourist tourist3 = new Tourist("Martyna", 18, false);
        addTourist(ship, tourist1, tourist2, tourist3);

        assertThat(ship.getFirstTourist())
                .isNotEmpty()
                .hasValue(tourist1);

    }

    @Test
    public void testGetLastTourist() throws Exception {
//        Ship ship = new TransatlanticShip();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        assertThat(ship.getLastTourist())
//                .isNotEmpty()
//                .hasValue(tourist3);
    }

    @Test
    public void testGetTouristNames() throws Exception {
//        Ship ship = new TransatlanticShip();
//        addTourist(ship, new Tourist("Adam", 15, true), new Tourist("Tomasz", 8, true), new Tourist("Martyna", 18, false));
//
//        assertThat(ship.getTouristNames())
//                .isEqualTo("Adam, Tomasz, Martyna");
    }

    @Test
    public void testGetTheOldestTourist() throws Exception {
//        Ship ship = new TransatlanticShip();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        assertThat(ship.getTheOldestTourist())
//                .isNotEmpty()
//                .hasValue(tourist3);
    }

    @Test
    public void testGetTheYoungestTourist() throws Exception {
//        Ship ship = new TransatlanticShip();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        assertThat(ship.getTheYoungestTourist())
//                .isNotEmpty()
//                .hasValue(tourist2);
    }

    @Test
    public void testGetTouristsSortedByAgeAscending() throws Exception {
//        Ship ship = new Boat();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        List<Tourist> sortedTourists = ship.getTouristsSortedByAgeAsc();
//
//        assertThat(sortedTourists)
//                .containsExactly(tourist2, tourist1, tourist3);
    }

    @Test
    public void testGetTouristsSortedByAgeDescending() throws Exception {
//        Ship ship = new Boat();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        List<Tourist> sortedTourists = ship.getTouristsSortedByAgeDesc();
//
//        assertThat(sortedTourists)
//                .containsExactly(tourist3, tourist1, tourist2);
    }

    @Test
    public void testGetFemaleTourists() throws Exception {
//        Ship ship = new Boat();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        List<Tourist> sortedTourists = ship.getFemaleTourists();
//
//        assertThat(sortedTourists)
//                .containsExactlyInAnyOrder(tourist3);
    }

    @Test
    public void testGetMaleTourists() throws Exception {
//        Ship ship = new Boat();
//        Tourist tourist1 = new Tourist("Adam", 15, true);
//        Tourist tourist2 = new Tourist("Tomasz", 8, true);
//        Tourist tourist3 = new Tourist("Martyna", 18, false);
//        addTourist(ship, tourist1, tourist2, tourist3);
//
//        List<Tourist> sortedTourists = ship.getMaleTourists();
//
//        assertThat(sortedTourists)
//                .containsExactlyInAnyOrder(tourist1, tourist2);
    }

    private static void addTourist(Ship ship, Tourist... tourists) throws BrokenShipException {
        Arrays.stream(tourists)
                .forEach(ship::addTourist);
    }
}