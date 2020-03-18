package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteFromOrder extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int orderlineid = Integer.parseInt(request.getParameter("orderlineid"));
        String currentOrder = request.getParameter("currentorder");

        LogicFacade.removeOrderline(orderlineid);
        System.out.println("currentOrder" + currentOrder);
        session.setAttribute("redirectToOrder", currentOrder);
        return "vieworder";
    }


    public static boolean redirectBackToOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("redirectToOrder") != null) {
            String redirectToOrder = (String) session.getAttribute("redirectToOrder");
            session.setAttribute("redirectToOrder", null);
            System.out.println("redirecttoorder " + redirectToOrder);
            response.sendRedirect("vieworder.jsp?o=" + redirectToOrder);
            return true;
        }
        return false;
    }
}
