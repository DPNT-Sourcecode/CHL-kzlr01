package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class OfferServiceTest {

    private OfferService offerService;

    private List<CountOffer> countOffers = new ArrayList<CountOffer>() {
        {
            add(new CountOffer("A", 5, 200));
            add(new CountOffer("A", 3, 130));
        }
    };

    private Map<String, Integer> invalidOrder = new HashMap<String, Integer>() {
        {
            put("X", 10);
        }
    };

    private Map<String, Integer> orderWithoutBuyGetOffer = new HashMap<String, Integer>() {
        {
            put("A", 1);
            put("B", 10);
        }
    };
    private Map<String, Integer> orderWithBuyGetOffer = new HashMap<String, Integer>() {
        {
            put("A", 1);
            put("B", 10);
            put("E", 15);
        }
    };

    private List<BuyGetOffer> expectedBuyGetOffers = new ArrayList<BuyGetOffer>() {
        {
            add(new BuyGetOffer("E", 2, "B", 1));
            add(new BuyGetOffer("F", 2, "F", 1));
            add(new BuyGetOffer("N", 3, "M", 1));
            add(new BuyGetOffer("R", 3, "Q", 1));
            add(new BuyGetOffer("U", 3, "U", 1));
        }
    };
    @Before
    public void setUp() {
        offerService = new OfferService();
    }

    @Test
    public void getCountOffersFor_returnsEmptyListWhenNoOfferForSku() {
        assertThat(offerService.getCountOffersFor("X"), equalTo(Collections.emptyList()));

    }

    @Test
    public void getCountOffersFor_returnsOfferList() {
        List<CountOffer> actualOffers = offerService.getCountOffersFor("A");

        assertThat(actualOffers.get(0).getOfferCount(), equalTo(3));
        assertThat(actualOffers.get(0).getOfferPrice(), equalTo(130));

        assertThat(actualOffers.get(1).getOfferCount(), equalTo(5));
        assertThat(actualOffers.get(1).getOfferPrice(), equalTo(200));
    }

    @Test
    public void getAllBuyGetOffers_returnsAllBuyGetOffers(){
        List<BuyGetOffer> actualOffers = offerService.getAllBuyGetOffers();

        assertThat(actualOffers.get(0).getBuyCount(), equalTo(2));
        assertThat(actualOffers.get(0).getFreeCount(), equalTo(1));

    }
}