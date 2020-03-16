package FunctionLayer;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;

public class Order {
    private ArrayList<CupCake> orderlines = new ArrayList();
    private User customer;

    public void addToOrder(Bottom bottom, Topping top, int amount){
        orderlines.add(new CupCake(amount, bottom, top));
    }

    public ArrayList<CupCake> getOrderlines() {
        return orderlines;
    }

    public void deleteFromOrder(int orderlinesPos){

    }

    public void updateOrder(){

    }

    public void removeOrder(){

    }

    public Order getOrder(int orderID){
        return null;
    }

    public ArrayList<Order> getAllOrders(){
        return null;
    }

    public double getPrice() {
        double total = 0;
        for(CupCake cupcake : orderlines) {
            total += cupcake.getPrice();
        }
        return total;
    }
}
