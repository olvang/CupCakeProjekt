package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Order order;
        int amount;
        Bottom bottom;
        Topping topping;

        if (session.getAttribute("order") == null) {
            session.setAttribute("order", new Order());
        }
        order = (Order) session.getAttribute("order");
        amount = Integer.parseInt(request.getParameter("amount"));


        //order.addToOrder(new CupCake());

        return "index";
    }
}
