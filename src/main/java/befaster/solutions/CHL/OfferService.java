package befaster.solutions.CHL;

import java.util.HashSet;
import java.util.Set;

public class OfferService {

    //Ideally from a persistance
    private Set<Offer> currentOffers = new HashSet<Offer>(){
        {
            add(new Offer("A",3, 130));
            add(new Offer("B",2, 45));
        }
    };

    Set<Offer> getCurrentOffer() {
        return currentOffers;
    }

}




