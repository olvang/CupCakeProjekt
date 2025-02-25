package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class MyOrders extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user;

        try {
            user = (User) session.getAttribute("user");

        } catch (Exception ex) {
            //Not logged in
            return "index";
        }

        try {
            ArrayList<Order> orders = user.getUserOrders(user.getId());
            request.setAttribute("orders", orders);

        } catch (Exception ex) {
            request.setAttribute("msg", "Der skete en fejl. " + ex.getMessage());
            return "index";
        }

        return "WEB-INF/myorders";
    }
}
