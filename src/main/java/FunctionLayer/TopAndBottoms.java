package FunctionLayer;

public class TopAndBottoms {
    private Bottom bottoms;
    private Topping toppings;

    public TopAndBottoms(Bottom bottoms, Topping toppings) {
        this.bottoms = bottoms;
        this.toppings = toppings;
    }

    public Bottom getBottoms() {
        return bottoms;
    }

    public void setBottoms(Bottom bottoms) {
        this.bottoms = bottoms;
    }

    public Topping getToppings() {
        return toppings;
    }

    public void setToppings(Topping toppings) {
        this.toppings = toppings;
    }
}
