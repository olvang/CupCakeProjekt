package FunctionLayer;

import DBAccess.CupCakeMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, false,0);
        UserMapper.createUser( user );
        return user;
    }

    private static TopAndBottoms getTopAndBottoms() {
        return new CupCakeMapper().getTopAndBottoms();
    }

    public static ArrayList<Bottom> getBottoms() {
        return CupCakeMapper.getBottoms();
    }

    public static ArrayList<Topping> getToppings() {
        return CupCakeMapper.getToppings();
    }

}
