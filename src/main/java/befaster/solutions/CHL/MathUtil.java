package befaster.solutions.CHL;

public class MathUtil {

    private Result getResult(Integer total, Integer offer) {
        return new Result(total / offer, total % offer);
    }

}