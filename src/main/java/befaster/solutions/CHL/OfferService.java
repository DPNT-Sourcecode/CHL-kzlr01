package befaster.solutions.CHL;

import java.util.*;
import java.util.stream.Collectors;

public class OfferService {

    private MathUtil mathUtil = new MathUtil();
/*
    //Ideally from a persistance or injected repo which can be mocked in the unit test
    private List<CountOffer> countOffers = new ArrayList<CountOffer>() {
        {
            add(new CountOffer("A", 5, 200));
            add(new CountOffer("A", 3, 130));
            add(new CountOffer("B", 2, 45));
        }
    };

    //Ideally from a persistance or injected repo which can be mocked in the unit test
    private List<BuyGetOffer> buyGetOffers = new ArrayList<BuyGetOffer>() {
        {
            add(new BuyGetOffer("E", 2, "B", 1));
            add(new BuyGetOffer("F", 2, "F", 1));
        }
    };
    */


    //Ideally from a persistance or injected repo which can be mocked in the unit test
    private List<CountOffer> countOffers = new ArrayList<CountOffer>() {
        {
            add(new CountOffer("A", 5, 200));
            add(new CountOffer("A", 3, 130));
            add(new CountOffer("B", 2, 45));
        }
    };

    //Ideally from a persistance or injected repo which can be mocked in the unit test
    private List<BuyGetOffer> buyGetOffers = new ArrayList<BuyGetOffer>() {
        {
            add(new BuyGetOffer("E", 2, "B", 1));
            add(new BuyGetOffer("F", 2, "F", 1));
        }
    };

    public List<CountOffer> getCountOffersFor(String sku) {
        return countOffers.stream().filter(o -> o.getSku().equals(sku)).collect(Collectors.toList());
    }

    List<BuyGetOffer> getAllBuyGetOffers() {
        return buyGetOffers;
    }

}




