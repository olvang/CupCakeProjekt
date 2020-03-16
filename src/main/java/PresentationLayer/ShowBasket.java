package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowBasket extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        if (session.getAttribute("order") == null) {
            session.setAttribute("order", new Order());
        }
        Order order = (Order) session.getAttribute("order");

        return "basket";
    }
}