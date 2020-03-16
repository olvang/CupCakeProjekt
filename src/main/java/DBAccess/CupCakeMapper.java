package DBAccess;

import FunctionLayer.Bottom;
import FunctionLayer.TopAndBottoms;
import FunctionLayer.Topping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CupCakeMapper {
    public TopAndBottoms getTopAndBottoms(){
        try {
            Connection con = Connector.connection();
            ArrayList<Bottom> bottomList = new ArrayList();
            ArrayList<Topping> toppingList = new ArrayList();

            String SQLBottom = "SELECT * FROM cupcake_bottom";
            String SQLTopping = "SELECT * FROM cupcake_top";
            PreparedStatement ps = con.prepareStatement(SQLBottom);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                int id = rs.getInt("cb_id");
                String bottomName = rs.getString("cb_name");
                int price = rs.getInt("cb_price");
                bottomList.add(new Bottom(id, bottomName, price));
            }
            rs.close();
            ps.close();
            ps = con.prepareStatement(SQLTopping);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("cp_id");
                String toppingName = rs.getString("cp_name");
                int price = rs.getInt("cp_price");
                toppingList.add(new Topping(id, toppingName, price));
            }
            return new TopAndBottoms(bottomList, toppingList);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
