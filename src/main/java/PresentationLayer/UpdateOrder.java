package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession();

        Order order = (Order) session.getAttribute("order");

        int amount = 0;
        for (int i = 0; i < order.getOrderlines().size(); i++) {
            amount = Integer.parseInt(request.getParameter("quantity"+i));
            if(amount < 1){
                order.getOrderlines().remove(i);
            }else if(amount > 30){
                order.getOrderlines().get(i).setAmount(30);
            } else{
                order.getOrderlines().get(i).setAmount(amount);
            }
        }

        new ShowBasket();

        return "basket";
    }
}
