package befaster.solutions.CHL;

class MathUtil {

    Result getResult(Integer dividend, Integer divisor) {
        return new Result(dividend / divisor, dividend % divisor);
    }

}