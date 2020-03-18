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
        session.setAttribute("users", users);


        //TODO remember to change this when refactoring admin pages into WEB-INF
        return "admin_customers";
    }
}
