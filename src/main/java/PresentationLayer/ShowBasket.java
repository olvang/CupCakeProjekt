package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBasket extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        if (session.getAttribute("order") == null) {
            session.setAttribute("order", new Order());
        }
        Order order = (Order) session.getAttribute("order");

        int cupcakeAmount = 0;
        for (int i = 0; i < order.getOrderlines().size(); i++) {
            cupcakeAmount += order.getOrderlines().get(i).getAmount();
        }
        session.setAttribute("cupcakeAmount", cupcakeAmount);

        return "basket";
    }
}