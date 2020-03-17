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

public class Pay extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        Date date;

        //Check if date is correct
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
            date = simpleDateFormat.parse(request.getParameter("date"));
        }catch(Exception ex) {
            request.setAttribute("dateError", "Forkert dato format, prøv igen");
            return "basket";
        }


        try {
            User user = (User) session.getAttribute("user");
            Order order = (Order) session.getAttribute("order");
            order.setCustomer(user);
            order.setPickupDate(date);
            if(LogicFacade.saveOrder(order)){
                session.setAttribute("order", null);
                session.setAttribute("cupcakeAmount", null);
                session.setAttribute("successMessage", "Tak for din ordre, vi glæder os til at se dig!");
            }else{
                request.setAttribute("error", "Kunne ikke indsætte orderen i databasen, prøv igen");
                return "basket";
            }
        }catch(Exception ex) {
            request.setAttribute("dateError", "Forkert dato format, prøv igen");
            return "basket";
        }

        return "index";


    }
}
