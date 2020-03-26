package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCustomer extends Command{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        return "admin/view_customer";
    }
}
