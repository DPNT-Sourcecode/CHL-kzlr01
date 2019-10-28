package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;

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

    private Map<String, Integer> order1 = new HashMap<String, Integer>() {
        {
            put("A", 1);
        }
    };
    
    private Map<String, Integer> order1 = new HashMap<String, Integer>() {
        {
            put("A", 1);
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

        assertThat(actualOffers.get(0).getOfferCount(), equalTo(5));
        assertThat(actualOffers.get(0).getOfferPrice(), equalTo(200));
        assertThat(actualOffers.get(1).getOfferCount(), equalTo(3));
        assertThat(actualOffers.get(1).getOfferPrice(), equalTo(130));
    }

    @Test
    public void getFreeItems_returnEmptyList() {

        offerService.getFreeItems()
    }


}

