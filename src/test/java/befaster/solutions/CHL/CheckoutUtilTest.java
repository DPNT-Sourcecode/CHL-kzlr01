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

    @Test
    public void removeFreeItems_ShouldReturnTheSameListWhenThereIsNo_SpecialOffer() {
        Map<String, Integer> actual = checkoutUtil.removeFreeItems(countExample1);
        assertThat(actual.get("A"), equalTo(1));
        assertThat(actual.get("B"), equalTo(3));
    }

    @Test
    public void removeFreeItems_ShouldRemoveItemsUnderSpecialOffer() {
        Map<String, Integer> actual = checkoutUtil.removeFreeItems(countExample2);
        assertThat(actual.get("A"), equalTo(1));
        assertThat(actual.get("B"), equalTo(1));
        assertThat(actual.get("E"), equalTo(4));
    }

    @Test
    public void getTotalPrice_shouldReturnTheCorrectValues(){
//        assertThat(checkoutUtil.getTotalPrice("A"), equalTo(50));
//        assertThat(checkoutUtil.getTotalPrice("AB"), equalTo(80));
//        assertThat(checkoutUtil.getTotalPrice("AAAB"), equalTo(130 + 30));
//        assertThat(checkoutUtil.getTotalPrice("AAABAA"), equalTo(200 + 30));
//        assertThat(checkoutUtil.getTotalPrice("AAABAAC"), equalTo(200 + 30 + 20));
        assertThat(checkoutUtil.getTotalPrice("EEB"), equalTo(200));
    }

}
