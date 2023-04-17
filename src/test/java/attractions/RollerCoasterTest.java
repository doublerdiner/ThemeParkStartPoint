package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollerCoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }
    @Test
    public void defaultChargeForVisitor(){
        visitor = new Visitor(15, 1.8, 20);
        double answer = rollerCoaster.priceFor(visitor);
        assertEquals(8.40, answer, 0.01);
    }
    @Test
    public void doubleChargeForTallVisitor(){
        visitor = new Visitor(20, 2.01, 30);
        double answer = rollerCoaster.priceFor(visitor);
        assertEquals(16.8, answer, 0.01);
    }
    @Test
    public void allowsVisitorOver12And145cm(){
        visitor = new Visitor(13, 1.46, 10);
        assertEquals(true, rollerCoaster.isAllowedTo(visitor));
    }
    @Test
    public void preventsVisitorUnder13And146cm(){
        visitor = new Visitor(12, 1.45, 10);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }
    @Test
    public void preventsVisitorUnder13(){
        visitor = new Visitor(12, 1.70, 10);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }
    @Test
    public void preventsVisitorUnder146cm(){
        visitor = new Visitor(15, 1.45, 10);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor));
    }


}
