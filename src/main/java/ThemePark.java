import attractions.*;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
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
        String attractionName = attraction.getName();
        for(Attraction ride : this.attractions) {
            if (ride.getName() == attractionName) {
                int index = this.attractions.indexOf(ride);
                int currentVisits = this.attractions.get(index).getVisitCount();
                this.attractions.get(index).setVisitCount(currentVisits + 1);
                visitor.visitAttraction(ride);
            }
        }
    }
    public HashMap<String, Integer> allReviews(){
        HashMap<String, Integer> result = new HashMap<>();
        for(Attraction ride : this.attractions){
            result.put(ride.getName(), ride.getRating());
        }
        for(Stall stall : this.stalls){
            result.put(stall.getName(), stall.getRating());
        }
        return result;
    }
    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> response = getAllReviewed();
        ArrayList<IReviewed> finalAnswer = new ArrayList<>();
        for(IReviewed activity : response){
            if(activity.getName().contains("Runaway")){
                if(((RollerCoaster) activity).isAllowedTo(visitor)) {
                    finalAnswer.add(activity);
                    continue;
                }
                else{continue;}
            }
            if(activity.getName().contains("Pleasant")){
                if(((Playground) activity).isAllowedTo(visitor)) {
                    finalAnswer.add(activity);
                    continue;
                }
                else{continue;}
            }
            if(activity.getName().contains("Smokey")){
                if(((TobaccoStall)activity).isAllowedTo(visitor)){
                    finalAnswer.add(activity);
                    continue;
                }
                else{continue;}
            }
            finalAnswer.add(activity);
        }
        return finalAnswer;
    }

}
