package FunctionLayer;

public class CupCake {
    private int amount;
    private Bottom bottom;
    private Topping top;
    private double price;

    public CupCake(int amount, Bottom bottom, Topping topping) {
        this.amount = amount;
        this.bottom = bottom;
        this.top = topping;
        calculatePrice();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
        calculatePrice();
    }

    public Bottom getBottom() {
        return bottom;
    }

    public int getBottomId(){
        return bottom.getId();
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
        calculatePrice();
    }

    public Topping getTop() {
        return top;
    }

    public int getTopId(){
        return top.getId();
    }

    public void setTop(Topping top) {
        this.top = top;
        calculatePrice();
    }

    public double getPrice() {
        calculatePrice();
        return price;
    }

    private void calculatePrice() {
        price = ( bottom.getPrice() + top.getPrice() ) * amount;
    }
}
