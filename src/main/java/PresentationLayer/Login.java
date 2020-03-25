package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) {
        String email = request.getParameter( "LoginEmail" );
        String password = request.getParameter( "LoginPassword" );
        User user = null;
        try {
            user = LogicFacade.login( email, password );
        } catch (LoginSampleException e) {
            request.setAttribute("loginmsg", "Brugernavn eller password er forkert.");
            return "login";
        }

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.isAdmin() );
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        session.setAttribute("balance", user.getBalance());

        return "index";
    }

}
