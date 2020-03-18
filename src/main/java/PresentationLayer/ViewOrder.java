package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ViewOrder extends Command {

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
            if (userLoggedIn.isAdmin() || order.getCustomer().getEmail().equals(userLoggedIn.getEmail())) {

                //Selve logikken
                ArrayList<CupCake> orderlines = order.getOrderlines();
                int cupcakeAmount = 0;
                for (int i = 0; i < orderlines.size(); i++) {
                    cupcakeAmount += orderlines.get(i).getAmount();
                }
                session.setAttribute("cupcakeTotalAmount", cupcakeAmount);
                request.setAttribute("order", order);
                request.setAttribute("orderlines", orderlines);

                String arrivedFrom = request.getParameter("from");
                System.out.println("Arrived from: " + arrivedFrom);
                request.setAttribute("targetpage", arrivedFrom); //tager parameter fra url og lægger i request
                //Selve logikken slut

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

    public static void authenticateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        User userLoggedIn = (User) session.getAttribute("user");
        String orderParam = request.getParameter("o");

        //Hvis noget i denne block failer, sendes brugeren tilbage til index.jsp
        try {
            //Hvis parametren for ordren ikke er sat vil den næste del crashe siden.
            //Derfor tjekkes det først
            if (orderParam == null) {
                request.setAttribute("adminalert", "Den valgte ordre findes ikke");
                response.sendRedirect("index.jsp");
            } else {
                Order order = LogicFacade.getOrder(Integer.parseInt(orderParam));
                request.setAttribute("currentorder", order.getOrderId());
                //Hvis o ikke er sat er der ikke valgt en ordre
                //Så smider den en hen til index, med en fejl
                if (order == null) {
                    request.setAttribute("adminalert", "Den valgte ordre findes ikke");
                    response.sendRedirect("index.jsp");
                    //Hvis user er null er man ikke logget ind
                    //Så smider den en hen til login, med en fejl
                } else if (userLoggedIn == null || !order.getCustomer().getEmail().equals(userLoggedIn.getEmail()) && !userLoggedIn.isAdmin()) {
                    request.setAttribute("adminalert", "Du skal være logget ind for at se den valgte side");
                    response.sendRedirect("login.jsp");
                } else {
                    new ViewOrder().execute(request, response);
                }
            }
        } catch(LoginSampleException ex) {
            response.sendRedirect("index.jsp");
        }
    }
}
