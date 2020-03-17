package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pay extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Date date;

        //Check if date is correct
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            date = simpleDateFormat.parse(request.getParameter("date"));
        } catch (Exception ex) {
            request.setAttribute("dateError", "Forkert dato format, prøv igen");
            return "basket";
        }



        try {
            User user = (User) session.getAttribute("user");
            Order order = (Order) session.getAttribute("order");
            order.setCustomer(user);
            order.setPickupDate(date);


            //check if user has enough to buy
            if(order.getPrice() > order.getCustomer().getBalance()){
                request.setAttribute("error", "Din saldo er for lav til denne ordre");
                return "basket";
            }

            //Inserts order to db and "resets"
            if (LogicFacade.saveOrder(order)) {
                //Updates the user balance on the session
                order.getCustomer().setBalance(order.getCustomer().getBalance()-order.getPrice());

                //reset/sets Attributes
                session.setAttribute( "user", order.getCustomer() );
                session.setAttribute( "balance", order.getCustomer().getBalance() );
                session.setAttribute("order", null);
                session.setAttribute("cupcakeAmount", null);
                request.setAttribute("orderMessage", "Tak for din ordre, vi glæder os til at se dig!");
                return "index";
            } else {
                request.setAttribute("error", "Kunne ikke indsætte orderen i databasen, prøv igen");
                return "basket";
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Der skete desværre en fejl, prøv igen");
            return "basket";
        }
    }
}
