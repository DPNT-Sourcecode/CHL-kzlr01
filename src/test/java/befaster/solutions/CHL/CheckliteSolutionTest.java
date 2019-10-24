package befaster.solutions.CHL;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class CheckliteSolutionTest {

    private String emptySkUs = "";
    private String oneSku = "A";
    private String noOfferSKUs = "ADE";
    private String sKUsWithOffer = "ADEA";

    private CheckliteSolution checkliteSolution;

    @Before
    public void setUp() {
        checkliteSolution= new CheckliteSolution();
    }

    @Test
    public void whenEmptySKus() {
        assertThat( checkliteSolution.checklite(""), equalTo(-1));
        
    }
}