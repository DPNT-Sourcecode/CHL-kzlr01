package befaster.solutions.CHL;

class CheckoutUtil {

    private Result getResult(Integer total, Integer offer) {
        return new Result(total / offer, total % offer);
    }

    public Integer getTotalPrice(String skus){

    }


}


