package FunctionLayer;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;

public class Order {
    private ArrayList<CupCake> orderlines = new ArrayList();
    private User customer;

    public void addToOrder(Bottom bottom, Topping top, int amount){
        orderlines.add(new CupCake(amount, bottom, top));
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


}
