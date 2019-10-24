package befaster.solutions.SUM;

import befaster.solutions.exceptions.InvalidComputerParamException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {
    private SumSolution sum;

    private int MIN = 0;
    private int MAX = 100;

    @Before
    public void setUp() {
        sum = new SumSolution();
    }

    @Test(expected = InvalidComputerParamException.class)
    public void whenTheFirstParamisNegative_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(-1,0);
    }
    @Test(expected = InvalidComputerParamException.class)
    public void whenTheSecondParamisNegative_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(0,-2);
    }
    @Test(expected = InvalidComputerParamException.class)
    public void whenBothParamsAreNegative_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(-1,-3);
    }
    @Test(expected = InvalidComputerParamException.class)
    public void whenTheFirstParamisBeyondMaximum_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(101,0);
    }
    @Test(expected = InvalidComputerParamException.class)
    public void whenTheSecondParamisBeyondMaximum_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(0,101);
    }

    @Test
    public void itShouldSumBothValidParams() {
        assertThat( sum.compute(0,0), equalTo(0));
        assertThat( sum.compute(0,100), equalTo(100));
        assertThat( sum.compute(15,100), equalTo(115));
        assertThat( sum.compute(100,45), equalTo(145));
        assertThat( sum.compute(100,0), equalTo(100));
    }


    //        assertThat(sum.compute(-1, -2), equalTo(2));
}



