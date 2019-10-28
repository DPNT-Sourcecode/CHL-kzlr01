package befaster.solutions.CHL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;


public class OfferServiceTest {

    private OfferService offerService;

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
        assertThat(offerService.getCountOffersFor("A"), equalTo(Collections.emptyList()));

    }


}