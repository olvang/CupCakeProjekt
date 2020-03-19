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
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<User> users = LogicFacade.getAllCustomers();
        HttpSession session = request.getSession();
        if(session.getAttribute("role") == null || (boolean) session.getAttribute("role") == false) {
            System.out.println("no permission");
            request.setAttribute("adminalert", "Du har ikke tilladelse til at se denne side.");
            return "index";
        }
        session.setAttribute("users", users);
        //TODO remember to change this when refactoring admin pages into WEB-INF
        return "WEB-INF/admin_customers";
    }
}
