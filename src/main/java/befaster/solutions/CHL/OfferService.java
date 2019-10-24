package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OfferService {


    //Ideally from a persistance
    private static Set<Offer> currentOffers = new HashSet<Offer>(){
        {
            add(new Offer())
        }
    };

    public static Set<Offer> getCurrentOffer() {
        return currentOffers;
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




