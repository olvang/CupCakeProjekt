package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;
import FunctionLayer.TopAndBottoms;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AdminDashboard extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        if(session.getAttribute("role") == null || (boolean) session.getAttribute("role") == false) {
            request.setAttribute("adminalert", "Du har ikke tilladelse til at se denne side.");
            return "index";
        }
        return "admin_dash";
        //TODO remember to change this when refactoring admin pages into WEB-INF

    }
}