package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.TopAndBottoms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowFrontPage extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        TopAndBottoms catalog = LogicFacade.getTopAndBottoms();

        request.setAttribute("bottoms", catalog.getBottoms());
        request.setAttribute("toppings", catalog.getToppings());

        return "index";
    }
}
