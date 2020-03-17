package DBAccess;

import FunctionLayer.CupCake;
import FunctionLayer.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderMapper {
    public static boolean saveOrder(Order order){
        int id = -1;
        try {

            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (u_id, pick_up_date) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS);

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            String mysqlDateString = formatter.format(order.getPickupDate());

            ps.setInt( 1, order.getUserId());
            ps.setString( 2, mysqlDateString);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            id = rs.getInt( 1 );
            
            for (CupCake cc: order.getOrderlines()) {
                String oSQL = "INSERT into order_line (o_id,cp_id,cb_id, amount) VALUES(?, ?, ?, ?)";
                PreparedStatement ops = con.prepareStatement(oSQL);

                ops.setInt(1,id);
                ops.setInt(2,cc.getTopId());
                ops.setInt(3,cc.getBottomId());
                ops.setInt(4,cc.getAmount());

                ops.executeUpdate();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id > 0;
    }

    public static Order getOrder(int orderID){

        return null;
    }

    public static ArrayList<Order> getAllOrders(){




        return null;
    }
}
