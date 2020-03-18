package DBAccess;

import FunctionLayer.Staistics;
import FunctionLayer.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public static int getTotalSale(){
        int TotalSale = 0;

        try {
            Connection con = Connector.connection();

            String SQL = "SELECT sum(price) as price from orders";

            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                TotalSale = rs.getInt("price");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TotalSale;
    }
    public static ArrayList<Staistics> getLast5(){
        ArrayList<Staistics> list  = new ArrayList<>();

        try {
            Connection con = Connector.connection();

            String SQL = "SELECT orders.o_id,orders.created_at, users.email, orders.price, sum(order_line.amount) as sum " +
                    "FROM users " +
                    "join orders on orders.u_id = users.u_id " +
                    "join order_line on orders.o_id = order_line.o_id " +
                    "group by orders.o_id " +
                    "order by orders.created_at desc " +
                    "limit 5\n";

            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while( rs.next() ) {
                Staistics stats = new Staistics();

                stats.setEmail(rs.getString("email"));
                stats.setPrice(rs.getInt("price"));
                stats.setAmountOfCupcakes(rs.getInt("sum"));
                stats.setCreatedAt(rs.getString("created_at"));
                stats.setO_id(rs.getInt("o_id"));

                list.add(stats);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public static Map<Integer,Integer> getOrdersByMonth(int year){
        Map<Integer,Integer> map = Utility.populateMap();
            try {

                Connection con = Connector.connection();

                String SQL = "SELECT YEAR(created_at) as SalesYear,\n" +
                        "         MONTH(created_at) as SalesMonth,\n" +
                        "         SUM(price) AS TotalSales,\n" +
                        "         count(*) as TotalOrders\n" +
                        "    FROM orders\n" +
                        "    where YEAR(created_at) = ?\n" +
                        "GROUP BY YEAR(created_at), MONTH(created_at)\n" +
                        "ORDER BY YEAR(created_at), MONTH(created_at)";

                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setInt( 1, year);
                ResultSet rs = ps.executeQuery();

                while( rs.next() ) {
                    map.put(rs.getInt("SalesMonth"),rs.getInt("TotalSales"));
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return map;
    }
}
