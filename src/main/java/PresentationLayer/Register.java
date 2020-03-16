package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "RegisterEmail" );
        String password1 = request.getParameter( "RegisterPassword1" );
        String password2 = request.getParameter( "RegisterPassword2" );

       if ( password1.equals( password2 ) ) {
            try {
                User user = LogicFacade.createUser(email, password1);
                HttpSession session = request.getSession();

                session.setAttribute("email", email);
                session.setAttribute("user", user);
                session.setAttribute("role", user.isAdmin());
                session.setAttribute("balance", user.getBalance());
                return "index";
            } catch(Exception ex) {
                request.setAttribute("error", "Bruger med valgte email findes allerede");
                return "login";
            }
       } else {
            request.setAttribute("error", "De to kodeord skal være ens");
            return "login";
       }
    }

}
