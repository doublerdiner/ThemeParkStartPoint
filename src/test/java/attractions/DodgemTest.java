package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }
    @Test
    public void defaultChargeForVisitors(){
        visitor = new Visitor(15, 1.8, 20);
        double answer = dodgems.priceFor(visitor);
        assertEquals(4.5, answer, 0.01);
    }
    @Test
    public void halfChargeForYoungVisitor(){
        visitor = new Visitor(10, 1.35, 15);
        double answer = dodgems.priceFor(visitor);
        assertEquals(2.25, answer, 0.01);
    }
}
