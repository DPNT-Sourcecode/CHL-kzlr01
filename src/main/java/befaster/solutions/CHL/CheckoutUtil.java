package befaster.solutions.CHL;

class CheckoutUtil {

    public Result getResult(Integer total, Integer offer) {

        new Result(total/ offer, total % offer);

    }
}