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
            put("E", 4);  // to remove 2 B
        }
    };



    @Before
    public void setUp() {
        checkoutUtil = new CheckoutUtil();
    }

    @Test
    public void blah() {
        Map<String, Integer> actual = checkoutUtil.removeFreeItems(countExample1);
        assertThat(actual.get("B"), equalTo(2));

    }


}