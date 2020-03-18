package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ViewOrder extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        //TODO check if the user actually owns the order and then proceed
        Order order = null;
        try {
            order = LogicFacade.getOrder(Integer.parseInt(request.getParameter("o")));
            User userLoggedIn = (User) session.getAttribute("user");

            //HVis brugeren er admin skal den ikke tjekke ejerskab
            //Ellers hvis brugeren ikke ejer den valgte ordre, smider den en til index
            if(userLoggedIn.isAdmin() || order.getCustomer().getEmail().equals(userLoggedIn.getEmail()) ) {

                //Selve logikken
                ArrayList<CupCake> orderlines = order.getOrderlines();
                int cupcakeAmount = 0;
                for (int i = 0; i < orderlines.size(); i++) {
                    cupcakeAmount += orderlines.get(i).getAmount();
                }
                session.setAttribute("cupcakeTotalAmount", cupcakeAmount);
                request.setAttribute("order", order);
                request.setAttribute("orderlines", orderlines);
                //Selve logikken slut

                response.sendRedirect("vieworder.jsp");
                return "vieworder";
            }

            //Brugeren ejer ikke valgte ordre
            request.setAttribute("adminalert", "Du har ikke tilladelse til at se den valgte ordre");
            response.sendRedirect("index.jsp");
            return "index";

        } catch (LoginSampleException | IOException e) {
            //Ordren findes ikke
            request.setAttribute("adminalert", "Den valgte ordre findes ikke");
            return "index";
        }

    }
}
