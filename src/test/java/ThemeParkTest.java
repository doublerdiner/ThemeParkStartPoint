import attractions.Attraction;
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
        for(Attraction ride : themePark.getAttractions()){
            System.out.println(ride.getName());
            System.out.println(ride.getVisitCount());
        }
    }
    @Test
    public void allReviewReport(){
        System.out.println(themePark.allReviews());
        assertEquals(7, themePark.allReviews().size());
    }
    @Test
    public void checkAvailableAttractions(){
        Visitor visitor = new Visitor(11, 1.38, 20);
        ArrayList<IReviewed> answer = themePark.getAllAllowedFor(visitor);
        assertEquals(5, answer.size());
        Visitor visitor1 = new Visitor(18, 2.01, 15);
        ArrayList<IReviewed> answer2 = themePark.getAllAllowedFor(visitor1);
        assertEquals(6, answer2.size());
    }
}
