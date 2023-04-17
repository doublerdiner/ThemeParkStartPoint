package people;

import attractions.Park;
import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    RollerCoaster rollerCoaster;
    Park park;


    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }
    @Test
    public void canVisitAttraction(){
        rollerCoaster = new RollerCoaster("Teacups of Terror", 9);
        visitor.visitAttraction(rollerCoaster);
        assertEquals(1, visitor.getVisitedAttractions().size());
        assertEquals("Teacups of Terror", visitor.getVisitedAttractions().get(0).getName());
    }
    @Test
    public void canVisitMultipleAttractions(){
        rollerCoaster = new RollerCoaster("Teacups of Terror", 9);
        park = new Park("Garden Maze", 4);
        visitor.visitAttraction(rollerCoaster);
        visitor.visitAttraction(park);
        assertEquals(2, visitor.getVisitedAttractions().size());
        assertEquals("Teacups of Terror", visitor.getVisitedAttractions().get(0).getName());
        assertEquals("Garden Maze", visitor.getVisitedAttractions().get(1).getName());
    }
}
