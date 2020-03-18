package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeginEditUser extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String IDToEdit = request.getParameter("userID");
        String userEmail = request.getParameter("userEmail");
        request.setAttribute("IDToEdit", IDToEdit);
        request.setAttribute("userEmail", userEmail);

        //TODO remember to change this when refactoring admin pages into WEB-INF
        return "admin_customers";
    }
}
