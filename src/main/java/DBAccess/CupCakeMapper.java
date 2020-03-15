package DBAccess;

import FunctionLayer.TopAndBottoms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CupCakeMapper {
    public TopAndBottoms getTopAndBottoms(){
        try {
            Connection con = Connector.connection();
            TopAndBottoms topsAndBottoms = new TopAndBottoms();
            ArrayList<String> topList = new ArrayList();
            ArrayList<String> bottomList = new ArrayList();
            //Hvor smart er det egentlig det her?
            //Vi har ét objekt som er opbygget af to lister med strings.
            //Vi har ikke noget sted at opbevare priserne.
            //Det skal enten gøres som et map (hvilket kan resultere i at rækkefølgen de vises
            // i på siden ændrer sig fra gang til gang)
            //Ellers skal vi have en Topping og en Bottom klasse som indeholder navn og pris ( evt + id).
            // (Det fylder måske mere i hukommelsen, men det bliver nemmere at holde styr på dem.)
            String SQLBottom = "SELECT cb_name, cb_price FROM cupcake_bottom";
            String SQLTopping = "SELECT cp_name, cp_price FROM cupcake_top";
            PreparedStatement ps = con.prepareStatement(SQLBottom);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ) {
                String bottomName = rs.getString("cb_name");
                int price = rs.getInt("cb_price");

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
