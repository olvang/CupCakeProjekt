package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "LoginEmail" );
        String password = request.getParameter( "LoginPassword" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.isAdmin() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("balance", user.getBalance());
        System.out.println(session.getAttribute("user"));
        System.out.println(session.getAttribute("role"));
        System.out.println(session.getAttribute("email"));
        System.out.println(session.getAttribute("balance"));

        return "index";
    }

}
