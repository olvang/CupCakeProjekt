package DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticsMapper {

    public static int getAmountOfOrders(){
        int amount = 0;

        try {
            Connection con = Connector.connection();

            String SQL = "SELECT count(*) as amount FROM olskercupcake.orders";

            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                amount = rs.getInt("amount");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amount;
    }
    public static int getAmountOfCupcakes(){
        int amount = 0;

        try {
            Connection con = Connector.connection();

            String SQL = "SELECT sum(amount) as amount FROM olskercupcake.order_line";

            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                amount = rs.getInt("amount");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amount;
    }

    public static int getAmountOfUsers(){
        int amount = 0;

        try {
            Connection con = Connector.connection();

            String SQL = "SELECT count(*) as amount FROM users;";

            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                amount = rs.getInt("amount");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amount;
    }
}
