package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ShowFrontPage extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        //TODO consider whether this should even be a command
        TopAndBottoms.initTopAndBottoms();
        ArrayList<Bottom> bottoms = TopAndBottoms.getBottoms();
        ArrayList<Topping> toppings = TopAndBottoms.getToppings();

        request.setAttribute("bottoms", bottoms);
        request.setAttribute("toppings", toppings);

        return "index";
    }
}
