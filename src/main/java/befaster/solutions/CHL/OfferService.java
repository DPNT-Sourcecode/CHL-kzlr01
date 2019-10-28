package befaster.solutions.CHL;

import java.util.*;

public class OfferService {

    //Ideally from a persistance
    private List<CountOffer> currentOffers = new ArrayList<CountOffer>(){
        {
            add(new CountOffer("A",5, 200));
            add(new CountOffer("A",3, 130));
            add(new CountOffer("B",2, 45));
        }
    };


    public Optional<CountOffer> getOfferFor(String sku){
        for (CountOffer countOffer : currentOffers){
            if(countOffer.getSku().equals(sku)) return Optional.of(countOffer);
        }
        return Optional.empty();
    }

}





