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
        checkliteSolution = new CheckliteSolution();
    }

    @Test
    public void whenEmptySKus() {
        assertThat(checkliteSolution.checklite(emptySkUs), equalTo(-1));

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

    @Test
    public void caseWithCountOffer() {
        assertThat(checkliteSolution.checklite("AAA"), equalTo(130));
        assertThat(checkliteSolution.checklite("ABAAAA"), equalTo((200 + 30)));
        assertThat(checkliteSolution.checklite("BB"), equalTo(45));

    }

    @Test
    public void caseWithBuyGetOffer() {
        assertThat(checkliteSolution.checklite("AEEB"), equalTo(80+50+0));

    }
    @Test
    public void caseWithAnItemInBuyGetButNotQualified() {
        assertThat(checkliteSolution.checklite("E"), equalTo(40));

    }
}
