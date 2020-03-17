package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;
import FunctionLayer.TopAndBottoms;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class MyOrders extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();


        return "WEB-INF/my_orders";
    }
}
