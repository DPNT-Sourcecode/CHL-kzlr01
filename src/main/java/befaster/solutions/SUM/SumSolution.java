package befaster.solutions.SUM;

import befaster.solutions.exceptions.InvalidComputeParamException;

public class SumSolution {

    private static int MIN = 0;
    private static int MAX = 100;

    public int sum(int x, int y) throws InvalidComputeParamException {
        if (x < MIN || x > MAX || y < MIN || y > MAX) throw new InvalidComputeParamException(x + " and " + y);
        return x + y;
    }

}


