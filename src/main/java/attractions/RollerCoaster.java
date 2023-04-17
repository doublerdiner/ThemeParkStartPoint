package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster  extends Attraction implements ITicketed, ISecurity {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return 8.4;
    }

    @Override
    public double priceFor(Visitor visitor) {
        if(isAllowedTo(visitor)){
            double total = defaultPrice();
            if(visitor.getHeight()>2){
                total += defaultPrice();
            }
            return total;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        if(visitor.getAge()<13 || visitor.getHeight()<1.46){
            return false;
        }
        return true;
    }
}
