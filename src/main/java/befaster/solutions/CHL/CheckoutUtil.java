package befaster.solutions.CHL;

import java.util.HashMap;
import java.util.Map;

class CheckoutUtil {

    private Result getResult(Integer total, Integer offer) {
        return new Result(total / offer, total % offer);
    }

    public Integer getTotalPrice(String skus){


    }


    private Map<String,Integer> getSkuCountMap(String skus){

        Map<String,Integer> priceList = new HashMap<String,Integer>(){
            {
                put("A",50);
                put("B",30);
                put("C",20);
                put("D",15);
            }
        };
        String[] items = skus.split("");
        //A,B,C,D,A
        for(String thisItem: items){

        }

    }


}