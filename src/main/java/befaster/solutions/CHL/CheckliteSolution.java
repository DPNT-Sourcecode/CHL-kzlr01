package befaster.solutions.CHL;

public class CheckliteSolution {

    private CheckoutUtil checkoutUtil = new CheckoutUtil();

    public Integer checklite(String skus) {
        if (skus.isEmpty()) return 0;
        return checkoutUtil.getTotalPrice(skus);
    }
}


