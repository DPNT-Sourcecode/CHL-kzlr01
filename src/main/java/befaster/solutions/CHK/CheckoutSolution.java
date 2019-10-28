package befaster.solutions.CHK;


import befaster.solutions.CHL.CheckoutUtil;

public class CheckoutSolution {

    CheckoutUtil checkoutUtil = new CheckoutUtil();

    public Integer checklite(String skus) {
        return checkoutUtil.getTotalPrice(skus);
    }
}

