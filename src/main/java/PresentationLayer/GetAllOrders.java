package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetAllOrders extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        try {
            ArrayList<Order> orders = LogicFacade.getAllOrders();
            request.setAttribute("orders", orders);
        } catch (Exception ex) {
            //TODO Exception

            return "index";
        }

        return "admin_orders";
    }
}
