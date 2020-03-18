package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeginEditUser extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String IDToEdit = request.getParameter("userID");
        request.setAttribute("IDToEdit", IDToEdit);

        return "admin_customers";
    }
}
