package befaster.solutions.HLO;

import befaster.solutions.exceptions.InvalidComputeParamException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class HelloSolutionTest {
    private HelloSolution helloSolution;

    private String expectedValue = "Hello, World!";

    @Before
    public void setUp() {
        helloSolution = new HelloSolution();
    }


    @Test
    public void returnEmptyWhenEmptyParam() {
        assertThat(helloSolution.hello(""), equalTo(""));
    }

    @Test
    public void returnMessageWithAHelloPrefix() {
        assertThat(helloSolution.hello("anything"), equalTo(expectedValue));
    }

    @Test
    public void returnMessageWithAHelloPrefixEvenWithNewLineChar() {
        assertThat(helloSolution.hello("\nsomething"), equalTo(expectedValue));
    }
}