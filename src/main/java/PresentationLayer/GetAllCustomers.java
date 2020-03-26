package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetAllCustomers extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        ArrayList<User> users = null;
        try {
            users = LogicFacade.getAllCustomers();
        } catch (LoginSampleException e) {
            request.setAttribute("msg", "Der skete en fejl. " + e.getMessage());
            return "index";
        }
        HttpSession session = request.getSession();
        if(session.getAttribute("role") == null || (boolean) session.getAttribute("role") == false) {
            request.setAttribute("adminalert", "Du har ikke tilladelse til at se denne side.");
            return "index";
        }
        session.setAttribute("users", users);
        return "WEB-INF/admin_customers";
    }
}
