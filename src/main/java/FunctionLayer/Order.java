package FunctionLayer;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<CupCake> orderlines = new ArrayList();
    private User customer;
    private Date pickupDate;
    private Date orderDate;

    //Burde vi have en klasse til historiske ordre?
    //Det ville jo være spild at fylde arraylisten med cupcakes på alle
    // ordre når brugeren går ind på sin oversigt, da det jo ikke er alle
    // de vil se. Men det virker også underligt at gemme antal cupcakes som
    // en int på ordren. Det føles som to forskellige brugssituationer.
    // hvad tænker i?
    private int orderId;
    private int amount;
    private double manualPrice;

    public void addToOrder(Bottom bottom, Topping top, int amount){
        orderlines.add(new CupCake(amount, bottom, top));
    }


    public void deleteFromOrder(int orderlinesPos){
        orderlines.remove(orderlinesPos);
    }


    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }
    public void setCustomer(User customer) {
        this.customer = customer;
    }
    public void setOrderId(int id) {this.orderId = id;}
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPrice(double price) {
        this.manualPrice = price;
    }

    public User getCustomer() {
        return customer;
    }
    public int getUserId(){
        return customer.getId();
    }
    public Date getPickupDate() {
        return pickupDate;
    }
    public int getOrderId() {return orderId;}
    public int getAmount() {
        return amount;
    }
    public double getPrice() {
        if(orderlines.isEmpty()) {
            return manualPrice;
        }
        double total = 0;
        for(CupCake cupcake : orderlines) {
            total += cupcake.getPrice();
        }
        return total;
    }
    public ArrayList<CupCake> getOrderlines() {
        return orderlines;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderlines(ArrayList<CupCake> orderlines) {
        this.orderlines = orderlines;
    }
}
