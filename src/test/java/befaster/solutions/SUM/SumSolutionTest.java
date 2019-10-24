package befaster.solutions.SUM;

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

    @Test(expected = InvalidComputerParamException)
    public void whenTheFirstParamisNegative_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(-1,0);
    }
    @Test(expected = InvalidComputerParamException)
    public void whenTheSecondParamisNegative_ItShouldThrow_InvalidComputerParamException() {
        sum.compute(0,-2);
    }


    //        assertThat(sum.compute(-1, -2), equalTo(2));
}

