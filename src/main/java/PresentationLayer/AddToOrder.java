package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Order order;
        int amount;
        Bottom bottom;
        Topping topping;

        try {
            if (session.getAttribute("order") == null) {
                session.setAttribute("order", new Order());
            }
            order = (Order) session.getAttribute("order");
            amount = Integer.parseInt(request.getParameter("quantity"));
            //By name
            bottom = TopAndBottoms.getBottomByName(request.getParameter("bottom"));
            topping = TopAndBottoms.getToppingByName(request.getParameter("topping"));

            //By id (might not work)
            //bottom = TopAndBottoms.getBottoms().get(Integer.parseInt(request.getParameter("bottom")));
            //topping = TopAndBottoms.getToppings().get(Integer.parseInt(request.getParameter("topping")));

            if(amount < 1){
                throw new IllegalArgumentException();
            }else if(amount > 30){
                amount = 30;
            }

            order.addToOrder(bottom, topping, amount);

                int cupcakeAmount = 0;
                for (int i = 0; i < order.getOrderlines().size(); i++) {
                    cupcakeAmount += order.getOrderlines().get(i).getAmount();
                }

            session.setAttribute("cupcakeAmount", cupcakeAmount);
            request.setAttribute("msg", "Cupcake tilføjet til kurv!");
            //order.addToOrder(new CupCake());
        }catch(Exception ex) {
            request.setAttribute("msg", "Der skete en fejl. " + ex.getMessage());
        }
        return "index";
    }
}
