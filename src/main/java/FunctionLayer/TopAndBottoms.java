package FunctionLayer;

import java.util.ArrayList;

public class TopAndBottoms {
    private static ArrayList<Bottom> bottoms;
    private static ArrayList<Topping> toppings;

    //TODO refactor constructor out
    public TopAndBottoms(ArrayList<Bottom> bottoms, ArrayList<Topping> toppings) {
        this.bottoms = bottoms;
        this.toppings = toppings;
    }

    public static void initTopAndBottoms() {
        if(bottoms == null) {
            bottoms = LogicFacade.getBottoms();
        }
        if(toppings == null) {
            toppings = LogicFacade.getToppings();
        }
    }

    public static ArrayList<Bottom> getBottoms() {
        return bottoms;
    }

    public static ArrayList<Topping> getToppings() {
        return toppings;
    }

    public static Bottom getBottomByName(String name) {
        if (name == null) {
            for(Bottom bottom : bottoms) {
                if(bottom == null) {
                    return null;
                }
            }
        }
        for(Bottom bottom : bottoms) {
            if(name.equals(bottom.getName())) {
                return bottom;
            }
        }
        return null;
    }

    public static Topping getToppingByName(String name) {
        if (name == null) {
            for(Topping topping : toppings) {
                if(topping == null) {
                    return null;
                }
            }
        }
        for(Topping topping : toppings) {
            if(name.equals(topping.getName())) {
                return topping;
            }
        }
        return null;
    }

}
