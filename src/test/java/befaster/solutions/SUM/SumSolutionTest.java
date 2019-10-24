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
    public void whenTheFirstParamisNegative_ItShouldReturnNull() {
        assertThat( sumSolution.sum(-1,0), equalTo(null));
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenTheSecondParamisNegative_ItShouldReturnNull() {
        assertThat( sumSolution.sum(0,-2), equalTo(null));
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenBothParamsAreNegative_ItShouldReturnNull() {
        assertThat( sumSolution.sum(-1,-3), equalTo(null));
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenTheFirstParamisBeyondMaximum_ItShouldReturnNull() {
        assertThat( sumSolution.sum(101,0), equalTo(null));
    }
    @Test(expected = InvalidComputeParamException.class)
    public void whenTheSecondParamisBeyondMaximum_ItShouldReturnNull() {
        assertThat( sumSolution.sum(0,101), equalTo(null));
   }

    @Test
    public void itShouldSumBothValidParams()  {
        assertThat( sumSolution.sum(0,0), equalTo(0));
        assertThat( sumSolution.sum(0,100), equalTo(100));
        assertThat( sumSolution.sum(15,100), equalTo(115));
        assertThat( sumSolution.sum(100,45), equalTo(145));
        assertThat( sumSolution.sum(100,0), equalTo(100));
    }


    //    @Test(expected = InvalidComputeParamException.class)
//    public void whenTheFirstParamisNegative_ItShouldReturnNull() {
//        sumSolution.sum(-1,0);
//    }
//    @Test(expected = InvalidComputeParamException.class)
//    public void whenTheSecondParamisNegative_ItShouldReturnNull() {
//        sumSolution.sum(0,-2);
//    }
//    @Test(expected = InvalidComputeParamException.class)
//    public void whenBothParamsAreNegative_ItShouldReturnNull() {
//        sumSolution.sum(-1,-3);
//    }
//    @Test(expected = InvalidComputeParamException.class)
//    public void whenTheFirstParamisBeyondMaximum_ItShouldReturnNull() {
//        sumSolution.sum(101,0);
//    }
//    @Test(expected = InvalidComputeParamException.class)
//    public void whenTheSecondParamisBeyondMaximum_ItShouldReturnNull() {
//        sumSolution.sum(0,101);
//    }

    //        assertThat(sumSolution.sum(-1, -2), equalTo(2));
}
