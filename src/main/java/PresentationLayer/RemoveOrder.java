package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collections;

public class RemoveOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        //Todo check if getAttribute values are valid


        //Is user admin
        User user = (User) session.getAttribute("user");
        if (!user.isAdmin()) {
            return "index";
        }

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        String fromPage = request.getParameter("from");


        //Delete order in db
        LogicFacade.removeOrder(orderId);

        //TODO remember to change this when refactoring admin pages into WEB-INF
        return fromPage;
    }
}
