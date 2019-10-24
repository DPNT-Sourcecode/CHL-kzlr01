package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

public class OfferService {


    //Ideally from a persistance
    private static Map<String,Integer> priceList = new HashMap<String,Integer>(){
        {
            put("A",50);
            put("B",30);
            put("C",20);
            put("D",15);
        }
    };

    public static Map<String, Integer> getPriceList() {
        return priceList;
    }


    +------+-------+----------------+
            | Item | Price | Special offers |
            +------+-------+----------------+
            | A    | 50    | 3A for 130     |
            | B    | 30    | 2B for 45      |
            | C    | 20    |                |
            | D    | 15    |                |
            +------+-------+----------------+

}


