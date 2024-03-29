package befaster.solutions.CHL;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class CheckoutUtilTest {

    private CheckoutUtil checkoutUtil;

    private Map<String, Integer> countExample1 = new HashMap<String, Integer>() {
        {
            put("A", 1);
            put("B", 3);
        }
    };

    private Map<String, Integer> countExample2 = new HashMap<String, Integer>() {
        {
            put("A", 1);
            put("B", 3);
            put("E", 4);  // to remove 2 B
        }
    };


    @Before
    public void setUp() {
        checkoutUtil = new CheckoutUtil();
    }

//    @Test
//    public void applyBuyGetOffer_ShouldReturnTheSameListWhenThereIsNo_SpecialOffer() {
//        Map<String, Integer> actual = checkoutUtil.applyBuyGetOffer(countExample1);
//        assertThat(actual.get("A"), equalTo(1));
//        assertThat(actual.get("B"), equalTo(3));
//    }
//
//    @Test
//    public void applyBuyGetOffer_ShouldRemoveItemsUnderSpecialOffer() {
//        Map<String, Integer> actual = checkoutUtil.removeFreeItems(countExample2);
//        assertThat(actual.get("A"), equalTo(1));
//        assertThat(actual.get("B"), equalTo(1));
//        assertThat(actual.get("E"), equalTo(4));
//    }

    @Test
    public void getTotalPrice_shouldReturnTheCorrectValues(){
        assertThat(checkoutUtil.getTotalPrice("A"), equalTo(50));
        assertThat(checkoutUtil.getTotalPrice("AB"), equalTo(80));
        assertThat(checkoutUtil.getTotalPrice("AAAB"), equalTo(130 + 30));
        assertThat(checkoutUtil.getTotalPrice("AAABAA"), equalTo(200 + 30));
        assertThat(checkoutUtil.getTotalPrice("AAABAAC"), equalTo(200 + 30 + 20));
        assertThat(checkoutUtil.getTotalPrice("EEB"), equalTo(80));
        assertThat(checkoutUtil.getTotalPrice("EEEB"), equalTo(120));
        assertThat(checkoutUtil.getTotalPrice("EEEEBB"), equalTo(160));
        assertThat(checkoutUtil.getTotalPrice("ABCa"), equalTo(-1));
    }

    @Test
    public void getTotalPrice_shouldReturnTheCorrectValuesEvenIfTheOfferIsOnSameSkus(){
        assertThat(checkoutUtil.getTotalPrice("FF"), equalTo(20));
        assertThat(checkoutUtil.getTotalPrice("FFF"), equalTo(20));
        assertThat(checkoutUtil.getTotalPrice("FFFF"), equalTo(30));
        assertThat(checkoutUtil.getTotalPrice("FFFFFF"), equalTo(40));
        assertThat(checkoutUtil.getTotalPrice("FFFFFF"), equalTo(40));


        - {"method":"checklite","params":["AAAAA"],"id":"CHL_R4_038"}, expected: 200, got: 230
                - {"method":"checklite","params":["AAAAAA"],"id":"CHL_R4_039"}, expected: 250, got: 260
                - {"method":"checklite","params":["AAAAAAA"],"id":"CHL_R4_040"}, expected: 300, got: 310
    }


}
