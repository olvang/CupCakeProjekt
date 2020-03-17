package PresentationLayer;

import FunctionLayer.CupCake;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ViewOrder extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        //TODO check if the user actually owns the order and then proceed

        Order order = LogicFacade.getOrder(Integer.parseInt(request.getParameter("o")));
        ArrayList<CupCake> orderlines = order.getOrderlines();

        int cupcakeAmount = 0;
        for (int i = 0; i < orderlines.size(); i++) {
            cupcakeAmount += orderlines.get(i).getAmount();
        }
        session.setAttribute("cupcakeTotalAmount", cupcakeAmount);
        request.setAttribute("order", order);
        request.setAttribute("orderlines", orderlines);

        return "vieworder";
    }
}
