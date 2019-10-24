package befaster.solutions.SUM;

import befaster.solutions.exceptions.InvalidComputeParamException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {
    private SumSolution sumSolution;

    @Before
    public void setUp() {
        sumSolution= new SumSolution();
    }

    @Test(expected = InvalidComputeParamException.class)
    public void whenTheFirstParamisNegative_ItShouldThrow_InvalidComputeParamException() throws InvalidComputeParamException{
        sumSolution.sum(-1,0);
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenTheSecondParamisNegative_ItShouldThrow_InvalidComputeParamException() throws InvalidComputeParamException{
        sumSolution.sum(0,-2);
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenBothParamsAreNegative_ItShouldThrow_InvalidComputeParamException() throws InvalidComputeParamException{
        sumSolution.sum(-1,-3);
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenTheFirstParamisBeyondMaximum_ItShouldThrow_InvalidComputeParamException() throws InvalidComputeParamException{
        sumSolution.sum(101,0);
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenTheSecondParamisBeyondMaximum_ItShouldThrow_InvalidComputeParamException() throws InvalidComputeParamException{
        sumSolution.sum(0,101);
    }

    @Test
    public void itShouldSumBothValidParams() throws InvalidComputeParamException {
        assertThat( sumSolution.sum(0,0), equalTo(0));
        assertThat( sumSolution.sum(0,100), equalTo(100));
        assertThat( sumSolution.sum(15,100), equalTo(115));
        assertThat( sumSolution.sum(100,45), equalTo(145));
        assertThat( sumSolution.sum(100,0), equalTo(100));
    }


    //        assertThat(sumSolution.sum(-1, -2), equalTo(2));
}

