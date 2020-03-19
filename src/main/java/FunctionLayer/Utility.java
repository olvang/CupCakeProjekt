package FunctionLayer;

import java.util.HashMap;
import java.util.Map;

public class Utility {

    public static Map<Integer,Integer> populateMap(){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 1; i < 12; i++){
            map.put(i,0);
        }

        return map;
    }
}
