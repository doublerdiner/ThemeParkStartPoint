package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }
    @Test
    public void allowsVisitorUnder16(){
        visitor = new Visitor(15, 1.5, 25);
        assertEquals(true, playground.isAllowedTo(visitor));
    }
    @Test
    public void preventsVisitorOver15(){
        visitor = new Visitor(16, 1.5, 25);
        assertEquals(false, playground.isAllowedTo(visitor));
    }

}
