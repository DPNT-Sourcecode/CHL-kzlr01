package befaster.solutions.CHL;

import static org.junit.Assert.*;

public class CheckliteSolutionTest {

    private String emptySkUs = "";
    private String oneSku = "A";
    private String noOfferSKUs = "ADE";
    private String sKUsWithOffer = "ADEA";

    private SumSolution sumSolution;

    @Before
    public void setUp() {
        sumSolution= new SumSolution();
    }

    @Test(expected = InvalidComputeParamException.class)
    public void whenTheFirstParamisNegative_ItShouldReturnNull() {
        assertThat( sumSolution.sum(-1,0), equalTo(null));
    }
}