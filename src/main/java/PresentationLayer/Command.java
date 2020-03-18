package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "addToOrder", new AddToOrder() );
        commands.put( "deleteFromOrder", new DeleteFromOrder() );
        commands.put( "getAllCustomers", new GetAllCustomers() );
        commands.put( "getAllOrders", new GetAllOrders() );
        commands.put( "getCustomer", new GetCustomer() );
        commands.put( "myOrders", new MyOrders() );
        commands.put( "pay", new Pay() );
        commands.put( "removeOrder", new RemoveOrder() );
        commands.put( "showBasket", new ShowBasket() );
        commands.put( "showFrontPage", new ShowFrontPage() );
        commands.put( "updateOrder", new UpdateOrder() );
        commands.put( "updateUser", new UpdateUser() );
        commands.put( "viewOrder", new ViewOrder() );
        commands.put( "logout", new Logout());
        commands.put( "beginEditUser", new BeginEditUser());
        commands.put( "AdminDashboard", new AdminDashboard());
    }

    static Command from( HttpServletRequest request ) {
        String TagetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TagetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
