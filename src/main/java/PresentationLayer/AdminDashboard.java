package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class AdminDashboard extends Command {
    private LocalDateTime today = LocalDateTime.now();
    private int THIS_YEAR = today.getYear();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        if(session.getAttribute("role") == null || (boolean) session.getAttribute("role") == false) {
            request.setAttribute("adminalert", "Du har ikke tilladelse til at se denne side.");
            return "index";
        }
        request.setAttribute("OrdersByMonth",LogicFacade.getOrdersByMonth(THIS_YEAR));
        request.setAttribute("amountOfCupcakes", LogicFacade.getAmountOfCupcakes());
        request.setAttribute("amountOfOrders", LogicFacade.getAmountOfOrders());
        request.setAttribute("amountOfUsers", LogicFacade.getAmountOfUsers());
        request.setAttribute("totalSale", LogicFacade.getTotalSale());
        request.setAttribute("last5", LogicFacade.getLast5());

        return "admin_dash";
        //TODO remember to change this when refactoring admin pages into WEB-INF

    }
}