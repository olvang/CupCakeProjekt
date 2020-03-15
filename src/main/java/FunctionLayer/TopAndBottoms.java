package FunctionLayer;

import java.util.ArrayList;

public class TopAndBottoms {
    private ArrayList<Bottom> bottoms;
    private ArrayList<Topping> toppings;

    public TopAndBottoms(ArrayList<Bottom> bottoms, ArrayList<Topping> toppings) {
        this.bottoms = bottoms;
        this.toppings = toppings;
    }

    public ArrayList<Bottom> getBottoms() {
        return bottoms;
    }

    public void setBottoms(ArrayList<Bottom> bottoms) {
        this.bottoms = bottoms;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }
}
