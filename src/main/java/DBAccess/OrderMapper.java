package DBAccess;

import FunctionLayer.CupCake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
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

    public static Order getOrder(int orderID) throws LoginSampleException {
        Order order = new Order();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders " +
                    "LEFT JOIN order_line " +
                    "ON orders.o_id=order_line.o_id " +
                    "LEFT JOIN users " +
                    "ON orders.u_id=users.u_id " +
                    "WHERE orders.o_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String email = rs.getString("email");
                boolean admin = rs.getBoolean("admin");
                double balance = rs.getDouble("balance");
                int userId = rs.getInt("u_id");
                User customer = new User(email, admin, balance);
                customer.setId(userId);
                order.setCustomer(customer);
                do {
                    //TODO tilføj hver cupcake til ordre. Kataloget skal tjekkes her.
                }while (rs.next());
            }else {
                throw new LoginSampleException( "No order by id" + orderID );
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return order;
    }

    public static ArrayList<Order> getAllOrders() throws LoginSampleException {
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = Connector.connection();
            //TODO select email from the customer as well
            String SQL = "SELECT orders.o_id, orders.pick_up_date, orders.created_at, sum(amount) as amount " +
                    "FROM orders " +
                    "LEFT JOIN order_line " +
                    "ON orders.o_id=order_line.o_id " +
                    "GROUP BY order_line.o_id " +
                    "ORDER BY o_id ASC;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);

            if(rs.next() ) {
                do {
                    int id = rs.getInt("orders.o_id");
                    int amountOfCupcakes = rs.getInt("amount");
                    Date date = rs.getDate("orders.pick_up_date");
                    //Timestamp ts = rs.getTimestamp("orders.created_at");
                    Order order = new Order();
                    order.setOrderId(id);
                    order.setAmount(amountOfCupcakes);
                    order.setPickupDate(date);
                    //order.setCreationTime(ts);
                    orders.add(order);
                } while(rs.next());
            } else {
                throw new LoginSampleException( " No orders! ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public static ArrayList<Order> getAllOrdersFromUser(int userID) throws LoginSampleException {
        ArrayList<Order> orders = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT orders.o_id, orders.pick_up_date, orders.created_at, sum(amount) as amount " +
                    "FROM orders " +
                    "LEFT JOIN order_line " +
                    "ON orders.o_id=order_line.o_id " +
                    "WHERE orders.u_id = ? " +
                    "GROUP BY order_line.o_id " +
                    "ORDER BY o_id ASC;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);

            if(rs.next() ) {
                do {
                    int id = rs.getInt("orders.o_id");
                    int amountOfCupcakes = rs.getInt("amount");
                    Date date = rs.getDate("orders.pick_up_date");
                    Timestamp ts = rs.getTimestamp("orders.created_at");
                    Date createdate = new Date(ts.getTime());
                    Order order = new Order();
                    order.setOrderId(id);
                    order.setAmount(amountOfCupcakes);
                    order.setPickupDate(date);
                    order.setOrderDate(createdate);
                    orders.add(order);
                } while(rs.next());
            } else {
                throw new LoginSampleException( "No user with id " + userID );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
