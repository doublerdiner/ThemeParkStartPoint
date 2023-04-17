import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {
    private ThemePark themePark;
    private RollerCoaster rollerCoaster;
    private Visitor visitor;

    @Before
    public void setup(){
        themePark = new ThemePark();
    }
    @Test
    public void getAllReviewed(){
        ArrayList<IReviewed> answer = themePark.getAllReviewed();
        assertEquals(7, answer.size());
    }
    @Test
    public void visitAttraction(){
        rollerCoaster = new RollerCoaster("Runaway Train", 9);
        visitor = new Visitor(20, 1.7, 30);
        themePark.visitAttraction(visitor, rollerCoaster);
        assertEquals("Runaway Train", visitor.getVisitedAttractions().get(0).getName());
        assertEquals(1, rollerCoaster.getVisitCount());
    }
}
