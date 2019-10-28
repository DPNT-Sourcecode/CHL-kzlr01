package befaster.solutions.CHL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    public void whenEmptySKus() {
        assertThat(offerService.getCountOffersFor("A"), equalTo(new ArrayList<>()));

    }

    @Test
    public void whenEmSKus() {
        assertThat(checkliteSolution.checklite(""), equalTo(-1));

    }

    @Test
    public void caseWithJustOneCount() {
        assertThat(checkliteSolution.checklite("A"), equalTo(50));
        assertThat(checkliteSolution.checklite("B"), equalTo(30));
        assertThat(checkliteSolution.checklite("E"), equalTo(40));

    }

}