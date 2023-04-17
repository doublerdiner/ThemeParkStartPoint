package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", 2, ParkingSpot.B1);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }
    @Test
    public void hasRating(){
        assertEquals(2, tobaccoStall.getRating());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }
    @Test
    public void allowsVisitorOver17(){
        visitor = new Visitor(18, 1.8, 30);
        assertEquals(true, tobaccoStall.isAllowedTo(visitor));
    }
    @Test
    public void preventsVisitorUnder18(){
        visitor = new Visitor(17, 1.8, 30);
        assertEquals(false, tobaccoStall.isAllowedTo(visitor));
    }
}
