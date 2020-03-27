package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class BeginEditUser extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<User> users = null;
        String IDToEdit = request.getParameter("userID");
        String userEmail = request.getParameter("userEmail");
        //get all customers
        try {
            users = LogicFacade.getAllCustomers();

            request.setAttribute("users", users);
            request.setAttribute("IDToEdit", IDToEdit);
            request.setAttribute("userEmail", userEmail);
        } catch (LoginSampleException e) {
            request.setAttribute("msg", "Der skete en fejl. " + e.getMessage());
            return "index";
        }

        return "WEB-INF/admin_customers";
    }
}
