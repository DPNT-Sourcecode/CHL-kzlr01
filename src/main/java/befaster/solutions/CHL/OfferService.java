package befaster.solutions.CHL;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OfferService {

    //Ideally from a persistance
    private Set<Offer> currentOffers = new HashSet<Offer>(){
        {
            add(new Offer("A",5, 130));
            add(new Offer("A",3, 130));
            add(new Offer("B",2, 45));
        }
    };


    public Optional<Offer> getOfferFor(String sku){
        for (Offer offer : currentOffers){
            if(offer.getSku().equals(sku)) return Optional.of(offer);
        }
        return Optional.empty();
    }

}




