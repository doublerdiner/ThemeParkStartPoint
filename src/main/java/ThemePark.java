import attractions.*;
import behaviours.IReviewed;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

public class ThemePark {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
//    Dodgems dodgems = new Dodgems("Dodgems", 8);
//    Park park = new Park("Peaks Park", 6);
//    Playground playground = new Playground("Pleasant Playground", 5);
//    RollerCoaster rollerCoaster = new RollerCoaster("Runaway Train", 9);
//    CandyflossStall candyflossStall = new CandyflossStall("Sugar Hit", "Barry", 7, ParkingSpot.A1);
//    IceCreamStall iceCreamStall = new IceCreamStall("Deep Freeze", "Barry", 10, ParkingSpot.A2);
//    TobaccoStall tobaccoStall = new TobaccoStall("Smokey Joe's", "Barry", 1, ParkingSpot.A3);
    public ThemePark(){
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
        attractions.add(new Dodgems("Dodgems", 8));
        attractions.add(new Park("Peaks Park", 6));
        attractions.add(new Playground("Pleasant Playground", 5));
        attractions.add(new RollerCoaster("Runaway Train", 9));
        stalls.add(new CandyflossStall("Sugar Hit", "Barry", 7, ParkingSpot.A1));
        stalls.add(new IceCreamStall("Deep Freeze", "Barry", 10, ParkingSpot.A2));
        stalls.add(new TobaccoStall("Smokey Joe's", "Barry", 1, ParkingSpot.A3));
    }

    public ArrayList<Attraction> getAttractions() {
        return attractions;
    }

    public ArrayList<IReviewed> getAllReviewed(){
        ArrayList<IReviewed> response = new ArrayList<>();
        for(IReviewed stall : this.stalls){
            response.add(stall);
        }
        for(IReviewed attraction : this.attractions){
            response.add(attraction);
        }
        return response;
    }
    public void visitAttraction(Visitor visitor, Attraction attraction){
        this.attractions.add(attraction);
        int index = this.attractions.indexOf(attraction);
        int currentVisits = this.attractions.get(index).getVisitCount();
        this.attractions.get(index).setVisitCount(currentVisits + 1);
        visitor.visitAttraction(attraction);
    }
}
