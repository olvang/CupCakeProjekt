package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class UpdateUser extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response)  {
        HttpSession session = request.getSession();

        String email = request.getParameter("editedEmail");
        String password = request.getParameter("editedPassword");
        double balance = Double.parseDouble(request.getParameter("editedBalance"));
        int id = Integer.parseInt(request.getParameter("userID"));
        int count = Integer.parseInt(request.getParameter("counter"));

        User user = new User(email, false, balance);
        user.setId(id);

        if(!password.equals("")) {
            user.setPassword(password);
        }
        try {
            LogicFacade.updateUser(user);
        } catch (LoginSampleException e) {
            request.setAttribute("msg", "Der skete en fejl. " + e.getMessage());
            return "index";
        }

        ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
        users.get(count).setBalance(balance);
        users.get(count).setEmail(email);

        String loggedInUser = ((User) session.getAttribute("user")).getEmail();
        if(user.getEmail().equals(loggedInUser)) {
            session.setAttribute("balance", balance);
        }

        return "WEB-INF/admin_customers";
    }
}
